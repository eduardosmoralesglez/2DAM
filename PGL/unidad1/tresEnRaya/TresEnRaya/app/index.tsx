import {  TouchableOpacity, Text } from "react-native";
//TODO: Ver el tutorial: https://www.youtube.com/watch?v=U23lNFm_J70
type SquarePromps = {
  val: String
}


export function Val(val: SquarePromps) {
  return val;
}
export function Square() {
  return (
      <TouchableOpacity>
        <Text>{}</Text>
      </TouchableOpacity>
  );
}

export function Board() {
  return (
    <Text>a</Text>
  );
}

export default function Index() {
  return (
    <Square>
    </Square>
  );
}
