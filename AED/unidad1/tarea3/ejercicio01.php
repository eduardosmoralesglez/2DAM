<?php

$file = fopen("files/datos.txt", "r");
fwrite($file, "Hola mundo");
fclose($file);

// Comprobar existencia
if (file_exists("TestFolder/test.txt")) {
    echo "El archivo existe\n";
}
?>