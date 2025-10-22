import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class TextCustomizerWidget extends StatefulWidget {
  const TextCustomizerWidget({super.key});
  @override
  State<StatefulWidget> createState() => _TextCustomizerWidgetState();
}

class _TextCustomizerWidgetState extends State<TextCustomizerWidget> {
  Color _textColor = Colors.blue;
  double _fondSize = 24.0;
  
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text('Texto personalizado', style: TextStyle(fontSize: _fondSize, color: _textColor),),
        DropdownButton(
          items: ,
          onChanged: () {
            setState(() {
              _textColor = value;
            });
          }),
        Slider(
          value: _fondSize,
          min: 10,
          max: 60,
          onChanged: (value) {
            setState(() {
              _fondSize = value;
            });
          },
        ),
      ],
    );
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Control deslizante'),
          centerTitle: true,
        ),
        body: Center(
          child: TextCustomizerWidget(),
        ),
      ),
    );
  }
}
