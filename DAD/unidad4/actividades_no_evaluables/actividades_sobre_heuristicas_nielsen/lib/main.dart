import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(home: PreventErrorExample());
  }
}

class PreventErrorExample extends StatefulWidget {
  const PreventErrorExample({super.key});

  @override
  State createState() => _PreventErrorExampleState();
}

class _PreventErrorExampleState extends State {
  bool isValid = false;
  String message = '';

  void checkText(String text) {
    setState(() {
      if (text.isEmpty) {
        isValid = false;
        message = '';
      }else {
        isValid = true;
      }
    });
  }

  void sendData() {
    setState(() {
      message = 'Enviado correctamente';
      isValid = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Heurística 5 – Prevención de errores')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              onChanged: checkText,
              decoration: const InputDecoration(
                labelText: 'Escribe un mensaje',
              ),
            ),
            const SizedBox(height: 20),

            ElevatedButton(
              onPressed: sendData,
              child: const Text('Enviar'),
            ),

            const SizedBox(height: 20),

            Text(message, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}