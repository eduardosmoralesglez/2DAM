import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  final bool _isDark = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Tema claro/oscuro',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Color(0xFF0455BF),
          brightness: Brightness.light,
        ),
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Color(0xFF0455BF),
          brightness: Brightness.dark,
        ),
      ),
      home: Scaffold(
        appBar: AppBar(title: const Text('Home Page')),

        body: Center(
          child: ElevatedButton(onPressed: () {},  child: Text('Botón')),
        ),

        floatingActionButton: FloatingActionButton(
          onPressed: () {},
          child: Icon(Icons.light_mode),
        ),
      ),
    );
  }
}
