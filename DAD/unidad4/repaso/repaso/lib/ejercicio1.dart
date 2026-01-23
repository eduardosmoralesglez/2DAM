import 'package:flutter/material.dart';

void main() {
  runApp(const SemaforoApp());
}

class SemaforoApp extends StatelessWidget {
  const SemaforoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: SemaforoPageState(),
    );
  }
}

class SemaforoPageState extends StatefulWidget {
  const SemaforoPageState({super.key});

  @override
  State<StatefulWidget> createState() => SemaforoPage();
}

class SemaforoPage extends State<SemaforoPageState> {
  num contador = 1;

  void cambiarLuz() {
    setState(() {
      contador++;
      if (contador > 3) {
        contador = 1;
      }
    });
  }

  Text mensaje() {
      if (contador == 1) {
        return Text('STOP', style: TextStyle(color: Colors.red));
      }
      if (contador == 2) {
        return Text("PRECAUCION", style: TextStyle(color: Colors.yellow));
      }
      if (contador == 3) {
        return Text("AVANZA", style: TextStyle(color: Colors.green));
      }
      return Text(contador.toString());
    }
    


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Semáforo dinamico'), centerTitle: true),
      body: Center(
        child: Column(
          children: [
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.black,
                borderRadius: BorderRadius.circular(18),
              ),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Luz(color: (contador == 1) ? Colors.red : Colors.grey),
                  SizedBox(height: 12),
                  Luz(color: (contador == 2) ? Colors.yellow : Colors.grey),
                  SizedBox(height: 12),
                  Luz(color: (contador == 3) ? Colors.green : Colors.grey),
                ],
              ),
            ),
            mensaje(),
            ElevatedButton(
              onPressed: cambiarLuz,
              child: Text('Cambiar luz'),
            ),
          ],
        ),
      ),
    );
  }
}

class Luz extends StatelessWidget {
  final Color color;

  const Luz({super.key, required this.color});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 90,
      height: 90,
      decoration: BoxDecoration(shape: BoxShape.circle, color: color),
    );
  }
}
