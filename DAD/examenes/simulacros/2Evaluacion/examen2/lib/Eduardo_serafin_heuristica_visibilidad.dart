import 'package:flutter/material.dart';

void main() {
  runApp(const EstadoApp());
}

class EstadoApp extends StatelessWidget {
  const EstadoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: EstadoPage(),
    );
  }
}

class EstadoPage extends StatefulWidget {
  const EstadoPage({super.key});

  @override
  State createState() => _EstadoPageState();
}

class _EstadoPageState extends State {
  bool loading = false;
  IconData estadoProceso = Icons.pause_circle;
  String mensaje = 'Iniciar Proceso';

  void cargar(bool loading) {
    setState(() {
      if (loading) {
        Future.delayed(Duration(seconds: 2));
        estadoProceso = Icons.hourglass_top;
        mensaje = 'Procesando...';
      }
      Future.delayed(Duration(seconds: 2));
      estadoProceso = Icons.check_circle;
      mensaje = 'Proceso completado';
    });
  }

  void proceso() {
    setState(() {
      loading = true;
      cargar(loading);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Heurística 1 – Estado del sistema')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(estadoProceso, size: 80),
            const SizedBox(height: 10),
            Text(mensaje, style: const TextStyle(fontSize: 20)),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: proceso,
              child: const Text('Iniciar proceso'),
            ),
          ],
        ),
      ),
    );
  }
}
