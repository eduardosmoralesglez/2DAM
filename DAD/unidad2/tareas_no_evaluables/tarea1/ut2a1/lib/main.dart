import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(
  ChangeNotifierProvider(
    create: (context) => VolumenProvider(),
    child: MiApp(),
  ),
);

class MiApp extends StatelessWidget {
  const MiApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: BotonFavorito(),
    );
  }
}

class controlVolumen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final volumen = context.watch<VolumenProvider>()._volumen;
    final provider = context.read<VolumenProvider>();
    return Scaffold(
      appBar: AppBar(title: Text('Ejemplo ejemplo'),),
      body: Center(
        child: Column(
          
        ),
      ),
    );
  }
  
}

class VolumenProvider extends ChangeNotifier {
  double _volumen = 50.0;

  double getVolumen() {
    return _volumen;
  }

  setVolumen(double volumenNuevo) {
    _volumen = volumenNuevo;
    notifyListeners();
  }
}

// 🔹 Widget con estado
class BotonFavorito extends StatefulWidget {
  const BotonFavorito({super.key});

  @override
  _BotonFavoritoState createState() => _BotonFavoritoState();
  // También válido: State<MiWidgetConEstado> createState() => _MiWidgetConEstadoState();
}

bool isFavorite = false;

// 🔹 Clase de estado asociada al widget
class _BotonFavoritoState extends State<BotonFavorito> {
  void _toggleFavorite() {
    setState(() {
      isFavorite = !isFavorite;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Ejemplo StatefulWidget')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            IconButton(
              onPressed: (_toggleFavorite),
              icon: Icon(
                isFavorite ? Icons.favorite : Icons.favorite_border,
                color: isFavorite ? Colors.red : Colors.grey,
                size: 100,
              ),
            ),
            Text(
              isFavorite
                  ? "Añadido a favoritos"
                  : "Pulsa para añadir a favoritos",
              style: TextStyle(fontSize: 18),
            ),
            ElevatedButton(onPressed: _toggleFavorite, child: Text("Boton")),
          ],
        ),
      ),
    );
  }
}
