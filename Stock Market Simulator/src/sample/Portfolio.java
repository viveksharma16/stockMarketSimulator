package sample;

import java.util.ArrayList;

public class  Portfolio {
    private int x;
    private int y;
    private long startTime;
    private ArrayList userStocks;

    //main which creates the parameter calls
//    public Portfolio(int x,int y){
//        this.y = y;
//        this.x = x;
//        //starts the time
//        startTime = System.nanoTime();
//    }

    public double changePortBalance(double stock, double portBalance, boolean bool){
        if(bool){
            return portBalance+stock;
        }
        if(!bool) {
            return portBalance - stock;
        }
        return portBalance;
    }

    public double changeBuyingPower(double stock, double buyingPower, boolean bool){
        if(bool){
            return buyingPower+stock;
        }
        if(!bool){
            return buyingPower-stock;
        }
        return buyingPower;
    }

    public double changeNumShares(double stock, double numShares, int numSharesToChange, boolean bool){
        if(bool){
            return numShares+numSharesToChange;
        }
        if(!bool){
            return numShares-numSharesToChange;
        }
        return numShares;
    }
    public int getX() {//returns the x value of grass
        return x;
    }

    public int getY() {//returns the y value of grass
        return y;
    }
}
