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
        '/victoria': (_) => const Victoria(),
        
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
  final String pathRespuesta;

  const PreguntasWidget({
    super.key,
    required this.pregunta, 
    required this.opciones, 
    required this.pathRespuesta,

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
                SizedBox(width: 10, height: 10,),
                ...opciones.entries.map((entry) {
                  return Column(
                    children: [
                      SizedBox(width: 25, height: 25,),
                      ElevatedButton(onPressed: () { 
                        entry.value ? Navigator.pushNamed(context, "/$pathRespuesta") : Navigator.pushNamed(context, "/error");
                       }, child: Text(entry.key,),),
                    ],
                  );
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
                Text("Primera pregunta"),
                PreguntasWidget(
                  pregunta: '¿Cuál es la casa a la que pertenece Harry Potter?', 
                  opciones: {
                    'Hufflepuf' : false,
                    'Gryffindor' : true,
                    'Slytherin' : false,
                    'Ravenclaw' :false
                  }, pathRespuesta: 'pista1',
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
      body: Center(
        child: Column(
              children: [
                Text("¡Has acertado!"),
                Text("Segunda pregunta"),
                PreguntasWidget(
                  pregunta: '¿Cómo se llama la estación de tren que da acceso a Hogwarts?', 
                  opciones: {
                    'Andén 9 ¾' : true,
                    'Estación Central de Londres' : false,
                    'Andén 7 ½' : false,
                    'Estación Hogsmeade Express' :false
                  }, pathRespuesta: 'victoria',
                ),
              ],
            ),
      ),
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
