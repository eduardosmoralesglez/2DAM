import { useRouter } from "expo-router";
import React, { useContext, useEffect, useState } from "react";
import { Button, Text, TextInput, View } from "react-native";
import { AuthContext } from "../context/AuthContext";
import Groups from "./groups";

export default function Home() {
  const { token, logout } = useContext(AuthContext);
  const router = useRouter();
  const [groups, setGroups] = useState([]);

  useEffect(() => {
    if (!token) {
      setTimeout(() => router.replace("/login"), 0);
    }
  }, [token]);

  if (!token) return null;

  return (
    <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
      <Text>Bienvenido a Home!</Text>
      <TextInput placeholder="Agrega el grupo"></TextInput>
      <Button title="Agregar" onPress={() => (router.replace("/groups"), 0)}></Button>

      <Button title="Cerrar sesión" onPress={() => void logout()} />
    </View>
  );
}
