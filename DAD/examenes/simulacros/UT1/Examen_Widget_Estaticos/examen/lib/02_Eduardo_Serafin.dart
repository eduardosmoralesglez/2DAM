import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: MyMainWidget(),
    );
  }
}

// 🔹 Clase principal
class MyMainWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Widget principal')),
      body: Center(
        child: Container(
          height: 200,
          decoration: BoxDecoration(
            color: Colors.grey[200],
            borderRadius: BorderRadius.all(Radius.circular(30)),
            
          ),
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.person),
                TextField(
                  decoration: InputDecoration(
                    icon: Icon(Icons.person),
                    labelText: "Nombre completo",
                    border: OutlineInputBorder(
                      borderSide: BorderSide(
                        color: Colors.black,
                        width: 25,
                        style: BorderStyle.solid
                      )
                    )
                  ),
                ),
                Padding(
                  padding: EdgeInsetsGeometry.all(25),
                  child: Row(
                    children: [
                      SizedBox(width: 255,),
                      Icon(Icons.email),
                      SizedBox(width: 255,),
                      Icon(Icons.phone),
                      SizedBox(width: 255,),
                      Icon(Icons.telegram),
                      SizedBox(width: 255,),
                      Icon(Icons.language),
                    ],
                  ),
                ),
                Column(
                  children: [
                    ElevatedButton(
                      onPressed: () {},
                      style: ButtonStyle(
                      ),
                      child: Row(
                        children: [
                          Icon(Icons.save),
                          Text("Guardar perfil")
                        ],
                      )
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
