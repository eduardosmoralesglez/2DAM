import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFF2C3E50)),
        textTheme: TextTheme(
          headlineMedium: TextStyle(
            fontSize: 24,
            fontWeight: FontWeight.bold
          ),
          bodyLarge: TextStyle(
            fontSize: 18,
          ),
        ),
        iconTheme: IconThemeData(
          size: 50
        )
      ),
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
          Icon(Icons.person),
          Text("PERFIL DE USUARIO", style: Theme.of(context).textTheme.headlineMedium,),
          TextField(),
          Text("Indica tu nivel de experiencia", style: Theme.of(context).textTheme.bodyLarge,),
          ElevatedButton(onPressed: () {}, child: Text("Guardar perfil"))
        ],
      )
    );
  }
}


