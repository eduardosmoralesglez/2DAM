// Se ejecuta al arrancar el contenedor por primera vez.
// Base de datos: biblioteca
db = db.getSiblingDB("biblioteca");

// Colección: socio_detalles
db.socio_detalles.insertMany([
  {
    socioId: 1,
    telefono: "+34 600111222",
    direccion: "C/ Mayor 1, Madrid",
    notas: "Ejemplo B: socioId=1"
  },
  {
    socioId: 2,
    telefono: "+34 600333444",
    direccion: "Av. del Mar 10, Valencia",
    notas: "Ejemplo B: socioId=2"
  }
]);

print("Datos de ejemplo insertados en socio_detalles");
