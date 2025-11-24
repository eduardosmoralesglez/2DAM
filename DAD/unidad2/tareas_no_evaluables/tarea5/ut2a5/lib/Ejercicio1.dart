import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State createState() => _MyAppState();

}

class _MyAppState extends State<MyApp> {
  bool _isDark = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Tema claro/oscuro",
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
      themeMode: _isDark ? ThemeMode.dark : ThemeMode.light,
      home: Scaffold(
        appBar: AppBar(),
        body: Center(
          child: ElevatedButton(
            onPressed: () {
              setState(() {
                _isDark = !_isDark;
              });
            },
            child: Text(_isDark ? "Cambiar a claro" : "Cambiar a oscuro"),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {},
          child: _isDark ? Icon(Icons.light_mode) : Icon(Icons.dark_mode),
        ),
      ),
    );
  }
}
