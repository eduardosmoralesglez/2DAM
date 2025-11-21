/**
 * Ejercicio 1
 */
Future<String> holaFuturo() async {
  await Future.delayed(Duration(seconds: 2));
  return "Hola desde el futuro";
}

/**
 * Ejercicio 2
 */
Future<int> numeroFuturo() async {
  await Future.delayed(Duration(seconds: 1));
  return 5;
}

/**
 * Ejercicio 3
 */
Future errorConexion() async {
  await Future.delayed(Duration(seconds: 1));
  return Future.error("Error en la carga");
}

/**
 * Ejercicio 4
 */
Future<double> dividir(int a, int b) async {
  if (b == 0) {
    return Future.error("Error: No se puede dividir por 0");
  }
  await Future.delayed(Duration(seconds: 1));
  return a/b;
}

/**
 * Ejercicio 5
 */
Future<String> tarea1() async {
  await Future.delayed(Duration(seconds: 1));
  return "Tarea 1";
}
Future<String> tarea2() async {
  await Future.delayed(Duration(seconds: 2));
  return "Tarea 2";
}
Future<String> tarea3() async {
  await Future.delayed(Duration(seconds: 3));
  return "Tarea 3";
}

/**
 * Ejercicio 6
 */
Future<String> lenta() async {
  await Future.delayed(Duration(seconds: 3));
  return "Lenta";
}
Future<String> rapida() async {
  await Future.delayed(Duration(seconds: 1));
  return "Rapida";
}

/**
 * Ejercicio 7
 */
Future<void> cargarArchivo() async {
  await Future.delayed(Duration(seconds: 1));
  return Future.error("Archivo no encontrado");
}

/**
 * Ejercicio 8
 */
var urls = ["url1", "url2", "url3"];
Future descargarUrl(String $url) async {
  Future.delayed(Duration(seconds: 1));
  return "Descargada <"+$url+">";
}


void main() async {
  print("--------------- Ejercicio 1 ---------------");
  var mensaje = await holaFuturo();
  print(mensaje);
  print("--------------- Ejercicio 2 ---------------");
  int numeroF = await numeroFuturo()
    .then((value) => value *2)
    .then((value) => value +10);
  print(numeroF);
  print("--------------- Ejercicio 3 ---------------");
  await errorConexion()
    .catchError((error) => print("❌ Error atrapado: $error"));
  print("--------------- Ejercicio 4 ---------------");
  try {
    print(await dividir(10, 2));
    print(await dividir(2, 0));
  } catch (e) {
    print(e);
  }
  print("--------------- Ejercicio 5 ---------------");
  var tareas = Future.wait([tarea1(),tarea2(),tarea3()]);
  for (var tarea in await tareas) {
    print(tarea);
  }
  print("--------------- Ejercicio 6 ---------------");
  String primero = await Future.any([lenta(), rapida()]);
  print(primero);
  print("--------------- Ejercicio 7 ---------------");
  try {
    await cargarArchivo();
  } catch (e) {
    print(e);
  } finally {
    print("Proceso terminado");
  }
  print("--------------- Ejercicio 8 ---------------");
  for (var des in urls) {
    print(await descargarUrl(des));
  }
}