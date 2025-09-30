<?php
    $pathPalabras = "palabras.txt";
    $pathResultado = "resultados.txt";
    /**
     * Funcion para leer un fichero mediante su path
     * @param string $path string con la ruta del fichero
     * @return array Con cada linea del fichero
     */
    function leerFichero(String $path): array  {
        $file = fopen($path, "r");
        $contenido = [];
        for ($i=0; $i < filesize($path); $i++) { 
            array_push($contenido, fgets($file));
        }
        fclose($file);
        return $contenido;
    }
    /**
     * Funcion para contar el numero de palabras de un fichero
     * @param string $path String con la ruta del fichero
     * @return int Con el numero de palabras del fichero
     */
    function contadorPalabras(String $path) : int {
        $file = fopen($path, "r");
        $contenido = file_get_contents($path);
        fclose($file);
        return str_word_count($contenido, 0);
        
    }
    function palabrasUnicas(String $path) : int {
        $array = leerFichero($path);
        $unicas = [];
        
    }

    /**
     * Funcion para saber la palabra más larga del fichero
     * @param string $path String con la ruta del fichero
     * @return string String con la palabra mas larga
     */
    function palabraLarga(String $path) : String {
        $array = leerFichero($path);
        $palabraLarga = "";
        foreach ($array as $palabra) {
            $size = sizeof(str_split($palabra));
            $sizeMax = 0;
            if ($size > $sizeMax) {
                $sizeMax = $size;
                $palabraLarga = $palabra;
            }
        }
        return $palabraLarga;
    }
    /**
     * Funcion para saber la palabra mas corta del fichero
     * @param string $path String con la ruta del fichero
     * @return string String con la palabra mas corta
     */
    function palabraCorta(string $path) : String {
        $array = leerFichero($path);
        $palabraCorta = "";
        foreach ($array as $palabra) {
            $size = sizeof(str_split($palabra));
            $sizeMin = 10000000000;
            if ($size < $sizeMin) {
                $sizeMin = $size;
                $palabraCorta = $palabra;
            }
        }
        return $palabraCorta;
    }
    function ordenAlfa() : array {
        
    }
    function palabrasRepe() : array {
        
    }
    function resultado(String $pathFicheroResultado, string $pathFichero) : void {
        
    }
?>