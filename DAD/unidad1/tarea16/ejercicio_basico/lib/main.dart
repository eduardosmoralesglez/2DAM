import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Column(
        children: [
          Text('Hola'),
          Image.network('https://unsplash.com/es/fotos/una-pantalla-de-computadora-con-un-enlace-7IcARfSxo2Y')
        ],
      ),
    ),
  );
}
