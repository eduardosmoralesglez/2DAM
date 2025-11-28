import 'dart:async';

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
        '/pista1': (_) => const Pista1(),
        '/error': (_) => const Atrapado(),
        
      },
    );
  }
}

// Aquí debes crear las clases:
// - SalaInicial
// - Pista1
// - Victoria
// - Atrapado



class PreguntasWidget extends StatelessWidget {
  final String pregunta;
  final Map<String, bool> opciones;

  const PreguntasWidget({
    super.key,
    required this.pregunta, 
    required this.opciones,

  });

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: [
          Column(
            children: [
              Text(pregunta),
              Column(children: [
                ...opciones.entries.map((entry) {
                  return ElevatedButton(onPressed: () { 
                    entry.value ? Navigator.pushNamed(context, "/prueba") : Navigator.pushNamed(context, "/error");
                   }, child: Text(entry.key,),);
                } as Function(MapEntry<String, bool> e)).toList(),
              ]),
            ],
          ),
        ],
      ),
    );
  }
}

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
                PreguntasWidget(
                  pregunta: '¿Cuál es la casa a la que pertenece Harry Potter?', 
                  opciones: {
                    'Hufflepuf' : false,
                    'Gryffindor' : true,
                    'Slytherin' : false,
                    'Ravenclaw' :false
                  },
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
