import { Habitacion, Reserva, EstadoReserva } from "./models";

const MS_DIA = 1000 * 60 * 60 * 24;

function toDateOnlyUTC(isoYMD: string): Date {
  throw new Error("TODO");
}

export function calcularNoches(fechaEntrada: string, fechaSalida: string): number {
  var fechaE = Date.parse(fechaEntrada)
  var fechaS = Date.parse(fechaSalida)
  var fechaFinal = fechaS - fechaE
  return fechaFinal * MS_DIA;
}

export function calcularPrecioTotal(reserva: Reserva, habitacion: Habitacion): number {
  var noches = calcularNoches(reserva.fechaEntrada, reserva.fechaSalida)
  return noches * habitacion.precioPorNoche;
}

export function hayConflicto(a: Reserva, b: Reserva): boolean {
  if (a.estado === EstadoReserva.CANCELADA || b.estado === EstadoReserva.CANCELADA) {
    return false;
  }
  if (a.habitacionId != b.habitacionId) {
    return false;
  }
  var max = Math.max(Date.parse(a.fechaEntrada), Date.parse(a.fechaSalida))
  var min = Math.min(Date.parse(b.fechaEntrada), Date.parse(b.fechaSalida))
  if (max < min) {
    return true;
  }
  return false;
}
