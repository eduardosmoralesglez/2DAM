import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  MyAppState createState() => MyAppState();
}

class MyAppState extends State {
  bool _big = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Implicit Animation: AnimatedContainer")),
        body: Center(
          child: AnimatedContainer(
            duration: Duration(seconds: 1),
            width: _big ? 200 : 100,
            height: _big ? 200 : 100,
            curve: Curves.easeInSine,
            color: _big ? Colors.red : Colors.blue,
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.play_arrow),
          onPressed: () {
            setState(() {
              _big = !_big;
            });
          },
        ),
      ),
    );
  }
}
