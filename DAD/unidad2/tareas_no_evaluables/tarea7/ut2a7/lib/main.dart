import 'dart:ffi';

import 'package:flutter/material.dart';

void main() {
  runApp(const MiniJuegoEstado());
}

class MiniJuegoEstado extends StatefulWidget {
  const MiniJuegoEstado({super.key});

  @override
  State<MiniJuegoEstado> createState() => _MiniJuegoEstadoState();
}

class _MiniJuegoEstadoState extends State<MiniJuegoEstado> {
  int energia = 50;
  bool isDark = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        brightness: isDark ? Brightness.dark : Brightness.light,
        useMaterial3: true,
      ),
      home: Scaffold(
        appBar: AppBar(title: Text("Mini-juego: Gestión de estado")),
        body: Center(
          child: Column(
            children: [
              Text("ENERGÍA"),
              Text("data"),
              Text('$energia'),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  ElevatedButton(
                    onPressed: () {setState(() {
                      if (!(energia >= 100)) {
                        energia = energia +10;
                      }
                    });},
                    child: Row(
                      children: [
                        Icon(Icons.upgrade),
                        Text("Aumentar")],
                    ),
                  ),
                  ElevatedButton(
                    onPressed: () {setState(() {
                      if (!(energia <= 0)) {
                        energia = energia - 10;
                      }
                    });},
                    child: Row(
                      children: [
                        Icon(Icons.minimize),
                        Text("Aumentar")],
                    ),
                  ),
                  ElevatedButton(
                    onPressed: () {setState(() {
                      energia = 50;
                    });},
                    child: Row(
                      children: [
                        Icon(Icons.refresh_outlined),
                        Text("Aumentar"),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
          
        ),
      ),
    );
  }
}
