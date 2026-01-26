import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: MyMainWidget(),
    );
  }
}

// 🔹 Clase principal
class MyMainWidget extends StatelessWidget {
  const MyMainWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Widget principal')),
      body: Column(
          children: [
            TarjetaPersonalizada(
              icono: Icon(Icons.work),
              titulo: Text("Trabajo"),
              descripcion: Text("Gestiona tus tareas y proyectos diarios"),
            ),
            TarjetaPersonalizada(
              icono: Icon(Icons.health_and_safety),
              titulo: Text("Salud"),
              descripcion: Text("Consulta información realacionada con tu bienestar"),
            ),
            TarjetaPersonalizada(
              icono: Icon(Icons.home),
              titulo: Text("Hogar"),
              descripcion: Text("Organiza todos los aspectos de tu vivienda"),
            ),
          ],
        ),
      );
  }
}

class TarjetaPersonalizada extends StatelessWidget {

  final Icon icono;
  final Text titulo;
  final Text descripcion;

  const TarjetaPersonalizada({
    super.key,
    required this.icono,
    required this.titulo,
    required this.descripcion,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
        child: Row(
          children: [
            icono,
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                titulo,
                descripcion
              ],
            )
          ],
        ),
      );
    
  }
}
