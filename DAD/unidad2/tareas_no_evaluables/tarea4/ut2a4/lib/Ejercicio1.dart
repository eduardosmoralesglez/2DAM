import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        useMaterial3: false, // Desactivamos Material 3
      ),
      home: const Material2Page(),
    );
  }
}

class Material2Page extends StatelessWidget {
  const Material2Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Material 2")),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: const Icon(Icons.add),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Padding(
              padding: EdgeInsets.all(16),
              child: TextField(
                decoration: InputDecoration(label: Text("Inserta nombre")),
              ),
            ),
            ElevatedButton(onPressed: () {}, child: const Text("Enviar")),
          ],
        ),
      ),
    );
  }
}
