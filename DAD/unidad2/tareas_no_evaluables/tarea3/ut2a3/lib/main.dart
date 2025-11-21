import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: PantallaA(),
    );
  }
}

class PantallaA extends StatefulWidget {
  PantallaAState
}

// 🔹 Clase de estado asociada al widget
class PantallaAState extends StatefulWidget {
  _PantallaAState createState() => _PantallaAState();

  var controller = TextEditingController();
  String textoA = "";
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla_A')),
      body: Center(
        child: Padding(
          padding: EdgeInsetsGeometry.all(100.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              
              ElevatedButton(
                onPressed: () async {
                  final resultado = await Navigator.push(
                    context,
                    MaterialPageRoute(builder: (_) => PantallaB()),
                  );
                  

                },
                child: Text("Ir a Pantalla B"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class PantallaB extends StatelessWidget {
  var controller = TextEditingController();
  String texto = "";
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla_B')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(controller: controller),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, controller.text);
              },
              child: Text("Ir a Pantalla A"),
            ),
          ],
        ),
      ),
    );
  }
}
