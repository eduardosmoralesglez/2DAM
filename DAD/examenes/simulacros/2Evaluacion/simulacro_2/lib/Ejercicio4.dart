import 'package:flutter/material.dart';

void main() {
  runApp(const IncidenciasApp());
}

class IncidenciasApp extends StatelessWidget {
  const IncidenciasApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: PrioridadPage(),
    );
  }
}

class PrioridadPage extends StatefulWidget {
  const PrioridadPage({super.key});

  @override
  State createState() => _PrioridadPageState();
}

class _PrioridadPageState extends State {
  String mensaje = '';
  String? prioridad;

  void guardar(String? value) {
    setState(() {
      mensaje= 'Prioridad: $value';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Heurística 6 – Reconocer')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text('Introduce la prioridad'),
            const SizedBox(height: 10),

            DropdownButtonFormField(
              initialValue: null,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
              ),
              items: const [
                DropdownMenuItem(value:'Baja' , child: Text("Baja",)),
                DropdownMenuItem(value:'Media' , child: Text("Media",)),
                DropdownMenuItem(value:'Alta' , child: Text("Alta",))
              ], 
              onChanged: (value) { prioridad = value; }, 
            ),

            const SizedBox(height: 16),

            ElevatedButton(
              onPressed: (){guardar(prioridad);},
              child: const Text('Guardar'),
            ),

            const SizedBox(height: 16),

            Text(mensaje, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}