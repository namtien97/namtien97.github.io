public class Main {
    public static void main(String [] args) {
        Television television = new Television(1,10);
        television.setChannel(television.nextChannel());
        television.setVolume(television.upVolume());
        System.out.println("Tivi dang "+television.onTelevision()+" o kenh " + television.getChannel()+" voi am luong " +television.getVolume());
    }
}
