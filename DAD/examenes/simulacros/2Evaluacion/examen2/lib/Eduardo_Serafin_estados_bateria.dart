import 'package:flutter/material.dart';

void main() {
  runApp(const BateriaApp());
}

class BateriaApp extends StatelessWidget {
  const BateriaApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: BateriaPage(),
    );
  }
}

class BateriaPage extends StatefulWidget {
  const BateriaPage({super.key});

  @override
  State createState() => _BateriaPageState();
}

class _BateriaPageState extends State<BateriaPage> {
  int nivel = 50;
  Icon bateria = Icon(Icons.battery_4_bar, size: 80);
  String mensaje = '';

  void cargar() {
    setState(() {
      if (!(nivel >= 100)) {
        nivel = nivel + 10;
        setBateria();
      }
    });
  }

  void descargar() {
    setState(() {
      if (!(nivel <= 0)) {
        nivel = nivel - 10;
        setBateria();
      }
    });
  }

  void setBateria() {
    setState(() {
      if (nivel >= 70) {
        bateria = Icon(Icons.battery_full, size: 80);
        mensaje = 'Bateria alta';
      }
      if (69 >= nivel && nivel >= 30) {
        bateria = Icon(Icons.battery_4_bar, size: 80);
        mensaje = 'Bateria media';
      }
      if (nivel < 30) {
        bateria = Icon(Icons.battery_alert, size: 80);
        mensaje = 'Bateria baja';
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('setState: batería')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            bateria,
            Text("$nivel %", style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold),),
            Text(mensaje, style: TextStyle(fontSize: 18),),
            const SizedBox(height: 10),
            ElevatedButton(
              onPressed: () {
                cargar();
              },
              child:Text("Cargar"),
            ),
            ElevatedButton(
              onPressed: () {
                descargar();
              },
              child: Text("Descargar")
              ),
          ],
        ),
      ),
    );
  }
}
