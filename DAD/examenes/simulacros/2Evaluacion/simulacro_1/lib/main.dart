import 'package:flutter/material.dart';

void main() {
  runApp(const NavigatorBasicoApp());
}

class NavigatorBasicoApp extends StatelessWidget {
  const NavigatorBasicoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: InicioPage(),
    );
  }
}

class InicioPage extends StatelessWidget {
  const InicioPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Inicio')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ElevatedButton(onPressed: (){
              Navigator.push(context, const );
            }, child: Text('Ir a Info')),
            ElevatedButton(onPressed: (){
              Navigator.push(context, );
            }, child: Text('Ir a Contactos'))
          ],
        ),
      ),
    );
  }
}

// TODO: Crea ContactoPage (StatelessWidget)
// - Scaffold con AppBar "Contacto"
// - Un texto con email/teléfono ficticio
// - Botón "Volver" que haga Navigator.pop