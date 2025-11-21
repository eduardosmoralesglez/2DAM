import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(       // ← ?? Lo entenderemos más adelante
      create: (context) => MyAppState(),
      child: MaterialApp(
        title: 'Namer App',
        theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrange), // ← Los colores del tema son deepOrange
        ),
        home: MyHomePage(),
      ),
    );
  }
}

class MyAppState extends ChangeNotifier {
  var current = WordPair.random(); // ← Crea una palabra aleatoria formada por una pareja de palabras
  
  void getNext() {
    current = WordPair.random();
    notifyListeners();
  } 
}

class BigCard extends StatelessWidget {
  const BigCard({
    super.key,
    required this.pair,
  });

  final WordPair pair; // Es un atributo (campo) de la clase

  @override
  Widget build(BuildContext context) {
    var tema = Theme.of(context);
    return Card(
      color: tema.colorScheme.primary,
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Text(pair.asLowerCase),
      ),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    var appState = context.watch<MyAppState>(); // ← ?? Lo entenderemos más adelante
    var pair = appState.current;

    return Scaffold(
      body: Column(
        children: [
          Text('A random idea:'),
          BigCard(pair: pair), // ← Muestra la palabra en minúsculas
          ElevatedButton(onPressed: () => appState.getNext(), child: Text("Pulsame!"))
        ],
      ),
    );
  }
}