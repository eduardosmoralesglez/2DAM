import 'package:flutter/material.dart';

void main() {
  runApp(const ComboDemo());
}

class ComboDemo extends StatefulWidget {
  const ComboDemo({super.key});

  @override
  State createState() => _ComboDemoState();
}

class _ComboDemoState extends State {
  bool active = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("Animaciones Implícitas Combinadas")),
        body: Center(
          child: AnimatedSize(
            duration: Duration(seconds: 2),
            child: AnimatedAlign(
              duration: Duration(seconds: 2),
              alignment: active ? Alignment.centerRight : Alignment.centerLeft,
              child: AnimatedOpacity(
                opacity: active ? 1 : 0.3,
                duration: Duration(seconds: 2),
                child: AnimatedContainer(
                  height: active ? 200 : 100,
                  width: active ? 200 : 100,
                  color: Colors.blue, 
                  duration: Duration(seconds: 2),
                  curve: Curves.easeIn,
                ),
              ),
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.play_arrow),
          onPressed: () {
            setState(() {
              active = !active;
            });
          },
        ),
      ),
    );
  }
}
