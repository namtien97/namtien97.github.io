package bai1;

public class Main {
    public static void main(String[] args) {
        var oneWayTicket = new OneWayTicket(180);
        var prepaidCard = new PrepaidCard(200);
        Line.A.enter(oneWayTicket);
        Line.C.exit(oneWayTicket);
        System.out.println(Line.C);
        System.out.println(oneWayTicket);
    }
}
