package sample;

public class Stocks {

    public double getPriceChange() {

        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    //    public double getPriceChange() {
//        return changePrice();
//    }
    double priceChange = 0;
    double randDouble=Math.random();
    double trend = .5;

    public double changePrice(double stock) {

        double randDouble = Math.random();
        System.out.println(randDouble);

        if (randDouble > 0 && randDouble < 0.1) {
            priceChange = -1.2;
        }
        if (randDouble > 0.1 && randDouble < 0.2) {
            priceChange = -2.3;
        }
        if (randDouble > 0.2 && randDouble < 0.3) {
            priceChange = -3.6;
        }
        if (randDouble > 0.3 && randDouble < 0.4) {
            priceChange = -.7;
        }
        if (randDouble > 0.4 && randDouble < 0.5) {
            priceChange = -.15;
        }
        if (randDouble > .5 && randDouble < 0.6) {
            priceChange = +1.2;
        }
        if (randDouble > .6 && randDouble < 0.7) {
            priceChange = +2.4;
        }
        if (randDouble > .7 && randDouble < 0.8) {
            priceChange = +3.8;
        }
        if (randDouble > .8 && randDouble < 0.9) {
            priceChange = +.4;
        }
        if (randDouble > .9 && randDouble < 1) {
            priceChange = .7;
        }
        if(stock<=3){
            priceChange+=2;
        }
//        trends();
        return priceChange;
    }



    public double changePriceEarnings(double stock, String condition){
        if(condition.equals("failed")){
            stock*=.2;
        }
        if(condition.equals("met")){
            stock*=1.2;
        }
        if(condition.equals("passed")){
            stock*=1.6;
        }
        return stock;
    }

    public double changePriceReport(double stock, String report){
        if(report.equals("optimistic")){
            stock*=1.1;
        }
        if(report.equals("fearful")){
            stock*=0.7;
        }
        if(report.equals("worst")){
            stock*=0.6;
        }
        if(report.equals("best")){
            stock*=1.3;
        }
        if(report.equals("strike")){
            stock*=0.9;
        }
        if(report.equals("audit issue")){
            stock*=0.75;
        }
        if(report.equals("expand")){
            stock*=1.2;
        }
        if(report.equals("buy")){
            stock*=1.4;
        }
        if(report.equals("increase")){
            stock*=1.25;
        }
        if(report.equals("decrease")){
            stock*=0.75;
        }
        return stock;

    }


//    public double buyStock(double stock, double buyingPower, double portBalance, double numShares, boolean hasStock){
//        return portBalance+=stock;
//        return buyingPower-=stock;
//        numShares++;
//        hasStock=true;
//    }
}
