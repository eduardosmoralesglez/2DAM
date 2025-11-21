/**
 * Tarea 7 Ejercicios de colecciones en Dart
 * @autor Eduardo Serafin Morales Gonzalez
 */

import 'dart:collection';

/**
 * Ejercicio 1

1️⃣ List – Lista de notas

Crea una lista con las notas de 5 alumnos.

    Añade una nueva nota al final.

    Muestra la primera y la última nota.

    Calcula la media de todas las notas.

Usa first, last, reduce y length.
 */

var notas = [1,7,9,2,5];
int sumaLista(List<int> lista) {
  var suma = 0;
  for (var n in lista) {
    suma += n;
  }
  return suma;
}

/**
 * Ejercicio 2
2️⃣ Set – Correos únicos

Crea un conjunto (Set) con correos electrónicos:

["ana@mail.com", "luis@mail.com", "ana@mail.com", "pedro@mail.com"]

    Imprime el conjunto para comprobar que no hay duplicados.

    Añade un correo nuevo.

    Comprueba si "luis@mail.com" está en el set.

Usa add y contains.
 */

var correos = ["ana@mail.com", "luis@mail.com", "ana@mail.com", "pedro@mail.com"];
var correosSet = Set.from(correos);

/**
 * Ejercicio 3
3️⃣ Map – Diccionario de productos

Crea un mapa (Map) donde las claves sean nombres de productos y los valores sean sus precios:

{"pan": 1.0, "leche": 1.5, "huevos": 2.0}

    Muestra el precio de la leche.

    Añade "café": 3.0.

    Recorre el mapa e imprime "producto → precio".

Usa forEach.
 */

var productos = {"pan": 1.0, "leche": 1.5, "huevos": 2.0};

/**
 * Ejercicio 4
4️⃣ Queue – Cola de tareas

Usa una cola (Queue) para representar tareas pendientes:

    Empieza con ["Lavar platos", "Hacer compra", "Estudiar"].

    Atiende (quita) la primera tarea y muéstrala.

    Añade una nueva tarea "Pasear perro".

    Muestra todas las tareas restantes.

Usa addAll y removeFirst.
 */

var tareas = Queue<String>();

/**
 * Ejercicio 5
5️⃣ SplayTreeSet – Números ordenados

Crea un SplayTreeSet de enteros.

    Añade los números 5, 3, 9, 1, 4.

    Imprime el conjunto y verifica que están ordenados automáticamente.

    Elimina el número 3.

    Imprime el conjunto final.

Usa addAll y remove.
 */

var numeros = SplayTreeSet<int>();

void main(){
  print("---------- Ejercicio 1 ----------");
  notas.add(10);
  print("Primera nota: ${notas.first}, Ultima nota: ${notas.last}");
  print("Media de las notas: ${sumaLista(notas)/notas.length}");
  print("---------- Ejercicio 2 ----------");
  print("List de correos: $correos");
  print("Set de correos: $correosSet");
  correosSet.add("juan@mail.com");
  print("Set de correos: $correosSet");
  var correo = "luis@mail.com";
  print("El set contiene el correo $correo : ${correosSet.contains(correo)}");
  print("---------- Ejercicio 3 ----------");
  print("El precio de la leche es ${productos["leche"]}");
  productos.addAll({"café" : 3.0});
  productos.forEach((key, value) {
    print("Producto: $key, Precio: $value");
  },);
  print("---------- Ejercicio 4 ----------");
  tareas.addAll(["Lavar platos", "Hacer compra", "Estudiar"]);
  print("Se atiende la primera tarea, ${tareas.first}");
  tareas.removeFirst;
  var tareaNew = "Pasear perro";
  tareas.add(tareaNew);
  print("Se añade nueva tarea: $tareaNew");
  print(tareas);
  print("---------- Ejercicio 5 ----------");
  numeros.addAll([5,3,9,1,4]);
  print(numeros);
  numeros.remove(3);
  print(numeros);
}