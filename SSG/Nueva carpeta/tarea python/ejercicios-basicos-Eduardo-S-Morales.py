# ================================
# EJERCICIOS BÁSICOS DE PYTHON
# ================================

# EJERCICIO 1
# Pide dos números enteros al usuario y muestra la suma y la división entera del primero entre el segundo.
print("EJERCICIO 1")
a = int(input("Introduce el primer número: "))
b = int(input("Introduce el segundo número: "))
print("Suma:", a + b)
print("División entera:", a // b)

# EJERCICIO 2
# Pide un número entero y muestra si es positivo, negativo o cero usando if, elif y else.
print("\nEJERCICIO 2")
n = int(input("Introduce un número entero: "))
if n > 0:
    print("Positivo")
elif n < 0:
    print("Negativo")
else:
    print("Cero")

# EJERCICIO 3
# Pide el nombre y la comida favorita de una persona y muestra:
# "<nombre> quiere comer <comida>" usando .format().
print("\nEJERCICIO 3")
nombre = input("Introduce tu nombre: ")
comida = input("Introduce tu comida favorita: ")
print("{} quiere comer {}".format(nombre, comida))

# EJERCICIO 4
# Pide una palabra y muestra su primer carácter y su último carácter usando índices.
print("\nEJERCICIO 4")
palabra = input("Introduce una palabra: ")
print("Primer carácter:", palabra[0])
print("Último carácter:", palabra[-1])

# EJERCICIO 5
# Crea una lista vacía, agrega los números 1, 2 y 3 con append. Luego elimina el último con pop y muestra la lista antes y después.
print("\nEJERCICIO 5")
lista = []
lista.append(1)
lista.append(2)
lista.append(3)
print("Lista antes del pop:", lista)
lista.pop()
print("Lista después del pop:", lista)

# EJERCICIO 6
# Dada la lista [10, 20, 30, 40, 50, 60], muestra:
# - Los elementos del índice 1 al 2
# - Desde el índice 2 al final
# - La lista invertida
print("\nEJERCICIO 6")
nums = [10, 20, 30, 40, 50, 60]
print("Índices 1 al 2:", nums[1:3])
print("Desde índice 2 al final:", nums[2:])
print("Lista invertida:", nums[::-1])

# EJERCICIO 7
# Pide un número al usuario y comprueba si está dentro de la lista [3, 6, 9, 12].
print("\nEJERCICIO 7")
n = int(input("Introduce un número: "))
if n in [3, 6, 9, 12]:
    print("Está en la lista.")
else:
    print("No está en la lista.")

# EJERCICIO 8
# Declara a = 5 y b = 10. Intercambia sus valores sin usar una variable auxiliar.
print("\nEJERCICIO 8")
a, b = 5, 10
a, b = b, a
print("a =", a, "b =", b)

# EJERCICIO 9
# Crea un diccionario con claves "nombre", "edad" y "ciudad". 
# Pide una clave al usuario y muéstrala usando get. Si no existe, muestra "Clave no encontrada".
print("\nEJERCICIO 9")
persona = {"nombre": "Ana", "edad": 25, "ciudad": "Madrid"}
clave = input("Introduce una clave: ")
print(persona.get(clave, "Clave no encontrada"))

# EJERCICIO 10
# Dado a = {1, 2, 3, 4} y b = {3, 4, 5, 6}, muestra su intersección, unión y diferencia.
print("\nEJERCICIO 10")
a = {1, 2, 3, 4}
b = {3, 4, 5, 6}
print("Intersección:", a & b)
print("Unión:", a | b)
print("Diferencia a - b :", a - b)
print("Diferencia b - a :", b - a)

# EJERCICIO 11
# Dada la lista ["perro", "gato", "ratón"], recórrela y muestra "<animal> es un mamífero".
print("\nEJERCICIO 11")
animales = ["perro", "gato", "ratón"]
for animal in animales:
    print(f"{animal} es un mamífero")

# EJERCICIO 12
# Imprime los números del 0 al 5 usando range.
print("\nEJERCICIO 12")
for i in range(6):
    print(i)

# EJERCICIO 13
# Imprime los números del 1 al 5 usando un bucle while.
print("\nEJERCICIO 13")
i = 1
while i <= 5:
    print(i)
    i += 1

# EJERCICIO 14
# Pide un número y muestra su inverso (1/n). 
# Si el usuario introduce 0, captura la excepción y muestra un mensaje de error.
print("\nEJERCICIO 14")
try:
    n = float(input("Introduce un número: "))
    print("Su inverso es:", 1 / n)
except ZeroDivisionError:
    print("Error: no se puede dividir entre cero.")

# EJERCICIO 15
# Define una función suma(a, b) que devuelva la suma de ambos. 
# Pide valores al usuario y muestra el resultado.
print("\nEJERCICIO 15")
def suma(a, b):
    return a + b

x = int(input("Introduce el número a: "))
y = int(input("Introduce el número b: "))
print("La suma es:", suma(x, y))

# EJERCICIO 16
# Crea una función sumar_todo(*numeros) que devuelva la suma de todos los argumentos recibidos.
print("\nEJERCICIO 16")
def sumar_todo(*numeros):
    return sum(numeros)

print("Suma total:", sumar_todo(1, 2, 3, 4, 5))

# EJERCICIO 17
# Usa filter y una lambda para obtener los números mayores que 5 de la lista [3, 4, 5, 6, 7].
print("\nEJERCICIO 17")
nums = [3, 4, 5, 6, 7]
mayores = list(filter(lambda x: x > 5, nums))
print("Mayores que 5:", mayores)

# EJERCICIO 18
# Genera una lista con el cuadrado de los números del 0 al 4 usando comprensión de listas.
print("\nEJERCICIO 18")
cuadrados = [x**2 for x in range(5)]
print("Cuadrados:", cuadrados)

# EJERCICIO 19
# Crea una clase Humano con atributo nombre y método decir(mensaje). 
# Crea un objeto y prueba el método.
print("\nEJERCICIO 19")
class Humano:
    def __init__(self, nombre):
        self.nombre = nombre
    def decir(self, mensaje):
        print(f"{self.nombre} dice: {mensaje}")

persona = Humano("Carlos")
persona.decir("Hola a todos")

# EJERCICIO 20
# Pide un número y muestra su raíz cuadrada y su valor redondeado hacia arriba usando math.sqrt y math.ceil.
print("\nEJERCICIO 20")
import math
n = float(input("Introduce un número: "))
print("Raíz cuadrada:", math.sqrt(n))
print("Redondeado hacia arriba:", math.ceil(n))

# EJERCICIO 21
# Crea un programa que pida repetidamente el nombre y la nota de alumnos (0–10).
# Cuando se introduzca un nombre vacío:
#   - Muestra cuántos alumnos se registraron
#   - Calcula la nota media
#   - Muestra el alumno con mejor nota
#   - Muestra el alumno con peor nota
# Usa listas y/o diccionarios.
print("\nEJERCICIO 21")
alumnos = {}
while True:
    nombre = input("Nombre del alumno (vacío para salir): ")
    if nombre == "":
        break
    nota = float(input("Nota (0–10): "))
    alumnos[nombre] = nota

if alumnos:
    print("Total de alumnos:", len(alumnos))
    media = sum(alumnos.values()) / len(alumnos)
    mejor = max(alumnos, key=alumnos.get)
    peor = min(alumnos, key=alumnos.get)
    print("Nota media:", round(media, 2))
    print("Mejor alumno:", mejor, alumnos[mejor])
    print("Peor alumno:", peor, alumnos[peor])

# EJERCICIO 22
# Pide al usuario una frase y:
#   1. Cuenta y muestra el número total de caracteres.
#   2. Cuenta y muestra el número de palabras.
#   3. Muestra cuántas veces aparece cada vocal (a, e, i, o, u).
#   4. Determina y muestra la palabra más larga.
print("\nEJERCICIO 22")
frase = input("Introduce una frase: ")
palabras = frase.split()
print("Total de caracteres:", len(frase))
print("Total de palabras:", len(palabras))
for v in "aeiou":
    print(f"{v}: {frase.lower().count(v)}")
print("Palabra más larga:", max(palabras, key=len))

# EJERCICIO 23
# Crear una clase CuentaBancaria con:
#   - Atributo titular
#   - Atributo saldo (inicia en 0)
#   - Método depositar(cantidad)
#   - Método retirar(cantidad)
#   - Método mostrar_informacion()
# El programa principal debe:
#   - Crear una cuenta
#   - Aceptar operaciones del usuario:
#       "d cantidad" para depositar
#       "r cantidad" para retirar
#       "salir" para terminar
#   - Al finalizar, mostrar el estado final de la cuenta.
print("\nEJERCICIO 23")
class CuentaBancaria:
    def __init__(self, titular):
        self.titular = titular
        self.saldo = 0
    def depositar(self, cantidad):
        self.saldo += cantidad
    def retirar(self, cantidad):
        if cantidad <= self.saldo:
            self.saldo -= cantidad
        else:
            print("Fondos insuficientes.")
    def mostrar_informacion(self):
        print(f"Titular: {self.titular}, Saldo: {self.saldo}")

titular = input("Introduce el nombre del titular: ")
cuenta = CuentaBancaria(titular)

while True:
    operacion = input("Operación ('d + (Cantidad)' depositar / 'r + (Cantidad)' retirar / 'salir' salir): ")
    if operacion == "salir":
        break
    op, *resto = operacion.split()
    if op == "d":
        cuenta.depositar(float(resto[0]))
    elif op == "r":
        cuenta.retirar(float(resto[0]))

cuenta.mostrar_informacion()
