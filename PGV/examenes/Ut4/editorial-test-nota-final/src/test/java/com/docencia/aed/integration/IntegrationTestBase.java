package com.docencia.aed.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Base para tests de integración con JWT.
 *
 * - Si existe la propiedad test.base-url, los tests apuntan a esa URL.
 * - Si no, apuntan al servidor levantado por Spring Boot en puerto aleatorio.
 */
public abstract class IntegrationTestBase {

    /**
     * Modo de ejecución:
     * - SECURED: la API exige Bearer token (401/403 si no hay token)
     * - UNSECURED: la API no está securizada (no requiere token)
     *
     * Se detecta automáticamente haciendo una llamada GET sin token.
     * Además se escribe un marcador en target/security-mode.txt para que el
     * calculador de nota pueda aplicar el "cap" correspondiente.
     */
    private static volatile Boolean SECURITY_ENABLED = null;

    @LocalServerPort
    private int port;

    @Autowired
    protected TestRestTemplate rest;

    @Value("${test.base-url:}")
    private String configuredBaseUrl;

    protected String baseUrl;

    protected final ObjectMapper om = new ObjectMapper();

    @BeforeEach
    void initBaseUrl() {
        String fromSysProp = System.getProperty("test.base-url"); 
        String chosen = (fromSysProp != null && !fromSysProp.isBlank())
                ? fromSysProp
                : configuredBaseUrl;

        baseUrl = (chosen != null && !chosen.isBlank())
                ? chosen.replaceAll("/$", "")
                : "http://localhost:" + port;

        // Detectar una única vez si el servicio está securizado.
        if (SECURITY_ENABLED == null) {
            SECURITY_ENABLED = detectSecurityEnabled();
            writeSecurityMarker(SECURITY_ENABLED);
        }
    }

    protected boolean isSecurityEnabled() {
        return Boolean.TRUE.equals(SECURITY_ENABLED);
    }

    private boolean detectSecurityEnabled() {
        try {
            // Si /authors sin token devuelve 401/403 -> securizado.
            ResponseEntity<String> res = get("/authors", null);
            HttpStatusCode sc = res.getStatusCode();
            return sc == HttpStatus.UNAUTHORIZED || sc == HttpStatus.FORBIDDEN;
        } catch (Exception e) {
            // Si algo va mal (p.ej. endpoint no existe aún), asumimos NO securizado
            // para no penalizar el arranque del corrector.
            return false;
        }
    }

    private void writeSecurityMarker(boolean secured) {
        try {
            java.nio.file.Path p = java.nio.file.Paths.get("target").resolve("security-mode.txt");
            java.nio.file.Files.createDirectories(p.getParent());
            java.nio.file.Files.writeString(p, secured ? "SECURED" : "UNSECURED");
        } catch (Exception ignored) {
        }
    }

    protected String url(String path) {
        assertNotNull(path);
        return baseUrl + (path.startsWith("/") ? path : ("/" + path));
    }

    protected String loginAndGetToken() {
        if (!isSecurityEnabled()) {
            // En modo no securizado no existe login, ni se requiere token.
            return null;
        }
        String loginUrl = url("/api/auth/login");
        Map<String, String> body = Map.of("username", "admin", "password", "admin123");

        ResponseEntity<String> res = rest.postForEntity(loginUrl, body, String.class);
        assertEquals(HttpStatus.OK, res.getStatusCode(), "Login debe devolver 200");
        assertNotNull(res.getBody());

        try {
            JsonNode node = om.readTree(res.getBody());
            assertTrue(node.hasNonNull("token"), "La respuesta debe contener token");
            return node.get("token").asText();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo parsear JSON del login: " + res.getBody(), e);
        }
    }

