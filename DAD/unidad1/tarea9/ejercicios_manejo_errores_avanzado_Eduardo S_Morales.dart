/**
 * Tarea 9 Ejercicios de colecciones en Dart
 * @autor Eduardo Serafin Morales Gonzalez
 */

/**
 * Ejercicio 1
1️⃣ Conversor de números con validación

Crea una función toIntSeguro(String valor) que:

    Intente convertir el valor a entero con int.parse.

    Si el valor no es válido, lance un FormatException con el mensaje "Valor inválido: $valor".

    En main, prueba con ["123", "abc", "45"] y atrápalo con try/catch.
 */

toIntSeguro(String valor) {
  try {
    return int.parse(valor);
  } on FormatException{
    throw Exception("Valor invalido: $valor");
  } catch (e) {
    print(e);
  }
  return int.parse(valor);
}

/**
 * Ejercicio 2
2️⃣ Suma de lista segura

Crea una función sumarLista(List<dynamic> datos) que:

    Recorra la lista y sume solo los valores enteros.

    Si encuentra algo que no sea entero, lance una excepción propia ElementoNoEnteroException.

    Maneja el error en main mostrando qué elemento causó el problema.

Ejemplo de entrada: [10, 20, "hola", 5].
 */

sumarLista(List<dynamic> datos) {
  for (var dato in datos) {
    if (dato.runtimeType != int) {
      
    }
  }
}

/**
 * Ejercicio 3
3️⃣ Multiplicación con dos tipos de errores

Crea una función multiplicar(int? a, int? b) que:

    Lance un ArgumentError si alguno es null.

    Lance una excepción genérica si alguno es negativo.

    Maneja ambos casos en main con bloques on ArgumentError y catch (para el resto).

 */


/**
 * Ejercicio 4
4️⃣ Reintentos en conexión simulada

Crea una función conectar() que:

    Use Random() para simular que a veces lanza un Exception("Fallo de red").

    Intenta conectarse hasta 3 veces.

    Si tras 3 intentos sigue fallando, lanza un Exception("Conexión fallida tras 3 intentos").

    Maneja el error en main.
 */


/**
 * Ejercicio 5
5️⃣ Cargar datos con .catchError()

Crea una función Future<String> cargarArchivo(String nombre) que:

    Si el nombre es "config.txt", devuelva "Archivo cargado".

    En otro caso, lance una excepción "Archivo no encontrado".

    En main, llama a cargarArchivo("datos.txt") y maneja el error con .catchError() en lugar de try/catch.
 */

void main() {
  print("--------------- Ejercicio 1 ---------------");
  var prueba = ["123","abc","45"];
  try {
    for (var element in prueba) {
      print(toIntSeguro(element));
    }
  } catch (e) {
    print(e);
  }
  print("--------------- Ejercicio 2 ---------------");

  print("--------------- Ejercicio 3 ---------------");
  print("--------------- Ejercicio 4 ---------------");
  print("--------------- Ejercicio 5 ---------------");
}