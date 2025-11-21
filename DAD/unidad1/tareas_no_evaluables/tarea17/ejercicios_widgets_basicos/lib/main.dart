import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Actividad final de layouts"),
          backgroundColor: Colors.teal,
          centerTitle: true,
          leading: Icon(Icons.menu),
          ),
        body: Container(
          color: Colors.grey[200],
          margin: EdgeInsets.all(20),
          padding: EdgeInsets.all(16),
          decoration: BoxDecoration(
            color: Colors.grey[200],
            borderRadius: BorderRadius.circular(12),
          ),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("Iconos Favoritos"),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                Icon(Icons.star, color: Colors.orange, size: 50,),
                Icon(Icons.favorite, color: Colors.pink, size: 50,),
                Icon(Icons.home, color: Colors.blue, size: 50,)
                ],
              ),
            ],
          )
        ),
      ),
    ),
  );
}