    protected HttpHeaders authHeaders(String token) {
        HttpHeaders h = new HttpHeaders();
        h.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));
        if (token != null) {
            h.setBearerAuth(token);
        }
        return h;
    }

    protected ResponseEntity<String> get(String path, String token) {
        HttpEntity<Void> req = new HttpEntity<>(authHeaders(token));
        return rest.exchange(url(path), HttpMethod.GET, req, String.class);
    }

    protected ResponseEntity<String> postJson(String path, String token, Object body) {
        HttpHeaders h = authHeaders(token);
        h.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> req = new HttpEntity<>(body, h);
        return rest.exchange(url(path), HttpMethod.POST, req, String.class);
    }

    void getServiceUnauthorizedTest(ResponseEntity<String> res) {
        if (!isSecurityEnabled()) {
            // Si no hay seguridad, nunca debe devolver 401/403.
            assertNotEquals(HttpStatus.UNAUTHORIZED, res.getStatusCode());
            assertNotEquals(HttpStatus.FORBIDDEN, res.getStatusCode());
            return;
        }
        invalidTocken(res.getStatusCode());
    }

    @Test
    void getAuthorsOkTest() {
        String token = loginAndGetToken();
        var res = get("/authors", token);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertNotNull(res.getBody());
        assertTrue(res.getBody().startsWith("[")); // lista JSON
    }

    @Test
    void getAuthorsInvalidTokenTest() {
        var res = get("/authors", "invalid.token.here");
        invalidTocken(res.getStatusCode());
    }

    // ===== GET /authors/{id} =====

    @Test
    void getAuthorByIdUnauthorizedTest() {
        var res = get("/authors/1", null);
        invalidTocken(res.getStatusCode());
    }

    @Test
    void getAuthorByIdOkTest() {
        String token = loginAndGetToken();
        var res = get("/authors/1", token);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertNotNull(res.getBody());
        assertTrue(res.getBody().contains("\"id\":1") || res.getBody().contains("\"id\": 1"));
    }

    @Test
    void getAuthorByIdInvalidTokenTest() {
                var res = get("/authors/1", "bad");
        invalidTocken(res.getStatusCode());
    }

    // ===== GET /authors/{id}/books =====

    @Test
    void getAuthorBooksUnauthorizedTest() {
        var res = get("/authors/1/books", null);
        invalidTocken(res.getStatusCode());
    }

    @Test
    void getAuthorBooksOkTest() {
        String token = loginAndGetToken();
        var res = get("/authors/1/books", token);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertNotNull(res.getBody());
        assertTrue(res.getBody().startsWith("["));
    }

    @Test
    void getAuthorBooksInvalidTokenTest() {
        var res = get("/authors/1/books", "invalid");
        invalidTocken(res.getStatusCode());
    }

    // ===== POST /authors =====

    @Test
    void createAuthorUnauthorizedTest() {
        var res = postJson("/authors", null, Map.of("name", "Test", "country", "ES"));
        invalidTocken(res.getStatusCode());
    }
    @Test
    void createAuthorOkTest() {
        String token = loginAndGetToken();
        var res = postJson("/authors", token, Map.of("name", "Autor Nuevo", "country", "ES"));
        assertEquals(HttpStatus.CREATED, res.getStatusCode());
        assertNotNull(res.getBody());
        assertTrue(res.getBody().contains("\"name\"") || res.getBody().contains("Autor Nuevo"));
    }

    @Test
    void createAuthorInvalidTokenTest() {
        var res = postJson("/authors", "bad", Map.of("name", "X", "country", "Y"));
        invalidTocken(res.getStatusCode());
    }

    void invalidTocken(HttpStatusCode status) {
        if (isSecurityEnabled()) {
            assertTrue(status == HttpStatus.UNAUTHORIZED || status == HttpStatus.FORBIDDEN);
        } else {
            // Sin seguridad, un token inválido/no presente no debe provocar 401/403
            assertNotEquals(HttpStatus.UNAUTHORIZED, status);
            assertNotEquals(HttpStatus.FORBIDDEN, status);
        }
    }
}
