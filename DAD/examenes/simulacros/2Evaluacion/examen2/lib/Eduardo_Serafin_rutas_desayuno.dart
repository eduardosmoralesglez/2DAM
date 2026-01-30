import 'package:flutter/material.dart';

void main() {
  runApp(const TiendaRoutesApp());
}

class TiendaRoutesApp extends StatelessWidget {
  const TiendaRoutesApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      initialRoute: '/',
      routes: {
        '/': (_) => ListaPage(),
        '/pedido': (_) => Pedido(),
        '/resumen': (_) => Resumen()
      },
    );
  }
}


class Pedido extends StatelessWidget{
  const Pedido({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Lista')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text("Producto seleccionado"),
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, '/resumen');
                },
                child: const Text('Confirmar'),
              ),
              const SizedBox(height: 12),
              ElevatedButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text('Volver'),
              ),
            ],
          ),
        ),
      ),
    );
  }
  
}

class Resumen extends StatelessWidget {
  const Resumen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Lista')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text("Pedido confirmado"),
              const SizedBox(height: 12),
              ElevatedButton(
                onPressed: () {
                  Navigator.popUntil(context, ModalRoute.withName('/'));
                },
                child: const Text('Volver a lista'),
              ),
            ],
          ),
        ),
      ),
    );
  }
  
}

class ListaPage extends StatelessWidget {
  const ListaPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Lista')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, '/pedido');
                },
                child: const Text('Elegir Café'),
              ),
              const SizedBox(height: 12),
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, '/pedido');
                },
                child: const Text('Elegir Tostada'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}