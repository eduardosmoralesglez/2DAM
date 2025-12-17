import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      initialRoute: "/",
      routes: {
        "/": (_) => FirstPage(),
        "/2": (_) => SecondPage(),
        
      },
    );
  }
}

class FirstPage extends StatelessWidget {
  const FirstPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Fotos históricas')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Center(
          child: Column(
            children: [
              Text("Bienvenido",),
              Text("Toca la tarjeta para ver más detalles en otra pantalla."),
              ClipRRect(
                borderRadius: BorderRadius.all(Radius.circular(16)),
                child: GestureDetector(
                  onTap: () {
                    Navigator.pushNamed(context, "/2");
                  },
                  child: Image.asset('images/berlin.avif',
                      fit: BoxFit.cover,
                  
                    ),
                )
              )
            ],
          )
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
      appBar: AppBar(title: const Text('Detalle de la tarjeta')),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Image(
              image: AssetImage("images/berlin.avif"),
              width: double.infinity,
              height: 430,
              fit: BoxFit.cover,
            ),
            const Text(
              'La imagen muestra a Konrad Schumann, un joven guardia de Alemania Oriental, '
              'en el instante en que salta sobre el alambre fronterizo que marcaba el '
              'inicio de la construcción del Muro de Berlín, levantado por la Alemania comunista, '
              'para escapar hacia Berlín Oeste en 1961.',
              textAlign: TextAlign.justify,
            ),
            ElevatedButton(onPressed: () {
              Navigator.pop(context);
            }, child: Text("Volver"))
          ],
        )
      ),
    );
  }
}