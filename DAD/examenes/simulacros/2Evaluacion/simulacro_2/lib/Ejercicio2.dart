import 'package:flutter/material.dart';

void main() {
  runApp(const RutasApp());
}

class RutasApp extends StatelessWidget {
  const RutasApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      initialRoute: "/",
      routes: {
        "/": (_) => InicioPage(),
        "/perfil" : (_) => PerfilPage(),
        "/ajustes" : (_) => AjustesPage(),
      },
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
              Navigator.pushNamed(context, "/perfil");
            }, child: Text("Ir a Perfil")
            ),
            ElevatedButton(onPressed: (){
              Navigator.pushNamed(context, "/ajustes");
            }, child: Text("Ia a Ajustes"))
          ],
        ),
      ),
    );
  }
}

class PerfilPage extends StatelessWidget {
  const PerfilPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Perfil')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text("Pagina de perfil"),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context);
              }, 
              child: Text("Volver"))
          ],
        ),
      ),
    );
  }
}

class AjustesPage extends StatelessWidget {
  const AjustesPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Ajustes')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text("Pagina de Ajustes"),
            ElevatedButton(
            onPressed: () {
              Navigator.pop(context);
              }, 
            child: Text("Volver"))
          ],
        ),
      ),
    );
  }
}