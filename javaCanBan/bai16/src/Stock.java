public class Stock {
    private String codeStock;
    private String nameStock;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String codeStock,String nameStock){
        this.codeStock = codeStock;
        this.nameStock = nameStock;
    }

    public void setPreviousClosingPrice(double previousClosingPrice){
        this.previousClosingPrice=previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }

    public double getChangePercent(){
        return previousClosingPrice/currentPrice;
    }
}
