import TicTacToeGame from "@/components/Game";
import { View } from "react-native";

export default function Index() {
  return (
    <View
      style={{
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
      }}
    >
     <TicTacToeGame></TicTacToeGame>
    </View>
  );
}
