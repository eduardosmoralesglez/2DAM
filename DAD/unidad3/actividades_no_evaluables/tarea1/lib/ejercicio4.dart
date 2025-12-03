import 'package:flutter/material.dart';

void main() {
  runApp(const PaddingDemo());
}

class PaddingDemo extends StatefulWidget {
  const PaddingDemo({super.key});

  @override
  State createState() => _PaddingDemoState();
}

class _PaddingDemoState extends State {
  double pad = 10;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Implicit Animation: AnimatedPadding")),
        body: Center(
          child: SizedBox(
            width: 200,
            height: 200,
            child: AnimatedPadding(
              duration: Duration(milliseconds: 2000),
              padding: EdgeInsets.all(50),
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.play_arrow),
          onPressed: () {
            setState(() {
              pad = 2;
            });
          },
        ),
      ),
    );
  }
}
