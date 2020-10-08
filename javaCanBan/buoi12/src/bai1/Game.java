package bai1;

import java.util.ArrayList;
import java.util.List;


public abstract class Game implements GameLoop, Iterable<GamePlayer> {
    List<GamePlayer> players = new ArrayList<GamePlayer>();


    public void addPlayer(GamePlayer namePlayer) {
        players.add(namePlayer);
    }

    public GamePlayer getPlayer() {
        for (int i = 0; i < players.size(); i++) {
            return players.get(i);
        }
        return new GamePlayer();
    }

    public int getSize() {
        return players.size();

    }

    @Override
    public void startGame() {

    }

    @Override
    public void playGame() {

    }

    @Override
    public void endGame() {

    }
}
