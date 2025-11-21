<?php
/**
 * Funcion para jugar al Fizz Buzz
 * @param int $n es el max del array
 * @param int $a es el calculo de los multiplos de Fizz
 * @param int $b es el calculo de los multiplos de Buzz
 * @return array 
 */
function fizzBuzz(int $n, int $a, int $b) : array {
    $array = [];
    for ($i=1; $i <= $n ; $i++) {
        $numero = $i;
        if ($i % $a == 0) {
            $numero = "Fizz";
        }
        if ($i % $b == 0) {
            $numero = "Buzz";
        }
        if ($i % $a == 0 && $n % $b === 0) {
            $numero = "FizzBuzz";
        }
        array_push($array,$numero);
    }
    return $array;
}
foreach (fizzBuzz(15,3,5) as $key) {
    echo "$key, ";
}

?>