
import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Color(0xFFF7F3E9)),
        textTheme: TextTheme(
          headlineLarge: TextStyle(
            color: Color(0xFF003366),
            fontSize: 34,
            fontFamily: "Garamound"
          ),
          titleMedium: TextStyle(
            color: Color(0xFF003366),
            fontSize: 22,
            fontFamily: "Garamound"
          ),
          bodyLarge: TextStyle(
            color: Color(0xFF2B2B2B),
            fontSize: 18,
            fontFamily: "Times New Roman"
          ),
        )
      ),
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: MyMainWidget(),
    );
  }
}

// 🔹 Clase principal
class MyMainWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Widget principal')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("DISCURSO DE GETTYSBURG",
              style: Theme.of(context).textTheme.headlineLarge
            ),            
            Text("Abraham Lincoln, 19 de noviembre de 1863",
              style: Theme.of(context).textTheme.titleMedium
            ),
            Text("Hace ochenta y siete años, nuestros padres hicieron nacer en este continente una nueva nación, concebida en Libertad y consagrada al principio de que todas las personas son creadas iguales. Ahora estamos envueltos en una gran guerra civil que pone a prueba si esta nación, o cualquier nación así concebida y así consagrada, puede perdurar en el tiempo...",
              style: Theme.of(context).textTheme.bodyLarge
            ),
            ElevatedButton(
              onPressed: () {  },
              child: Text("Saber más...")
            )
          ],
          ),
        ),
      );
  }
}


