
import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
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
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Widget principal')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Misión Apolo 8 — 1968",
              style: TextStyle(
                fontSize: 26

              ),
            ),
            Text("Earthrise: la Tierra vista desde la Luna",
              textAlign: TextAlign.center,
              style: TextStyle(
                fontSize: 18
              ),
            ),
            Text("El 24 de diciembre de 1968, mientras orbitaban la Luna, los astronautas del Apolo 8 presenciaron algo que nadie había visto jamás: la Tierra elevándose sobre el horizonte lunar. En ese instante capturaron la icónica fotografía Earthrise, que transformó para siempre la forma en que la humanidad se veía a sí misma en el cosmos.",
              textAlign: TextAlign.justify,
              style: TextStyle(
                fontSize: 16,
                
              ),
            ),
            Image.asset("earthrise.webp")
          ],
        )
        ),
      );
  }
}
