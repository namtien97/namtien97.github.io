public class Main {
    public static void main(String [] args){
        Stock SSIStock = new Stock("SSI","Công ty CP chứng khoán SSI");
        SSIStock.setPreviousClosingPrice(34.5);
        SSIStock.setCurrentPrice(34.35);
        System.out.println(SSIStock.getChangePercent());
    }
}
