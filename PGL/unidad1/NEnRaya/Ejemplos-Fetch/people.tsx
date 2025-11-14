import React, { useCallback, useEffect, useState } from "react";
import { ActivityIndicator, Button, Text, TextInput, View } from "react-native";
import { fetchPersonById } from "./api/swapi";

export default function PeopleScreen() {
  const [id, setId] = useState("1");
  const [person, setPerson] = useState<any>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  // ✅ Con useCallback: mantiene la misma referencia mientras 'id' no cambie
  const fetchPerson = useCallback(async () => {
    console.log("✅ fetchPerson llamada (solo cambia si cambia el ID)");
    setLoading(true);
    setError(null);
    setPerson(null);

    try {
      const data = await fetchPersonById(id);
      setPerson(data);
    } catch (err: any) {
      setError(err.message || "Error desconocido");
    } finally {
      setLoading(false);
    }
  }, [id]);

  // 🔹 useEffect ejecutado solo cuando cambia la función (por el ID)
  useEffect(() => {
    console.log("🔹 useEffect ejecutado");
    fetchPerson();
  }, [id]);

  return (
    <View style={{ padding: 20 }}>
      <Text>Buscar personaje por ID (1-83):</Text>

      <TextInput
        style={{
          borderWidth: 1,
          borderColor: "#ccc",
          padding: 8,
          marginVertical: 10,
          textAlign: "center",
        }}
        value={id}
        onChangeText={setId}
        keyboardType="number-pad"
      />

      {/* 🔹 Botón para forzar actualización */}
      <Button title="Update" onPress={fetchPerson} />

      {loading && <ActivityIndicator size="small" />}
      {error && <Text style={{ color: "red", marginTop: 10 }}>{error}</Text>}
      {person && (
        <View style={{ marginTop: 10 }}>
          <Text>Nombre: {person.name}</Text>
          <Text>Altura: {person.height}</Text>
          <Text>Masa: {person.mass}</Text>
        </View>
      )}

      <Text style={{ marginTop: 20, fontStyle: "italic", color: "#666" }}>
        Observa la consola: el useEffect solo se ejecuta cuando cambia el ID, pero el botón "Update" fuerza fetchPerson aunque no cambie.
      </Text>
    </View>
  );
}
