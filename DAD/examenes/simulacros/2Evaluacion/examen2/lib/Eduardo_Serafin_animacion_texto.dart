import 'package:flutter/material.dart';

void main() {
  runApp(const TextoAnimadoApp());
}

class TextoAnimadoApp extends StatelessWidget {
  const TextoAnimadoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: TextoAnimadoPage(),
    );
  }
}

class TextoAnimadoPage extends StatefulWidget {
  const TextoAnimadoPage({super.key});

  @override
  State createState() => _TextoAnimadoPageState();
}

class _TextoAnimadoPageState extends State {
  Color colorText = Colors.black;
  FontWeight weightText = FontWeight.normal;
  double fontSize = 18;
  int contadorStyle =1 ;

  

  void styleText(int style) {
    setState(() {
      if (style == 0) {
        colorText = Colors.black;
        weightText = FontWeight.normal;
        fontSize = 18;
      }
      if (style == 1) {
        colorText = Colors.red;
        weightText = FontWeight.bold;
        fontSize = 28;
      }
      contadorStyle++;
      if (contadorStyle > 1) {
        contadorStyle = 0;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Texto sin animación')),
      body: Center(
        child: AnimatedDefaultTextStyle(
          style: TextStyle(
            fontSize: fontSize,
            fontWeight: weightText,
            color: colorText,
          ),
          duration: Duration(milliseconds: 400),
          child: Text('Estado de la incidencia'),
        ),
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () {
          styleText(contadorStyle);
        },
        icon: const Icon(Icons.text_fields),
        label: const Text('Cambiar estilo'),
      ),
    );
  }
}
