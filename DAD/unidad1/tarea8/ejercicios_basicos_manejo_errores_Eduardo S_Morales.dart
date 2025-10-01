/**
 * Tarea 8 Ejercicios de colecciones en Dart
 * @autor Eduardo Serafin Morales Gonzalez
 */

/**
 * Ejercicio 1
1️⃣ División por cero

void dividir(int a, int b) {
  // TODO: Si b es 0, lanza una excepción con throw
  print(a / b);
}

void main() {
  try {
    dividir(10, 0);
  } 
  // TODO: Atrapa la excepción y muestra "Error: división por cero"
}
 */

void dividir(int a, int b) {
  if (b == 0) {
    throw Exception();
  }
  print(a / b);
}

/**
 * Ejercicio 2
2️⃣ Índice fuera de rango

void main() {
  var lista = [1, 2, 3];

  try {
    print(lista[5]); // ❌ Esto da error
  } 
  // TODO: Usa on RangeError para capturar este error en específico
}
 */



/**
 * Ejercicio 3
3️⃣ Formato inválido

void main() {
  try {
    var numero = int.parse("abc"); // ❌ Esto da FormatException
    print(numero);
  } 
  // TODO: Usa on FormatException y muestra un mensaje claro
}
 */



/**
 * Ejercicio 4
4️⃣ Uso de finally

void abrirArchivo() {
  print("📂 Archivo abierto");
  throw Exception("Error al leer archivo");
}

void main() {
  try {
    abrirArchivo();
  } 
  // TODO: Captura el error
  // TODO: Añade un bloque finally que muestre "📕 Archivo cerrado"
}
 */

void abrirArchivo() {
  print("📂 Archivo abierto");
  throw Exception("Error al leer archivo");
}

/**
 * Ejercicio 5
5️⃣ Excepción personalizada

// TODO: Crea una clase DivisionPorCeroException que implemente Exception
//       y sobrescriba toString() para mostrar "🚫 División prohibida"

void dividir(int a, int b) {
  // TODO: Lanza tu excepción personalizada si b == 0
  print(a / b);
}

void main() {
  try {
    dividir(8, 0);
  } 
  // TODO: Atrapa tu excepción personalizada y muéstrala
}
 */

void dividir2(int a, int b) {
  if (b == 0) {
    throw Exception("Infinito. 🚫 No se puede dividir por cero");
  }
  print(a / b);
}

/**
 * Ejercicio 6
6️⃣ Async y manejo de errores

Future<void> cargarDatos() async {
  await Future.delayed(Duration(seconds: 1));
  // TODO: Lanza una excepción aquí simulando un fallo de conexión
}

void main() async {
  try {
    await cargarDatos();
  } 
  // TODO: Atrapa el error y muestra "Error: no se pudieron cargar los datos"
}
 */

Future<void> cargarDatos() async {
  await Future.delayed(Duration(seconds: 1));
  throw Exception();
}

void main() async {
  print("---------- Ejercicio 1 ----------");
  try {
    dividir(10, 0);
  } catch (e) {
    print("Error: división por cero");
  }
  print("---------- Ejercicio 2 ----------");
  var lista = [1,2,3];
  try {
    print(lista[5]);
  } on RangeError {
    print("Error: Fuera de rango");
  } catch (e) {
    print("Error");
  }
  print("---------- Ejercicio 3 ----------");
  try {
    var numero = int.parse("abc");
    print(numero);
  } on FormatException {
    print("Error: Formato no valido para Tipo int");
  }
  print("---------- Ejercicio 4 ----------");
  try {
    abrirArchivo();
  } catch (e) {
    print(e);
  } finally {
    print("📕 Archivo cerrado");
  }
  print("---------- Ejercicio 5 ----------");

try {
  dividir2(8, 0);
} catch (e) {
  print(e);
}
  print("---------- Ejercicio 6 ----------");
  try {
    await cargarDatos();
  } catch (e) {
    print("Error: no se pudieron cargar los datos");
  }
}