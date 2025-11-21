
import { router } from "expo-router";
import React from "react";
import { Button, TextInput, View } from "react-native";


export default function Groups() {

  return (
    <View style={{ flex: 1, justifyContent: "center", padding: 20 }}>
      
      <Button title="Registrarse" onPress={() => router.push("/register")} />
    </View>
  );

    
}