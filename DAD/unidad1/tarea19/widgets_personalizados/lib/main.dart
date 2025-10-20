import 'package:flutter/material.dart';

class InfoCard extends StatelessWidget {
  final String title;
  final IconData icon;
  const InfoCard(this.title, this.icon, {super.key});

  @override
  Widget build(BuildContext context){
    return Card(
      elevation: 4,
      margin: EdgeInsets.all(16),
      child: Padding(padding: EdgeInsetsGeometry.all(12),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(icon, color: Colors.blue, size: 40,),
            SizedBox(
              width: 10,
            ),
            Text(title),
          ],
        ),
      ),
    );
  }
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext contexto) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Mi primera app con Scaffold')),
        body: InfoCard("hola", Icon(Icons.info)),
      ),
    );
  }
}

void main() {
  runApp(MyApp());
}
