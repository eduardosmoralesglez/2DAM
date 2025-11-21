export async function fetchPersonById(id: string) {
  const res = await fetch(`https://swapi.dev/api/people/${id}/`);
  if (!res.ok) {
    throw new Error(res.status === 404 ? "Personaje no encontrado" : "Error en la solicitud");
  }
  return res.json();
}

export async function fetchPlanetById(id: string) {
  const res = await fetch(`https://swapi.dev/api/planets/${id}/`);
  if (!res.ok) {
    throw new Error(res.status === 404 ? "Planeta no encontrado" : "Error en la solicitud");
  }
  return res.json();
}

export async function fetchStarshipById(id: string) {
  const res = await fetch(`https://swapi.dev/api/starships/${id}/`);
  if (!res.ok) {
    throw new Error(res.status === 404 ? "Nave no encontrada" : "Error en la solicitud");
  }
  return res.json();
}

