
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
          width: 300,
          height: 300,
          alignment: AlignmentGeometry.center,
          decoration: BoxDecoration(
            color: const Color.fromARGB(255, 224, 224, 224),
            borderRadius: BorderRadiusGeometry.all(Radius.circular(20))
          ),
          child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.person, color: Colors.black,),
                    SizedBox(width: 8),
                    Text("Perfil de usuario")
                  ],
                ),
                Divider(),
                Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Icon(Icons.star, color: Colors.black,),
                        Text("Puntos: 120")
                      ],
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Icon(Icons.notifications, color: Colors.black,),
                        Text("Notificaciones. 5")
                      ],
                    )
                  ],
                ),
                Divider(),
                ElevatedButton(
                  onPressed: () {  },
                  child: Text("Editar perfil")
                ),
                Divider(),
                Text("Opciones rápidas"),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Column(
                      children: [
                        Icon(Icons.folder, color: Colors.black,),
                        Text("Archivos")
                      ],
                    ),
                    Column(
                      children: [
                        Icon(Icons.settings, color: Colors.black,),
                        Text("Ajustes")
                      ],
                    ),
                    Column(
                      children: [
                        Icon(Icons.help_outline, color: Colors.black,),
                        Text("Ayuda")
                      ]                      
                    )
                  ],
                )
              ],
            ),
          )
        ),
      );
  }
}
