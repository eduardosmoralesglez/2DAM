<?php
try {
    $file = fopen("files/datos.txt", "r");
    if (!$file) {
        throw new Exception("Fichero no encontrado");
    }
} catch (Throwable $th) {
    echo "Error: " . $th->getMessage();
}
echo file_get_contents("files/datos.txt");
fclose($file);

?>