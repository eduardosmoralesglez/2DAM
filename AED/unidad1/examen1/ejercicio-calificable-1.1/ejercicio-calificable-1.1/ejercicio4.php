<?php
/**
 * Funcion para calculos basicos estadisticos
 * @param array $numeros Lista con todos los numeros a calcular
 * @return array con los resultados, Max, Min, Suma, Promedio
 */
function estadisticos(array $numeros) : array {
    $resultados = [];
    $max = max($numeros);
    $min = min($numeros);
    $suma = array_sum($numeros);
    $promedio = $suma/count($numeros) ;
    array_push($resultados, $max, $min, $suma, $promedio);
    return $resultados;
}
$prueba = [5,2,9];
foreach (estadisticos($prueba) as $n) {
    echo "$n, ";
}
?>