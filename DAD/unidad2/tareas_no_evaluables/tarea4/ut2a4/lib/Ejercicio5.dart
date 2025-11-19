import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        colorScheme: ColorScheme(
          brightness: Brightness.light,
          primary: Color(0xFF0455bf),
          onPrimary: Color(0xFFFFFFFF),
          secondary: Color(0xFF1A1A1A),
          onSecondary: Color(0xFFFFFFFF),
          error: Color(0xFFD6001C),
          onError: Color(0xFFFFFFFF),
          surface: Color(0xFFFFFFFF),
          onSurface: Color(0xFF1A1A1A),
        ),
      ),
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text("Hola"),
          Icon(Icons.star),
          ElevatedButton(onPressed: () {}, child: Text("Botón")),
        ],
      ),
    );
  }
}
