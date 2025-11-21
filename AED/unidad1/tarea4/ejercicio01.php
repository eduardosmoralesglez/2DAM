<?php
$path = "files/ops.csv";
$file = fopen($path, "r");
if (!file_exists($path)) {
    echo "Fichero no existente";
}
for ($i=1; $i < filesize($path)-1 ; $i++) { 
    $line = fgets($file, $i);
    
}

fclose($file);
?>