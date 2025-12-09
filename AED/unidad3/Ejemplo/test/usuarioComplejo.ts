// ejemplos/02-tipos-compuestos.ts
let usuario: {
  nombre: string;
  edad: number;
  activo: boolean;
} = {
  nombre: "Carlos",
  edad: 28,
  activo: true,
};

console.log(`Nombre: ${usuario.nombre}, Activo: ${usuario.activo}`);