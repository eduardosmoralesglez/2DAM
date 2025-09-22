import 'dart:io';

void main() {
  stdout.writeln('Como te llamas?');
  String ? name = stdin.readLineSync();
  
  stdout.writeln('Hola, $name! Dienvenido a Dart.');
}
