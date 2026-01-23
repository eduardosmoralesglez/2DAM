import 'package:flutter/material.dart';

void main() {
  runApp(const SemaforoApp());
}

class SemaforoApp extends StatelessWidget {
  const SemaforoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: SemaforoPage(),
    );
  }
}

class SemaforoPage extends StatefulWidget {
  const SemaforoPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Semáforo estático'), centerTitle: true),
      body: Center(
        child: Container(
          padding: const EdgeInsets.all(16),
          decoration: BoxDecoration(
            color: Colors.black,
            borderRadius: BorderRadius.circular(18),
          ),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Luz(color: Colors.red),
              SizedBox(height: 12),
              Luz(color: Colors.yellow),
              SizedBox(height: 12),
              Luz(color: Colors.green),
              ElevatedButton(onPressed: , child: Text('Cambiar luz'))
            ],
          ),
        ),
      ),
    );
  }
  
  @override
  State<StatefulWidget> createState() {
    
  }
  

}

class Luz extends StatelessWidget {
  final Color color;

  const Luz({super.key, required this.color});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 90,
      height: 90,
      decoration: BoxDecoration(shape: BoxShape.circle, color: color),
    );
  }
}