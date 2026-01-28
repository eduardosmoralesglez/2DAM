import 'package:flutter/material.dart';

void main() {
  runApp(const RotacionApp());
}

class RotacionApp extends StatelessWidget {
  const RotacionApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: RotacionPage(),
    );
  }
}

class RotacionPage extends StatefulWidget {
  const RotacionPage({super.key});

  @override
  State createState() => _RotacionPageState();
}

class _RotacionPageState extends State {
  double turns = 0;
  void giro() {
    setState(() {
      turns = turns + 1/4;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Rotación (con animación)')),
      body: Center(
        child: AnimatedRotation(
          curve: Curves.easeInOut,
          turns: turns,
          duration: Duration(milliseconds: 400),
          child: Icon(Icons.navigation, size: 90),
        ),
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: giro,
        icon: const Icon(Icons.rotate_right),
        label: const Text('Girar'),
      ),
    );
  }
}
