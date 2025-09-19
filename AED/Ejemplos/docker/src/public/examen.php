<?php 
    declare( strict_type=1);
    function esCapicua(int $n) {
        $arrayInt = $n.str_split(1);
        foreach ($arrayInt as $key => $value) {
            echo $value;
        }
    }
    echo esCapicua(123321);
?>