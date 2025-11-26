import 'package:flutter/material.dart';

void main() {
  runApp(const EscapeRoomApp());
}

class EscapeRoomApp extends StatelessWidget {
  const EscapeRoomApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Escape Room',
      initialRoute: '/',
      routes: {
        '/': (_) => const SalaInicial(),
        // Añade aquí las rutas que faltan
      },
    );
  }
}

// Aquí debes crear las clases:
// - SalaInicial
// - Pista1
// - Victoria
// - Atrapado

class SalaInicial extends StatelessWidget {
  const SalaInicial({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Escape Room')),
      body: Center(
        child: Column(
          children: [
            Column(
              children: [
                Text("Estás en una sala secreta de Hogwart."),
                Text("data2"),
                Text("pregunta"),
                Column(
                  children: [
                    ElevatedButton(onPressed: () {}, child: Text("opcion1")),
                    ElevatedButton(onPressed: () {}, child: Text("opcion2")),
                    ElevatedButton(onPressed: () {}, child: Text("opcion3")),
                    ElevatedButton(onPressed: () {}, child: Text("opcion4")),
                  ],
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

class Pista1 extends StatelessWidget {
  const Pista1({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pista 1')),
      body: const Center(child: Text('Segunda pantalla del Escape Room')),
    );
  }
}

class Victoria extends StatelessWidget {
  const Victoria({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Victoria')),
      body: const Center(child: Text('Has escapado con éxito')),
    );
  }
}

class Atrapado extends StatelessWidget {
  const Atrapado({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Game Over')),
      body: const Center(child: Text('Has quedado atrapado')),
    );
  }
}
