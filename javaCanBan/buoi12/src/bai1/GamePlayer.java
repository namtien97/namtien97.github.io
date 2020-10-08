package bai1;

import java.util.ArrayList;

public class GamePlayer extends Player {
    final private ArrayList<Byte> choosePlayer = new ArrayList<>();

    public GamePlayer() {
        super();
    }

    public GamePlayer(String namePlayer) {
        super(namePlayer);
    }

    public void addChoosePlayer(String choose) {
        if (choose == "r") {
            choosePlayer.add((byte) 0);
        } else if (choose == "p") {
            choosePlayer.add((byte) 1);
        } else {
            choosePlayer.add((byte) 2);
        }
    }

    public Byte getChoosePlayer(byte indexChoose) {
        return choosePlayer.get(indexChoose);
    }

    public void increaseScore() {
        super.setScore((byte) (getScore() + 1));
    }

    public void removeScore() {
        super.setScore((byte) 0);
    }
}
