import 'package:flutter/material.dart';

void main() {
  runApp(const MarcadorApp());
}

class MarcadorApp extends StatelessWidget {
  const MarcadorApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MarcadorPage(),
    );
  }
}

class MarcadorPage extends StatefulWidget {
  const MarcadorPage({super.key});

  @override
  State<StatefulWidget> createState() => MarcadorPageState();
}

enum Equipos { A, B }

class MarcadorPageState extends State {
  int equipoA = 0;
  int equipoB = 0;

  void gol(Equipos equipo) {
    setState(() {
      if (equipo == Equipos.A) {
        equipoA++;
      }
      if (equipo == Equipos.B) {
        equipoB++;
      }
    });
  }

  Text estado() {
    if (equipoA > equipoB) {
      return Text("Equipo A va ganando");
    }
    if (equipoB > equipoA) {
      return Text("Equipo B va ganando");
    }
    return Text("Empate");
  }

  void reset() {
    setState(() {
      equipoA = 0;
      equipoB = 0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Marcador dinámico')),
      body: Center(
        child: Column(
          children: [
            Text('Equipo A: $equipoA'),
            Text('Equipo B: $equipoB'),
            estado(),
            ElevatedButton(
              onPressed: () {
                gol(Equipos.A);
              },
              child: Text("+ 1 A"),
            ),
            ElevatedButton(
              onPressed: () {
                gol(Equipos.B);
              },
              child: Text("+ 1 B"),
            ),
            ElevatedButton(
              onPressed: () {
                reset();
              },
              child: Text("Reset"),
            ),
          ],
        ),
      ),
    );
  }
}
