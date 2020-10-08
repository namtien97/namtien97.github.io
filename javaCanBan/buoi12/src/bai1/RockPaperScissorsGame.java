package bai1;

import java.util.Iterator;
import java.util.Scanner;

public class RockPaperScissorsGame extends Game {
    Scanner sc = new Scanner(System.in);
    GamePlayer newPlayer;
    byte scoreCom = 0;

    public void initGame() {
        System.out.print("Nhap ten nguoi choi: ");
        String namePlayer = sc.nextLine();
        super.addPlayer(newPlayer = new GamePlayer(namePlayer));
        System.out.println(newPlayer);
        scoreCom = 0;
        newPlayer.removeScore();
    }

    @Override
    public void startGame() {
        System.out.println("Nhập vào r (rock), p (paper) hoặc s (scissors)");
        System.out.println("    _________________________________________");
    }

    @Override
    public void playGame() {
        byte turnPlay = 0;
        do {
            System.out.println("    Nhập vào lựa chọn của bạn");

            while (true) {
                System.out.printf("    ");
                String choosePlayer = sc.nextLine();
                if (choosePlayer.equals("r") || choosePlayer.equals("p") || choosePlayer.equals("s")) {
                    newPlayer.addChoosePlayer(choosePlayer);
                    break;
                } else {
                    System.out.println("    Ban phai nhap \"r\", \"p\" hoặc \"s\"");
                }
            }
            byte result = GameLogic.checkWinnerOnTurn(newPlayer.getChoosePlayer(turnPlay)); //Lượt chơi sẽ là biến để xác định index trong mảng luôn
            if (result == 0) {
                System.out.println("    Máy tính thắng");
                scoreCom++;
            } else {
                System.out.println("    Người chơi thắng");
                newPlayer.increaseScore();
            }
            System.out.println("    _________________________");
            turnPlay++;
        } while (turnPlay < 3);
    }

    @Override
    public void endGame() {
        System.out.println("    Người chơi vs. Máy tính");
        System.out.println("    Score người chơi: " + newPlayer.getScore());
        System.out.println("    Score máy tính: " + scoreCom);
        if (GameLogic.checkWinnerFinal(newPlayer.getScore(), scoreCom) == 1) {
            System.out.println("    Người chơi thắng.");
        } else {
            System.out.println("    Người chơi thua.");
        }
        System.out.println(super.getPlayer());
        System.out.println(super.getSize());
    }


    @Override
    public Iterator<GamePlayer> iterator() {
        return null;
    }
}
