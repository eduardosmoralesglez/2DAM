import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(initialRoute: "/", routes: {
      "/": (_) => const FirstPage(),
      "/2": (_) => const SecondPage(),
    },);
  }
}

class FirstPage extends StatelessWidget {
  const FirstPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pantalla 1')),
      body: Center(
        child: GestureDetector(
          onTap: () {
            Navigator.pushNamed(context, "/2");
          },
          child: Hero(
            tag: "HeroFlutterIcon", 
            child: FlutterLogo(size: 80)
          ),
        ),
      ),
    );
  }
}

class SecondPage extends StatelessWidget {
  const SecondPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pantalla 2')),
      body: Center(
        child: GestureDetector(
          onTap: () {
            Navigator.pop(context);
          },
          child: Hero(
            tag: "HeroFlutterIcon", 
            child: FlutterLogo(size: 200)
          ),
        ),
      ),
    );
  }
}
