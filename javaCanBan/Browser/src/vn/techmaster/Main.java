package vn.techmaster;

public class Main {
    public static void main(String []args){
        var navigate = new Browser();
        navigate.navigate();
        String content = navigate.navigate("techmaster.vn");
    }
}
