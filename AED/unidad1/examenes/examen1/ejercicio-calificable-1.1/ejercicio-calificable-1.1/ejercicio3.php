<?php
/**
 * Funcion que elimina los duplicados de un numero
 * @param int $numero con el numero a transformar
 * @return int del numero sin duplicados
 */
function duplicados(int $numero) : int {
    $cadena = (string) $numero;
    $nuevo = "";
    for ($i=0; $i < strlen($cadena); $i++) { 
        if (!str_contains($nuevo, $cadena[$i])) {
            $nuevo .= $cadena[$i];
        }
    }
    return (int) $nuevo;
}
echo duplicados(100210305);
?>