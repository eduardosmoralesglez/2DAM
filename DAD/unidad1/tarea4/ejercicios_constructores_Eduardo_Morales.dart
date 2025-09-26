/**
 * Tarea 4 DAD Constructores
 * @autor Eduardo Serafín Morales González
 */

/**
 * Ejercicio 1: Constructor normal

  Crea una clase Pelicula con atributos titulo y anio.

  Haz un constructor normal que reciba ambos.

  En main, crea una película y muestra sus datos.

 */
class Pelicula {
  String nombre;
  int anio;

  /**
   * Constructor principal
   */
  Pelicula(this.nombre, this.anio);
  void mostrar() => print("Nombre de la pelicula: $nombre, año de lanzamiento: $anio");
}

/**
 * Ejercicio 2: Constructor nombrado

  Crea una clase Tarea con atributos descripcion y completada.

    Haz un constructor normal.

    Haz un constructor nombrado incompleta que solo reciba la descripción y ponga completada = false.

    En main, crea una tarea con cada constructor y muestra su estado.

 */
class Tarea {
  String descripcion;
  bool completa;

  Tarea(this.descripcion,this.completa);
  Tarea.Incompleta(this.descripcion,{this.completa = false});

  void mostrar() => print("Tarea : $descripcion - Completada: $completa");
}

/**
 * Ejercicio 3: Constructor con inicialización (:)

  Crea una clase Circulo con atributos radio y area.

  Haz un constructor que inicialice area usando : area = 3.14 * radio * radio.

  En main, crea un círculo y muestra su área.

 */

class Circulo {
  double radio;
  double area;

  Circulo(this.radio): area = 3.14 * (radio * radio);
  void mostrar() => print("El area del circulo es: $area");
}

/**
 * Ejercicio 4 Constructor con parámetros nombrados ({})

  Crea una clase Mensaje con atributos texto y prioridad.

  Haz un constructor con parámetros nombrados, donde texto sea obligatorio y prioridad tenga un valor por defecto de "normal".

  En main, crea un mensaje con y sin prioridad.

 */

class Mensaje {
  String texto;
  String prioridad;

  Mensaje({this.texto = "obligatorio",this.prioridad = "normal"});

  void mostrar()=> print("Texto: $texto, Prioridad: $prioridad");
}

/**
 * Ejercicio 5 Constructor const

  Crea una clase Moneda con atributos codigo y simbolo (final).

  Haz un constructor const.

  En main, crea dos monedas iguales (USD, $) y muestra si son idénticas con identical().

 */

class Moneda {
  final String codigo;
  final String simbolo;

  const Moneda(this.codigo, this.simbolo);
  void mostrar() => print("Codigo de la moneda: $codigo, simbolo de la moneda: $simbolo");
}

/**
 * Ejercicio 6  Constructor con redirección

  Crea una clase Alumno con atributos nombre y nota.

  Haz un constructor normal.

  Haz un constructor redirigido Alumno.aprobado(nombre) que ponga la nota en 5.

  En main, crea un alumno con cada constructor y muestra sus datos.

 */

class Alumno {
  String nombre;
  int nota;

  Alumno(this.nombre,this.nota);
  Alumno.aprobado(nombre) : this(nombre,5);
  void mostrar() => print("Nombre del alumno: $nombre, su nota es: $nota");
}

/**
 * Ejercicio 7 Constructor de fábrica (factory)

  Crea una clase Sesion que solo permita tener una única sesión activa.

  Haz un constructor privado _interna.

  Haz un constructor factory que devuelva siempre la misma sesión.

  En main, crea dos sesiones y muestra si son idénticas.
 
 */

class Sesion {
  static final Sesion _instancia = Sesion._interna();

  Sesion._interna();
  
  factory Sesion() {
    return _instancia;
  }

}



void main(){
  // Ejercicio 1
  print("--------------Tarea 1----------------");
  var p = Pelicula("Misión Imposible", 2025);
  p.mostrar();
  // Ejercicio 2
    print("--------------Tarea 2----------------");
  var t1 = Tarea("descripcion", true);
  var t2 = Tarea.Incompleta("descripcion incompleta");
  t1.mostrar();
  t2.mostrar();
  // Ejercicio 3
  print("--------------Tarea 3----------------");
  var c = Circulo(30.5);
  c.mostrar();
  // Ejercicio 4
  print("--------------Tarea 4----------------");
  var m = Mensaje();
  m.mostrar();
  // Ejercicio 5
  print("--------------Tarea 5----------------");
  const mo = Moneda("USD", '\$');
  const mo2 = Moneda("USD", '\$');
  print(identical(mo, mo2));
  // Ejercicio 6
  print("--------------Tarea 6----------------");
  var a = Alumno("Pedro", 7);
  var a2 = Alumno.aprobado("Juan");
  a.mostrar();
  a2.mostrar();
  // Ejercicio 7
  print("--------------Tarea 7----------------");
  var s = Sesion();
  var s2 = Sesion();
  print("Las instancias son iguales: ${identical(s, s2)}");
}
