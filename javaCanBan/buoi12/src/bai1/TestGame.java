package bai1;

public class TestGame {
    public static void main(String[] args) {
        var game = new RockPaperScissorsGame();
        while (true){
            game.initGame();
            game.startGame();
            game.playGame();
            game.endGame();
        }
    }
}
