package bai1;

public class Player implements Comparable<Player> {
    private String namePlayer;
    private byte score = 0;

    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public Player() {

    }

    public byte getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return score - o.score;
    }

    @Override
    public String toString() {
        return "Player: " + namePlayer + "\n";
    }
}
