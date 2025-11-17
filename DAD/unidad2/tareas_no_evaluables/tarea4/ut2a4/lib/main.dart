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
        useMaterial3: true,
      ),
      home: Column(
        children: [
          ElevatedButton(onPressed: () {
            Navigator.push(context, )
          }, child: Text("Ir a al pagina Material 2")),
          ElevatedButton(onPressed: () {}, child: Text("Ir a al pagina Material 3"))
        ],
      ),
    );
  }
}

class Material3Page extends StatelessWidget {
  const Material3Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Material 3")),
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
