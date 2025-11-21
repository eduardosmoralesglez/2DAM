
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
    const src = "https://s2.ppllstatics.com/lasprovincias/www/multimedia/201811/27/media/cortadas/alaska1-k4zE--1666x900@Las%20Provincias.jpg";
    return Scaffold(
      appBar: AppBar(title: Text('Widget principal')),
      body: Center(
        child: Column(
          children: [
            Text("Alaska"),
            Text("El Sol se ha ido oficialmente en Alaska, y no volverá a salir hasta el 22 de enero de 2026"),
            Image.asset("assets/alaska.jpg", width: 350,),
            Image.network(src, width: 350,)

          ],
        ),
      )
    );
  }
}
