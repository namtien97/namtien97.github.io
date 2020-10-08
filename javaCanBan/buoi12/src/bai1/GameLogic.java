package bai1;

public class GameLogic {
    public static byte rockPaperScissor() {
        return (byte) (Math.random() * 3);
    }

    public static byte checkWinnerOnTurn(Byte choosePlayer) {
        if ((GameLogic.rockPaperScissor() == 0) && (choosePlayer == 2)) {
            return 0;//Player lose
        } else if ((GameLogic.rockPaperScissor() == 2) && (choosePlayer == 2)) {
            return 1;//Player win
        }
        return (byte) ((GameLogic.rockPaperScissor()) > (choosePlayer) ? 0:1);
    }

    public static byte checkWinnerFinal(Byte scorePlayer, Byte scoreCom){
        if(scorePlayer>scoreCom){
            return 1;
        }else{
            return 0;
        }
    }
}
