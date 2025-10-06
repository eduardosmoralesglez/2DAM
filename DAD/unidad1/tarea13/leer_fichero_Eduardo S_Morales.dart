import 'dart:io';

Future<void> main() async {
  final file = File('datos.txt');

  try {
    bool existe = await file.exists();
    if (!existe) {
      throw Exception("Fichero no encontrado");
    }
    String mensaje = await file.readAsString();
    print(mensaje);
  } catch (e) {
    print('Error al leer el archivo: $e');
  }
}