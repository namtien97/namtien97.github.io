public class Main {
    public static void main(String [] args){
        Calculator calculator1 = new Calculator(4,12,1);
        if(calculator1.getAlpha() < 0){
            System.out.println("Phuong trinh vo nghiem");
        }else if(calculator1.getAlpha() == 0){
            System.out.println("Phuong trinh co 2 nghiem kep: " + calculator1.getAnswer1());
        }else{
            System.out.printf("Phuong trinh co 2 nghiem phan biet: %s va %s%n", calculator1.getAnswer2(calculator1.getAlpha()), calculator1.getAnswer3(calculator1.getAlpha()));
        }
    }
}
