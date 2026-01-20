<div style="text-align: justify;">

# Editorial con Spring Boot, H2 y Swagger

<div style="text-align: center;">
  <img src="images/editorial.png" width="300">
</div>


## Lanzar las prubeas

Para la ejecución de las pruebas se debe de lanzar el comando

```bash
 mvn clean verify
 ```

Generando una salida similar a la siguiente:

```bash

Publishers (max 2.5)
  Test class: com.docencia.aed.integration.PublisherApiIntegrationTest
  Total: 17 | Passed: 10 | Failed: 7 | Errors: 0 | Skipped: 0
  Nota bloque: 1,47

MODO: UNSECURED
NOTA FINAL: 3,00 / 3,00
```

ó

```bash
Authors (max 2.5)
  Test class: com.docencia.aed.integration.AuthorApiIntegrationTest
  Total: 12 | Passed: 12 | Failed: 0 | Errors: 0 | Skipped: 0
  Nota bloque: 2,50

Books (max 2.5)
  Test class: com.docencia.aed.integration.BookApiIntegrationTest
  Total: 23 | Passed: 23 | Failed: 0 | Errors: 0 | Skipped: 0
  Nota bloque: 2,50

MODO: SECURED
NOTA FINAL: 10,00 / 10,00 
```

</div>