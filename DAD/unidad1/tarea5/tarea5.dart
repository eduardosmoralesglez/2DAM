/**
 * Tarea 5 DAD Tipos de Clases 
 * @autor Eduardo Serafín Morales González
 */

/** Ejercicio 1 Ejercicio con getter

  Crea una clase Temperatura que almacene una temperatura en grados Celsius.

  Usa un getter para calcular automáticamente el valor en grados Fahrenheit.

  En main, muestra la conversión de varias temperaturas.

 */

class Temperatura {
  int gradosCelsius;
  Temperatura(this.gradosCelsius);

  int get getGradosCelsius => gradosCelsius;
  double get getGradosFahrenheit => (gradosCelsius* 9/5) +32;

}


void main() {
print("---------------Ejercicio 1---------------");
var t1 = Temperatura(25);
print("${t1.getGradosCelsius}");
print(t1.getGradosFahrenheit);
var t2 = Temperatura(100);
print(t2.getGradosCelsius);
print(t2.getGradosFahrenheit);


print("---------------Ejercicio 2---------------");

print("---------------Ejercicio 3---------------");

print("---------------Ejercicio 4---------------");

print("---------------Ejercicio 5---------------");

print("---------------Ejercicio 6---------------");

print("---------------Ejercicio 7---------------");

}