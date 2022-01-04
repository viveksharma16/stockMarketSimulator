package sample;



import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.math.RoundingMode;

import javax.sound.sampled.Port;

public class Controller<timeCurrent2, graphTimer2> {

    private double userBuyingPower = 10000;
    private double userPortfolioBalance = 0;
    ArrayList<String> userStocksBought = new ArrayList<String>();
    ArrayList<Double> allStocksAvailable = new ArrayList<>();
    ArrayList<String> allStocksAvailableS = new ArrayList<>();
    ArrayList<Double> stocksNeedingEarnings = new ArrayList<>();
    ArrayList<Double> tempStocksNeedingEarnings = new ArrayList<>();
    TabPane tabPaneAllStocksAvailable;
    @FXML
    Label lblBuyingPower, lblStockName, lblStockCurrentValue, lblNumOwn, lblTotalReturn, lblStockReturn, lblNewsTest;
    @FXML
    Label lblPortfolioBalance;
    @FXML
    Tab tabAMZN, tabGM, tabF, tabGE, tabPLUG, tabDIS, tabSQ, tabJNJ, tabNKLA, tabQS, tabAAPL, tabTSLA, tabFB, tabTWTR, tabMFST, tabBABA;
    @FXML
    PieChart pieRating;
    @FXML
    AnchorPane paneCover;
    @FXML
    TextField txtName;
    @FXML
    XYChart.Series seriesAMZN = new XYChart.Series();//creates series for each stock
    XYChart.Series seriesGM = new XYChart.Series();
    XYChart.Series seriesF = new XYChart.Series();
    XYChart.Series seriesGE = new XYChart.Series();//creates series for each stock
    XYChart.Series seriesPLUG = new XYChart.Series();
    XYChart.Series seriesDIS = new XYChart.Series();
    XYChart.Series seriesSQ = new XYChart.Series();//creates series for each stock
    XYChart.Series seriesJNJ = new XYChart.Series();
    XYChart.Series seriesNKLA = new XYChart.Series();
    XYChart.Series seriesQS = new XYChart.Series();//creates series for each stock
    XYChart.Series seriesAAPL = new XYChart.Series();
    XYChart.Series seriesTSLA = new XYChart.Series();
    XYChart.Series seriesFB = new XYChart.Series();//creates series for each stock
    XYChart.Series seriesTWTR = new XYChart.Series();
    XYChart.Series seriesMFST = new XYChart.Series();
    XYChart.Series seriesBABA = new XYChart.Series();
    XYChart.Series seriesTotal = new XYChart.Series();
    @FXML
    LineChart graphAMZN, graphGM, graphF, graphGE, graphPLUG, graphDIS, graphSQ, graphJNJ, graphNKLA, graphQS, graphAAPL, graphTSLA, graphFB, graphTWTR, graphMFST, graphBABA, graphTotalPortfolio;
    @FXML
    ListView lstStocksOwn, lstEarningsNews, lstNewsReports;
    @FXML
    TextField txtNumBuy, txtNumSell, txtLimitNumShares, txtLimitSellPrice;
    @FXML
    Button startButton;
    @FXML
    ChoiceBox cbStockNews;
//
    private int counter = 0;
    private int counterTotal = 0;
    private long graphTimer, graphTimer2, graphTimer3;
    double NIO = 37.51;
    double AMZN = 3285;
    double total = 0;
    int quarter = 1;
    private int numSharesToBuy;
    private int numSharesToSell;
    private int numSharesToSellLimitF;
    private int numSharesToSellLimitGM;
    private int numSharesToSellLimitAMZN;
    private int numSharesToSellLimitGE;
    private int numSharesToSellLimitPLUG;
    private int numSharesToSellLimitDIS;
    private int numSharesToSellLimitSQ;
    private int numSharesToSellLimitQS;
    private int numSharesToSellLimitTWTR;
    private int numSharesToSellLimitMFST;
    private int numSharesToSellLimitBABA;
    private int numSharesToSellLimitFB;
    private int numSharesToSellLimitAAPL;
    private int numSharesToSellLimitJNJ;
    private int numSharesToSellLimitNKLA;
    private int numSharesToSellLimitTSLA;
    boolean hasFord, hasGM, hasAMZN, hasGE, hasPLUG, hasDIS, hasSQ, hasJNJ, hasNKLA, hasQS, hasAAPL, hasTSLA, hasFB, hasTWTR, hasMFST, hasBABA, fEarnings, gmEarnings, amznEarnings, geEarnings, plugEarnings, disEarnings, sqEarnings, jnjEarnings, nklaEarnings, qsEarnings, aaplEarnings, tslaEarnings, fbEarnings, twtrEarnings, mfstEarnings, babaEarnings;
    ArrayList<Double> lstAMZN = new ArrayList<>();
    ArrayList<Double> lstGM = new ArrayList<>();
    ArrayList<Double> lstF = new ArrayList<>();
    ArrayList<Double> lstGE = new ArrayList<>();
    ArrayList<Double> lstPLUG = new ArrayList<>();
    ArrayList<Double> lstDIS = new ArrayList<>();
    ArrayList<Double> lstSQ = new ArrayList<>();
    ArrayList<Double> lstJNJ = new ArrayList<>();
    ArrayList<Double> lstNKLA = new ArrayList<>();
    ArrayList<Double> lstQS = new ArrayList<>();
    ArrayList<Double> lstAAPL = new ArrayList<>();
    ArrayList<Double> lstTSLA = new ArrayList<>();
    ArrayList<Double> lstFB = new ArrayList<>();
    ArrayList<Double> lstTWTR = new ArrayList<>();
    ArrayList<Double> lstMFST = new ArrayList<>();
    ArrayList<Double> lstBABA = new ArrayList<>();
    ArrayList<Boolean> lstEarnings = new ArrayList<>();
    ArrayList<Double> userPortfolio = new ArrayList<>();
    double GM = 61.06;
    double GE = 13.39;
    double PLUG = 32.05;
    double DIS = 187.66;
    double SQ = 244.66;
    double JNJ = 163.61;
    double NKLA = 12.40;
    double QS = 47.39;
    double AAPL = 128.39;
    double TSLA = 672;
    double NFLX = 548.75;
    double FB = 314.04;
    double TWTR = 69.19;
    double MFST = 250.12;
    double BABA = 225.70;
    double F = 12.73;
    double stockPlaceHolder = 4;
    double numF = 0;
    double numGM = 0;
    double numAMZN = 0;
    double numGE = 0;
    double numPLUG = 0;
    double numDIS = 0;
    double numSQ = 0;
    double numJNJ = 0;
    double numNKLA = 0;
    double numQS = 0;
    double numAAPL = 0;
    double numTSLA = 0;
    double numFB = 0;
    double numTWTR = 0;
    double numMFST = 0;
    double numBABA = 0;


    double buyPriceF = 0;
    double buyPriceGM = 0;
    double buyPriceAMZN = 0;
    double buyPriceGE = 0;
    double buyPricePLUG = 0;
    double buyPriceDIS = 0;
    double buyPriceSQ = 0;
    double buyPriceJNJ = 0;
    double buyPriceNKLA = 0;
    double buyPriceQS = 0;
    double buyPriceAAPL = 0;
    double buyPriceTSLA = 0;
    double buyPriceFB = 0;
    double buyPriceTWTR = 0;
    double buyPriceMFST = 0;
    double buyPriceBABA = 0;

    double limitF = 0;
    double limitGM = 0;
    double limitAMZN = 0;
    double limitGE = 0;
    double limitPLUG = 0;
    double limitDIS = 0;
    double limitSQ = 0;
    double limitJNJ = 0;
    double limitNKLA = 0;
    double limitQS = 0;
    double limitAAPL = 0;
    double limitTSLA = 0;
    double limitFB = 0;
    double limitTWTR = 0;
    double limitMFST = 0;
    double limitBABA = 0;

    double totalReturn;
    double allStocksOwn;


    @FXML
    private void handleStart() {
//        paneCover.setVisible(false);
//        txtName.setVisible(false);
        handleNewEarnings();
        handleReport();
        startButton.setVisible(false);
        allStocksAvailable.add(F);
        allStocksAvailable.add(AMZN);
        allStocksAvailable.add(GM);
        allStocksAvailable.add(GE);
        allStocksAvailable.add(PLUG);
        allStocksAvailable.add(DIS);
        allStocksAvailable.add(SQ);
        allStocksAvailable.add(JNJ);
        allStocksAvailable.add(NKLA);
        allStocksAvailable.add(QS);
        allStocksAvailable.add(AAPL);
        allStocksAvailable.add(TSLA);
        allStocksAvailable.add(NFLX);
        allStocksAvailable.add(FB);
        allStocksAvailable.add(TWTR);
        allStocksAvailable.add(MFST);
        allStocksAvailable.add(BABA);

        stocksNeedingEarnings.add(F);
        stocksNeedingEarnings.add(AMZN);
        stocksNeedingEarnings.add(GM);
        stocksNeedingEarnings.add(GE);
        stocksNeedingEarnings.add(PLUG);
        stocksNeedingEarnings.add(DIS);
        stocksNeedingEarnings.add(SQ);
        stocksNeedingEarnings.add(JNJ);
        stocksNeedingEarnings.add(NKLA);
        stocksNeedingEarnings.add(QS);
        stocksNeedingEarnings.add(AAPL);
        stocksNeedingEarnings.add(TSLA);
        stocksNeedingEarnings.add(NFLX);
        stocksNeedingEarnings.add(FB);
        stocksNeedingEarnings.add(TWTR);
        stocksNeedingEarnings.add(MFST);
        stocksNeedingEarnings.add(BABA);

        lstEarnings.add(fEarnings);
        lstEarnings.add(amznEarnings);
        lstEarnings.add(gmEarnings);
        lstEarnings.add(geEarnings);
        lstEarnings.add(plugEarnings);
        lstEarnings.add(disEarnings);
        lstEarnings.add(sqEarnings);
        lstEarnings.add(jnjEarnings);
        lstEarnings.add(nklaEarnings);
        lstEarnings.add(qsEarnings);
        lstEarnings.add(aaplEarnings);
        lstEarnings.add(tslaEarnings);
        lstEarnings.add(fbEarnings);
        lstEarnings.add(twtrEarnings);
        lstEarnings.add(mfstEarnings);
        lstEarnings.add(babaEarnings);

        new AnimationTimer() {
            @Override
            public void handle(long timeCurrent) {
                //if which will run this every second as told to do so
                //uses the currentTime and checks that with the graphTimer
                if (timeCurrent - graphTimer > 1000000000.0) {

                    graphTimer = System.nanoTime();
                    Stocks stocks = new Stocks();
                    stocks.changePrice(stockPlaceHolder);
                    handleChangePrice();
                    System.out.println(AMZN);
                    handleAddValueToList();
                    graphStockData();
                    if (tabAMZN.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf((AMZN)));
                        lblNumOwn.setText(String.valueOf((numAMZN)));
//                        handlePieChart();
                        if (hasAMZN) {
                            lblStockReturn.setText(String.valueOf(AMZN * numAMZN - numAMZN * buyPriceAMZN));
                            if (AMZN * numAMZN - numAMZN * buyPriceAMZN >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabGM.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf((GM)));
                        lblNumOwn.setText(String.valueOf(numGM));
//                        handlePieChart();
                        if (hasGM) {
                            lblStockReturn.setText(String.valueOf(((GM * numGM - numGM * buyPriceGM))));
                            if (GM * numGM - numGM * buyPriceGM >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabF.isSelected()) {
                        lblStockCurrentValue.setText((String.valueOf(F)));
                        lblNumOwn.setText(String.valueOf(numF));
//                        handlePieChart();
                        if (hasFord) {
                            lblStockReturn.setText(String.valueOf((F * numF - numF * buyPriceF)));
                            if (F * numF - numF * buyPriceF >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabGE.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf((GE)));
                        lblNumOwn.setText(String.valueOf(numGE));
//                        handlePieChart();
                        if (hasGE) {
                            lblStockReturn.setText(String.valueOf((GE * numGE - numGE * buyPriceGE)));
                            if (GE * numGE - numGE * buyPriceGE >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabPLUG.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf((PLUG)));
                        lblNumOwn.setText(String.valueOf(numPLUG));
//                        handlePieChart();
                        if (hasPLUG) {
                            lblStockReturn.setText(String.valueOf((PLUG * numPLUG - numPLUG * buyPricePLUG)));
                            if (PLUG * numPLUG - numPLUG * buyPricePLUG >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabDIS.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(DIS));
                        lblNumOwn.setText(String.valueOf(numDIS));
//                        handlePieChart();
                        if (hasDIS) {
                            lblStockReturn.setText(String.valueOf(DIS * numDIS - numDIS * buyPriceDIS));
                            if (DIS * numDIS - numDIS * buyPriceDIS >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabSQ.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(SQ));
                        lblNumOwn.setText(String.valueOf(numSQ));
//                        handlePieChart();
                        if (hasSQ) {
                            lblStockReturn.setText(String.valueOf(SQ * numSQ - numSQ * buyPriceSQ));
                            if (SQ * numSQ - numSQ * buyPriceSQ >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabJNJ.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(JNJ));
                        lblNumOwn.setText(String.valueOf(numJNJ));
//                        handlePieChart();
                        if (hasJNJ) {
                            lblStockReturn.setText(String.valueOf(JNJ * numJNJ - numJNJ * buyPriceJNJ));
                            if (JNJ * numJNJ - numJNJ * buyPriceJNJ >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabNKLA.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(NKLA));
                        lblNumOwn.setText(String.valueOf(numNKLA));
//                        handlePieChart();
                        if (hasNKLA) {
                            lblStockReturn.setText(String.valueOf(NKLA * numNKLA - numNKLA * buyPriceNKLA));
                            if (NKLA * numNKLA - numNKLA * buyPriceNKLA >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabQS.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(QS));
                        lblNumOwn.setText(String.valueOf(numQS));
//                        handlePieChart();
                        if (hasQS) {
                            lblStockReturn.setText(String.valueOf(QS * numQS - numQS * buyPriceQS));
                            if (QS* numQS - numQS * buyPriceQS >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabAAPL.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(AAPL));
                        lblNumOwn.setText(String.valueOf(numAAPL));
//                        handlePieChart();
                        if (hasAAPL) {
                            lblStockReturn.setText(String.valueOf(AAPL * numAAPL - numAAPL * buyPriceAAPL));
                            if (AAPL * numAAPL - numAAPL* buyPriceAAPL >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabTSLA.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(TSLA));
                        lblNumOwn.setText(String.valueOf(numTSLA));
//                        handlePieChart();
                        if (hasTSLA) {
                            lblStockReturn.setText(String.valueOf(TSLA * numTSLA - numTSLA * buyPriceTSLA));
                            if (TSLA * numTSLA - numTSLA * buyPriceTSLA >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabFB.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(FB));
                        lblNumOwn.setText(String.valueOf(numFB));
//                        handlePieChart();
                        if (hasFB) {
                            lblStockReturn.setText(String.valueOf(FB * numFB - numFB * buyPriceFB));
                            if (FB * numFB - numFB * buyPriceFB >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabTWTR.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(TWTR));
                        lblNumOwn.setText(String.valueOf(numTWTR));
//                        handlePieChart();
                        if (hasTWTR) {
                            lblStockReturn.setText(String.valueOf(TWTR* numTWTR - numTWTR * buyPriceTWTR));
                            if (TWTR * numTWTR - numTWTR * buyPriceTWTR>= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabMFST.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(MFST));
                        lblNumOwn.setText(String.valueOf(numMFST));
//                        handlePieChart();
                        if (hasMFST) {
                            lblStockReturn.setText(String.valueOf(MFST* numMFST - numMFST * buyPriceMFST));
                            if (MFST* numMFST - numMFST* buyPriceMFST >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
                    if (tabBABA.isSelected()) {
                        lblStockCurrentValue.setText(String.valueOf(BABA));
                        lblNumOwn.setText(String.valueOf(numBABA));
//                        handlePieChart();
                        if (hasBABA) {
                            lblStockReturn.setText(String.valueOf(BABA * numBABA- numBABA * buyPriceBABA));
                            if (BABA * numBABA - numBABA * buyPriceBABA >= 0) {
                                lblStockReturn.setStyle("-fx-text-fill: green;");
                            } else {
                                lblStockReturn.setStyle("-fx-text-fill: red;");
                            }
                        } else {
                            lblStockReturn.setText("");
                        }
                    }
//                    lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
                    lblBuyingPower.setText(String.valueOf(userBuyingPower));

                    userPortfolio.clear();
                    lstStocksOwn.getItems().clear();
                    Portfolio p = new Portfolio();
                    if (hasFord) {
                        userPortfolio.add(F * numF);
                        lstStocksOwn.getItems().add("Ford   ||   Value Of Ownership: " + F * numF);
                        totalReturn += F * numF - numF * buyPriceF;
                        if(limitF <= F&&numF>=numSharesToSellLimitF){
                            userBuyingPower = p.changeBuyingPower(F * numSharesToSellLimitF, userBuyingPower, true);
                            numF = p.changeNumShares(F, numF, numSharesToSellLimitF, false);
                            if (numF < 1) {
                                hasFord = false;
                                buyPriceF = 0;
                            }
                            numSharesToSellLimitF=0;
                            limitF=0;
                        }
//                        allStocksOwn+=F*numF;
                    }
                    if (hasGM) {
                        userPortfolio.add(GM * numGM);
                        lstStocksOwn.getItems().add("GM   ||   Value Of Ownership: " + GM * numGM);
                        totalReturn += GM * numGM - numGM * buyPriceGM;
                        if(limitGM <= GM&&numGM>=numSharesToSellLimitGM){
                            userBuyingPower = p.changeBuyingPower(GM * numSharesToSellLimitGM, userBuyingPower, true);
                            numGM = p.changeNumShares(GM, numGM, numSharesToSellLimitGM, false);
                            if (numGM < 1) {
                                hasGM = false;
                                buyPriceGM = 0;
                            }
                            numSharesToSellLimitGM=0;
                            limitGM=0;
                        }
//                        allStocksOwn+=GM*numGM;
                    }
                    if (hasAMZN) {
                        userPortfolio.add(AMZN * numAMZN);
                        lstStocksOwn.getItems().add("AMZN   ||   Value Of Ownership: " + AMZN * numAMZN);
                        totalReturn += AMZN * numAMZN - numAMZN * buyPriceAMZN;
                        if(limitAMZN <= AMZN&&numAMZN>=numSharesToSellLimitAMZN){
                            userBuyingPower = p.changeBuyingPower(AMZN * numSharesToSellLimitAMZN, userBuyingPower, true);
                            numAMZN = p.changeNumShares(AMZN, numAMZN, numSharesToSellLimitAMZN, false);
                            if (numAMZN < 1) {
                                hasAMZN = false;
                                buyPriceAMZN = 0;
                            }
                            numSharesToSellLimitAMZN=0;
                            limitAMZN=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasGE) {
                        userPortfolio.add(GE * numGE);
                        lstStocksOwn.getItems().add("GE   ||   Value Of Ownership: " + GE * numGE);
                        totalReturn += GE * numGE - numGE * buyPriceGE;
                        if(limitGE <= GE&&numGE>=numSharesToSellLimitGE){
                            userBuyingPower = p.changeBuyingPower(GE * numSharesToSellLimitGE, userBuyingPower, true);
                            numGE = p.changeNumShares(GE, numGE, numSharesToSellLimitGE, false);
                            if (numGE < 1) {
                                hasGE = false;
                                buyPriceGE =0;
                            }
                            numSharesToSellLimitGE=0;
                            limitGE=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasPLUG) {
                        userPortfolio.add(PLUG * numPLUG);
                        lstStocksOwn.getItems().add("PLUG   ||   Value Of Ownership: " + PLUG * numPLUG);
                        totalReturn += PLUG * numPLUG - numPLUG * buyPricePLUG;
                        if(limitPLUG <= PLUG&&numPLUG>=numSharesToSellLimitPLUG){
                            userBuyingPower = p.changeBuyingPower(PLUG * numSharesToSellLimitPLUG, userBuyingPower, true);
                            numF = p.changeNumShares(PLUG, numPLUG, numSharesToSellLimitPLUG, false);
                            if (numPLUG < 1) {
                                hasPLUG = false;
                                buyPricePLUG = 0;
                            }
                            numSharesToSellLimitPLUG=0;
                            limitPLUG=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasDIS) {
                        userPortfolio.add(DIS * numDIS);
                        lstStocksOwn.getItems().add("DIS   ||   Value Of Ownership: " + DIS * numDIS);
                        totalReturn += DIS * numDIS- numDIS * buyPriceDIS;
                        if(limitDIS <= DIS&&numDIS>=numSharesToSellLimitDIS){
                            userBuyingPower = p.changeBuyingPower(DIS * numSharesToSellLimitDIS, userBuyingPower, true);
                            numDIS = p.changeNumShares(DIS, numDIS, numSharesToSellLimitDIS, false);
                            if (numDIS < 1) {
                                hasDIS = false;
                                buyPriceDIS = 0;
                            }
                            numSharesToSellLimitDIS=0;
                            limitDIS=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasSQ) {
                        userPortfolio.add(SQ * numSQ);
                        lstStocksOwn.getItems().add("SQ   ||   Value Of Ownership: " + SQ * numSQ);
                        totalReturn += SQ * numSQ - numSQ * buyPriceSQ;
                        if(limitSQ <= SQ&&numSQ>=numSharesToSellLimitSQ){
                            userBuyingPower = p.changeBuyingPower(SQ * numSharesToSellLimitSQ, userBuyingPower, true);
                            numF = p.changeNumShares(SQ, numSQ, numSharesToSellLimitSQ, false);
                            if (numSQ < 1) {
                                hasSQ = false;
                                buyPriceSQ = 0;
                            }
                            numSharesToSellLimitSQ=0;
                            limitSQ=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasJNJ) {
                        userPortfolio.add(JNJ * numJNJ);
                        lstStocksOwn.getItems().add("JNJ   ||   Value Of Ownership: " + JNJ * numJNJ);
                        totalReturn += JNJ * numJNJ - numJNJ * buyPriceJNJ;
                        if(limitJNJ <= JNJ&&numJNJ>=numSharesToSellLimitJNJ){
                            userBuyingPower = p.changeBuyingPower(JNJ * numSharesToSellLimitJNJ, userBuyingPower, true);
                            numJNJ = p.changeNumShares(JNJ, numJNJ, numSharesToSellLimitJNJ, false);
                            if (numJNJ < 1) {
                                hasJNJ = false;
                                buyPriceJNJ = 0;
                            }
                            numSharesToSellLimitJNJ=0;
                            limitJNJ=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasNKLA) {
                        userPortfolio.add(NKLA * numNKLA);
                        lstStocksOwn.getItems().add("NKLA   ||   Value Of Ownership: " + NKLA * numNKLA);
                        totalReturn += NKLA * numNKLA - numNKLA * buyPriceNKLA;
                        if(limitNKLA <= NKLA&&numNKLA>=numSharesToSellLimitNKLA){
                            userBuyingPower = p.changeBuyingPower(NKLA * numSharesToSellLimitNKLA, userBuyingPower, true);
                            numNKLA = p.changeNumShares(NKLA, numNKLA, numSharesToSellLimitNKLA, false);
                            if (numNKLA < 1) {
                                hasNKLA = false;
                                buyPriceNKLA = 0;
                            }
                            numSharesToSellLimitNKLA=0;
                            limitNKLA=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasQS) {
                        userPortfolio.add(QS * numQS);
                        lstStocksOwn.getItems().add("QS   ||   Value Of Ownership: " + QS * numQS);
                        totalReturn += QS * numQS - numQS * buyPriceQS;
                        if(limitQS <= QS&&numQS>=numSharesToSellLimitQS){
                            userBuyingPower = p.changeBuyingPower(QS * numSharesToSellLimitQS, userBuyingPower, true);
                            numQS = p.changeNumShares(QS, numQS, numSharesToSellLimitQS, false);
                            if (numQS < 1) {
                                hasQS = false;
                                buyPriceQS = 0;
                            }
                            numSharesToSellLimitQS=0;
                            limitQS=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasAAPL) {
                        userPortfolio.add(AAPL * numAAPL);
                        lstStocksOwn.getItems().add("AAPL   ||   Value Of Ownership: " + AAPL * numAAPL);
                        totalReturn += AAPL * numAAPL - numAAPL * buyPriceAAPL;
                        if(limitAAPL <= AAPL&&numAAPL>=numSharesToSellLimitAAPL){
                            userBuyingPower = p.changeBuyingPower(AAPL * numSharesToSellLimitAAPL, userBuyingPower, true);
                            numAAPL = p.changeNumShares(AAPL, numAAPL, numSharesToSellLimitAAPL, false);
                            if (numAAPL < 1) {
                                hasAAPL = false;
                                buyPriceAAPL = 0;
                            }
                            numSharesToSellLimitAAPL=0;
                            limitAAPL=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasTSLA) {
                        userPortfolio.add(TSLA * numTSLA);
                        lstStocksOwn.getItems().add("TSLA   ||   Value Of Ownership: " + TSLA * numTSLA);
                        totalReturn += TSLA * numTSLA - numTSLA * buyPriceTSLA;
                        if(limitTSLA <= TSLA&&numTSLA>=numSharesToSellLimitTSLA){
                            userBuyingPower = p.changeBuyingPower(TSLA * numSharesToSellLimitTSLA, userBuyingPower, true);
                            numTSLA = p.changeNumShares(TSLA, numTSLA, numSharesToSellLimitTSLA, false);
                            if (numTSLA < 1) {
                                hasTSLA = false;
                                buyPriceTSLA = 0;
                            }
                            numSharesToSellLimitTSLA=0;
                            limitTSLA=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasFB) {
                        userPortfolio.add(FB * numFB);
                        lstStocksOwn.getItems().add("FB   ||   Value Of Ownership: " + FB * numFB);
                        totalReturn += FB * numFB - numFB * buyPriceFB;
                        if(limitFB <= FB&&numFB>=numSharesToSellLimitFB){
                            userBuyingPower = p.changeBuyingPower(FB * numSharesToSellLimitFB, userBuyingPower, true);
                            numFB = p.changeNumShares(FB, numFB, numSharesToSellLimitFB, false);
                            if (numFB < 1) {
                                hasFB = false;
                                buyPriceFB = 0;
                            }
                            numSharesToSellLimitFB=0;
                            limitFB=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasTWTR) {
                        userPortfolio.add(TWTR * numTWTR);
                        lstStocksOwn.getItems().add("TWTR   ||   Value Of Ownership: " + TWTR * numTWTR);
                        totalReturn += TWTR * numTWTR - numTWTR * buyPriceTWTR;
                        if(limitTWTR <= TWTR&&numTWTR>=numSharesToSellLimitTWTR){
                            userBuyingPower = p.changeBuyingPower(TWTR * numSharesToSellLimitTWTR, userBuyingPower, true);
                            numTWTR = p.changeNumShares(TWTR, numTWTR, numSharesToSellLimitTWTR, false);
                            if (numTWTR < 1) {
                                hasTWTR = false;
                                buyPriceTWTR = 0;
                            }
                            numSharesToSellLimitTWTR=0;
                            limitTWTR=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasMFST) {
                        userPortfolio.add(MFST * numMFST);
                        lstStocksOwn.getItems().add("MFST   ||   Value Of Ownership: " + MFST * numMFST);
                        totalReturn += MFST * numMFST - numMFST * buyPriceMFST;
                        if(limitMFST <= MFST&&numMFST>=numSharesToSellLimitMFST){
                            userBuyingPower = p.changeBuyingPower(MFST * numSharesToSellLimitMFST, userBuyingPower, true);
                            numMFST = p.changeNumShares(MFST, numMFST, numSharesToSellLimitMFST, false);
                            if (numMFST < 1) {
                                hasMFST = false;
                                buyPriceMFST = 0;
                            }
                            numSharesToSellLimitMFST=0;
                            limitMFST=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }
                    if (hasBABA) {
                        userPortfolio.add(BABA * numBABA);
                        lstStocksOwn.getItems().add("BABA   ||   Value Of Ownership: " + BABA * numBABA);
                        totalReturn += BABA * numBABA - numBABA * buyPriceBABA;
                        if(limitBABA <= BABA&&numBABA>=numSharesToSellLimitBABA){
                            userBuyingPower = p.changeBuyingPower(BABA * numSharesToSellLimitBABA, userBuyingPower, true);
                            numBABA = p.changeNumShares(BABA, numBABA, numSharesToSellLimitBABA, false);
                            if (numBABA < 1) {
                                hasBABA = false;
                                buyPriceBABA = 0;
                            }
                            numSharesToSellLimitBABA=0;
                            limitBABA=0;
                        }
//                        allStocksOwn+=AMZN*numAMZN;
                    }

                    for (int i = 0; i < userPortfolio.size(); i++) {
                        total = total + userPortfolio.get(i);
                    }
                    lblPortfolioBalance.setText(String.valueOf(total));
                    if (totalReturn >= 0) {
                        lblTotalReturn.setText(String.valueOf(totalReturn));
                        lblTotalReturn.setStyle("-fx-text-fill: green;");
                    } else {
                        lblTotalReturn.setText(String.valueOf(totalReturn));
                        lblTotalReturn.setStyle("-fx-text-fill: red;");
                    }
                    graphTotalPortfolio();
                    total = 0;
                    allStocksOwn = 0;
                    totalReturn = 0;





                    //            allStocksAvailable.add(GE);
                    //        allStocksAvailable.add(PLUG);
                    //        allStocksAvailable.add(DIS);
                    //        allStocksAvailable.add(SQ);
                    //        allStocksAvailable.add(JNJ);
                    //        allStocksAvailable.add(NKLA);
                    //        allStocksAvailable.add(QS);
                    //        allStocksAvailable.add(AAPL);
                    //        allStocksAvailable.add(TSLA);
                    //        allStocksAvailable.add(NFLX);
                    //        allStocksAvailable.add(FB);
                    //        allStocksAvailable.add(TWTR);
                    //        allStocksAvailable.add(MFST);
                    //        allStocksAvailable.add(BABA);

                }

            }

        }.start();


    }


//        Timer t = new Timer();
//        t.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Stocks stocks = new Stocks();
//                stocks.changePrice();
//                AMZN+=stocks.getPriceChange();
//                System.out.println(AMZN);
//                lstAMZN.add(AMZN);
//
//
//            }
//        }, 0, 1000);


    private void handleChangePrice() {
        Stocks stocks = new Stocks();
//        stocks.changePrice();
        AMZN += stocks.changePrice(AMZN);
        F+=stocks.changePrice(F);
        GM += stocks.changePrice(GM);
        GE += stocks.changePrice(GE);
        PLUG += stocks.changePrice(PLUG);
        DIS += stocks.changePrice(DIS);
        SQ += stocks.changePrice(SQ);
        JNJ += stocks.changePrice(JNJ);
        NKLA += stocks.changePrice(NKLA);
        QS += stocks.changePrice(QS);
        AAPL += stocks.changePrice(AAPL);
        TSLA += stocks.changePrice(TSLA);
        FB += stocks.changePrice(FB);
        TWTR += stocks.changePrice(TWTR);
        MFST += stocks.changePrice(MFST);
        BABA += stocks.changePrice(BABA);
    }

    private void handleAddValueToList() {
        Stocks stocks = new Stocks();
        stocks.changePrice(stockPlaceHolder);
        lstAMZN.add(AMZN);
        lstGM.add(GM);
        lstF.add(F);
        lstGE.add(GE);
        lstDIS.add(DIS);
        lstPLUG.add(PLUG);
        lstSQ.add(SQ);
        lstJNJ.add(JNJ);
        lstNKLA.add(NKLA);
        lstQS.add(QS);
        lstAAPL.add(AAPL);
        lstTSLA.add(TSLA);
        lstFB.add(FB);
        lstTWTR.add(TWTR);
        lstMFST.add(MFST);
        lstBABA.add(BABA);
        userPortfolio.add(total);

    }

    @FXML
    public void graphStockData() {

        graphAMZN.getData().clear();
        graphGM.getData().clear();
        graphF.getData().clear();
        graphGE.getData().clear();
        graphPLUG.getData().clear();
        graphDIS.getData().clear();
        graphSQ.getData().clear();
        graphJNJ.getData().clear();
        graphNKLA.getData().clear();
        graphQS.getData().clear();
        graphAAPL.getData().clear();
        graphTSLA.getData().clear();
        graphFB.getData().clear();
        graphTWTR.getData().clear();
        graphMFST.getData().clear();
        graphBABA.getData().clear();


        seriesAMZN.getData().add(new XYChart.Data(counter, lstAMZN.get(counter)));
        seriesGM.getData().add(new XYChart.Data(counter, lstGM.get(counter)));
        seriesF.getData().add(new XYChart.Data(counter, lstF.get(counter)));
        seriesGE.getData().add(new XYChart.Data(counter, lstGE.get(counter)));
        seriesPLUG.getData().add(new XYChart.Data(counter, lstPLUG.get(counter)));
        seriesDIS.getData().add(new XYChart.Data(counter, lstDIS.get(counter)));
        seriesSQ.getData().add(new XYChart.Data(counter, lstSQ.get(counter)));
        seriesJNJ.getData().add(new XYChart.Data(counter, lstJNJ.get(counter)));
        seriesNKLA.getData().add(new XYChart.Data(counter, lstNKLA.get(counter)));
        seriesQS.getData().add(new XYChart.Data(counter, lstQS.get(counter)));
        seriesAAPL.getData().add(new XYChart.Data(counter, lstAAPL.get(counter)));
        seriesTSLA.getData().add(new XYChart.Data(counter, lstTSLA.get(counter)));
        seriesFB.getData().add(new XYChart.Data(counter, lstFB.get(counter)));
        seriesTWTR.getData().add(new XYChart.Data(counter, lstTWTR.get(counter)));
        seriesMFST.getData().add(new XYChart.Data(counter, lstMFST.get(counter)));
        seriesBABA.getData().add(new XYChart.Data(counter, lstBABA.get(counter)));



        counter++;


        graphAMZN.getData().add(seriesAMZN);
        graphGM.getData().add(seriesGM);
        graphF.getData().add(seriesF);
        graphGE.getData().add(seriesGE);
        graphPLUG.getData().add(seriesPLUG);
        graphDIS.getData().add(seriesDIS);
        graphSQ.getData().add(seriesSQ);
        graphJNJ.getData().add(seriesJNJ);
        graphNKLA.getData().add(seriesNKLA);
        graphQS.getData().add(seriesQS);
        graphAAPL.getData().add(seriesAAPL);
        graphTSLA.getData().add(seriesTSLA);
        graphFB.getData().add(seriesFB);
        graphTWTR.getData().add(seriesTWTR);
        graphMFST.getData().add(seriesMFST);
        graphBABA.getData().add(seriesBABA);

    }
//    @FXML
//    private void handlePieChart() {
//        ObservableList<PieChart.Data> pieChartData =
//                FXCollections.observableArrayList(
//                        new PieChart.Data("Buy", 3),
//                        new PieChart.Data("Hold", 3),
//                        new PieChart.Data("Sell", 3));
//
//        pieRating.setTitle("Monthly Record");
//        pieRating.setData(pieChartData);
//    }

    @FXML
    public void graphTotalPortfolio() {

        graphTotalPortfolio.getData().clear();

        seriesTotal.getData().add(new XYChart.Data(counterTotal, total));

        counterTotal++;

        graphTotalPortfolio.getData().add(seriesTotal);

    }

//            @FXML
//            private void handleBuyF() {
//
//                if (userBuyingPower >= F) {
//                    userPortfolioBalance += F;
//                    userBuyingPower -= F;
//                    lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
//                    lblBuyingPower.setText(String.valueOf(userBuyingPower));
//                    numF++;
//                    userPortfolio.add(F*numF);
//                    hasFord = true;
//                } else if (userBuyingPower < F) {
//                    notEnoughMoney();
//                }
//            }

//            @FXML
//            private void handleBuyAMZN() {
//                if (userBuyingPower >= AMZN) {
//                    userPortfolioBalance += AMZN;
//                    userBuyingPower -= AMZN;
//                    lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
//                    lblBuyingPower.setText(String.valueOf(userBuyingPower));
//                    numAMZN++;
//                    userPortfolio.add(AMZN*numAMZN);
//                    hasAMZN = true;
//                } else if (userBuyingPower < AMZN) {
//                    notEnoughMoney();
//                }
//
//            }

    @FXML
    private void handleBuyStock() {
        numSharesToBuy = Integer.parseInt(txtNumBuy.getText());
        if (tabAMZN.isSelected()) {
            if (userBuyingPower >= AMZN * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(AMZN * numSharesToBuy, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(AMZN * numSharesToBuy, userBuyingPower, false);
                numAMZN = p.changeNumShares(AMZN, numAMZN, numSharesToBuy, true);
                hasAMZN = true;
                userPortfolio.add(AMZN * numAMZN);
                buyPriceAMZN = AMZN;
            } else if (userBuyingPower < AMZN) {
                notEnoughMoney();
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        }

        if (tabF.isSelected()) {
            if (userBuyingPower >= F * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(F * numSharesToBuy, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(F * numSharesToBuy, userBuyingPower, false);
                numF = p.changeNumShares(F, numF, numSharesToBuy, true);
                hasFord = true;
                userPortfolio.add(F * numF);
                buyPriceF = F;
            } else if (userBuyingPower < F) {
                notEnoughMoney();
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        }

        if (tabGM.isSelected()) {
            if (userBuyingPower >= GM * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(GM, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(GM * numSharesToBuy, userBuyingPower, false);
                numGM = p.changeNumShares(GM, numGM, numSharesToBuy, true);
                hasGM = true;
                userPortfolio.add(GM * numGM);
                buyPriceGM = GM;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < GM) {
            notEnoughMoney();
        }

        if (tabGE.isSelected()) {
            if (userBuyingPower >= GE * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(GE, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(GE * numSharesToBuy, userBuyingPower, false);
                numGE = p.changeNumShares(GE, numGE, numSharesToBuy, true);
                hasGE = true;
                userPortfolio.add(GE * numGE);
                buyPriceGE= GE;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < GE) {
            notEnoughMoney();
        }

        if (tabPLUG.isSelected()) {
            if (userBuyingPower >= PLUG * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(PLUG, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(PLUG * numSharesToBuy, userBuyingPower, false);
                numPLUG = p.changeNumShares(PLUG, numPLUG, numSharesToBuy, true);
                hasPLUG = true;
                userPortfolio.add(PLUG * numPLUG);
                buyPricePLUG = PLUG;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < PLUG) {
            notEnoughMoney();
        }

        if (tabDIS.isSelected()) {
            if (userBuyingPower >= DIS * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(DIS, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(DIS * numSharesToBuy, userBuyingPower, false);
                numDIS = p.changeNumShares(DIS, numDIS, numSharesToBuy, true);
                hasDIS= true;
                userPortfolio.add(DIS * numDIS);
                buyPriceDIS = DIS;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < DIS) {
            notEnoughMoney();
        }

        if (tabSQ.isSelected()) {
            if (userBuyingPower >= SQ * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(SQ, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(SQ * numSharesToBuy, userBuyingPower, false);
                numSQ = p.changeNumShares(SQ, numSQ, numSharesToBuy, true);
                hasSQ = true;
                userPortfolio.add(SQ * numSQ);
                buyPriceSQ = SQ;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < SQ) {
            notEnoughMoney();
        }

        if (tabJNJ.isSelected()) {
            if (userBuyingPower >= JNJ * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(JNJ, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(JNJ* numSharesToBuy, userBuyingPower, false);
                numJNJ = p.changeNumShares(JNJ, numJNJ, numSharesToBuy, true);
                hasJNJ = true;
                userPortfolio.add(JNJ * numJNJ);
                buyPriceJNJ = JNJ;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < JNJ) {
            notEnoughMoney();
        }

        if (tabNKLA.isSelected()) {
            if (userBuyingPower >= NKLA * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(NKLA, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(NKLA * numSharesToBuy, userBuyingPower, false);
                numNKLA = p.changeNumShares(NKLA, numNKLA, numSharesToBuy, true);
                hasNKLA = true;
                userPortfolio.add(NKLA* numNKLA);
                buyPriceNKLA = NKLA;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < NKLA) {
            notEnoughMoney();
        }

        if (tabQS.isSelected()) {
            if (userBuyingPower >= QS * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(QS, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(QS * numSharesToBuy, userBuyingPower, false);
                numQS = p.changeNumShares(QS, numQS, numSharesToBuy, true);
                hasQS = true;
                userPortfolio.add(QS * numQS);
                buyPriceQS = QS;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < QS) {
            notEnoughMoney();
        }

        if (tabAAPL.isSelected()) {
            if (userBuyingPower >= AAPL * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(AAPL, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(AAPL * numSharesToBuy, userBuyingPower, false);
                numAAPL = p.changeNumShares(AAPL, numAAPL, numSharesToBuy, true);
                hasAAPL = true;
                userPortfolio.add(AAPL * numAAPL);
                buyPriceAAPL = AAPL;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < AAPL) {
            notEnoughMoney();
        }

        if (tabTSLA.isSelected()) {
            if (userBuyingPower >= TSLA * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(TSLA, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(TSLA * numSharesToBuy, userBuyingPower, false);
                numTSLA = p.changeNumShares(TSLA, numTSLA, numSharesToBuy, true);
                hasTSLA = true;
                userPortfolio.add(TSLA * numTSLA);
                buyPriceTSLA = TSLA;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < TSLA) {
            notEnoughMoney();
        }

        if (tabFB.isSelected()) {
            if (userBuyingPower >= FB * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(FB, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(FB * numSharesToBuy, userBuyingPower, false);
                numFB = p.changeNumShares(FB, numFB, numSharesToBuy, true);
                hasFB = true;
                userPortfolio.add(FB * numFB);
                buyPriceFB= FB;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < FB) {
            notEnoughMoney();
        }

        if (tabTWTR.isSelected()) {
            if (userBuyingPower >= TWTR * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(TWTR, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(TWTR * numSharesToBuy, userBuyingPower, false);
                numTWTR = p.changeNumShares(TWTR, numTWTR, numSharesToBuy, true);
                hasTWTR = true;
                userPortfolio.add(TWTR * numTWTR);
                buyPriceTWTR= TWTR;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < TWTR) {
            notEnoughMoney();
        }

        if (tabMFST.isSelected()) {
            if (userBuyingPower >= MFST * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(MFST, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(MFST * numSharesToBuy, userBuyingPower, false);
                numMFST = p.changeNumShares(MFST, numMFST, numSharesToBuy, true);
                hasMFST = true;
                userPortfolio.add(MFST * numMFST);
                buyPriceMFST= MFST;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < MFST) {
            notEnoughMoney();
        }

        if (tabBABA.isSelected()) {
            if (userBuyingPower >= BABA * numSharesToBuy) {
                Portfolio p = new Portfolio();
                userPortfolioBalance = p.changePortBalance(BABA, userPortfolioBalance, true);
                userBuyingPower = p.changeBuyingPower(BABA * numSharesToBuy, userBuyingPower, false);
                numBABA = p.changeNumShares(BABA, numBABA, numSharesToBuy, true);
                hasBABA = true;
                userPortfolio.add(BABA * numBABA);
                buyPriceBABA= BABA;
            }
            lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
            lblBuyingPower.setText(String.valueOf(userBuyingPower));
        } else if (userBuyingPower < BABA) {
            notEnoughMoney();
        }


    }


    //            @FXML
//            private void handleBuyGM() {
//                if (userBuyingPower >= GM) {
//                    userPortfolioBalance += GM;
//                    userBuyingPower -= GM;
//                    lblPortfolioBalance.setText(String.valueOf(userPortfolioBalance));
//                    lblBuyingPower.setText(String.valueOf(userBuyingPower));
//                    numGM++;
//                    userPortfolio.add(GM*numGM);
//                    hasGM = true;
//                } else if (userBuyingPower < GM) {
//                    notEnoughMoney();
//                }
//            }
    @FXML
    public void handleSellStock() {
        numSharesToSell = Integer.parseInt(txtNumSell.getText());
        Portfolio p = new Portfolio();
        if (tabF.isSelected() && numF >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(F * numSharesToSell, userBuyingPower, true);
            numF = p.changeNumShares(F, numF, numSharesToSell, false);
            if (numF < 1) {
                hasFord = false;
                buyPriceF = 0;
            }
        }

        if (tabGM.isSelected() && numGM >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(GM * numSharesToSell, userBuyingPower, true);
            numGM = p.changeNumShares(GM, numGM, numSharesToSell, false);
            if (numGM < 1) {
                hasGM = false;
                buyPriceGM = 0;
            }
        }

        if (tabAMZN.isSelected() && numAMZN >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(AMZN * numSharesToSell, userBuyingPower, true);
            numAMZN = p.changeNumShares(AMZN, numAMZN, numSharesToSell, false);
            if (numAMZN < 1) {
                hasAMZN = false;
                buyPriceAMZN = 0;
            }
        }

        if (tabGE.isSelected() && numGE >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(GE * numSharesToSell, userBuyingPower, true);
            numGE = p.changeNumShares(GE, numGE, numSharesToSell, false);
            if (numGE < 1) {
                hasGE = false;
                buyPriceGE = 0;
            }
        }

        if (tabPLUG.isSelected() && numPLUG >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(PLUG * numSharesToSell, userBuyingPower, true);
            numPLUG = p.changeNumShares(PLUG, numPLUG, numSharesToSell, false);
            if (numPLUG < 1) {
                hasPLUG = false;
                buyPricePLUG = 0;
            }
        }

        if (tabDIS.isSelected() && numDIS >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(DIS * numSharesToSell, userBuyingPower, true);
            numDIS = p.changeNumShares(DIS, numDIS, numSharesToSell, false);
            if (numDIS < 1) {
                hasDIS = false;
                buyPriceDIS = 0;
            }
        }

        if (tabSQ.isSelected() && numSQ >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(SQ * numSharesToSell, userBuyingPower, true);
            numSQ = p.changeNumShares(SQ, numSQ, numSharesToSell, false);
            if (numSQ < 1) {
                hasSQ = false;
                buyPriceSQ = 0;
            }
        }

        if (tabJNJ.isSelected() && numJNJ >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(JNJ * numSharesToSell, userBuyingPower, true);
            numJNJ = p.changeNumShares(JNJ, numJNJ, numSharesToSell, false);
            if (numJNJ< 1) {
                hasJNJ = false;
                buyPriceJNJ = 0;
            }
        }

        if (tabNKLA.isSelected() && numNKLA >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(NKLA * numSharesToSell, userBuyingPower, true);
            numNKLA = p.changeNumShares(NKLA, numNKLA, numSharesToSell, false);
            if (numNKLA < 1) {
                hasNKLA = false;
                buyPriceNKLA = 0;
            }
        }

        if (tabQS.isSelected() && numQS >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(QS * numSharesToSell, userBuyingPower, true);
            numQS = p.changeNumShares(QS, numQS, numSharesToSell, false);
            if (numQS < 1) {
                hasQS = false;
                buyPriceQS = 0;
            }
        }

        if (tabAAPL.isSelected() && numAAPL>= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(AAPL * numSharesToSell, userBuyingPower, true);
            numAAPL = p.changeNumShares(AAPL, numAAPL, numSharesToSell, false);
            if (numAAPL < 1) {
                hasAAPL = false;
                buyPriceAAPL = 0;
            }
        }

        if (tabTSLA.isSelected() && numTSLA>= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(TSLA * numSharesToSell, userBuyingPower, true);
            numTSLA = p.changeNumShares(TSLA, numTSLA, numSharesToSell, false);
            if (numTSLA < 1) {
                hasTSLA = false;
                buyPriceTSLA = 0;
            }
        }

        if (tabFB.isSelected() && numFB >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(FB * numSharesToSell, userBuyingPower, true);
            numFB = p.changeNumShares(FB, numFB, numSharesToSell, false);
            if (numFB < 1) {
                hasFB = false;
                buyPriceFB = 0;
            }
        }

        if (tabTWTR.isSelected() && numTWTR >= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(TWTR * numSharesToSell, userBuyingPower, true);
            numTWTR = p.changeNumShares(TWTR, numTWTR, numSharesToSell, false);
            if (numTWTR< 1) {
                hasTWTR = false;
                buyPriceTWTR = 0;
            }
        }

        if (tabMFST.isSelected() && numMFST>= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(MFST * numSharesToSell, userBuyingPower, true);
            numMFST = p.changeNumShares(MFST, numMFST, numSharesToSell, false);
            if (numMFST < 1) {
                hasMFST = false;
                buyPriceMFST = 0;
            }
        }

        if (tabBABA.isSelected() && numBABA>= numSharesToSell) {
            userBuyingPower = p.changeBuyingPower(BABA * numSharesToSell, userBuyingPower, true);
            numBABA = p.changeNumShares(BABA, numBABA, numSharesToSell, false);
            if (numBABA < 1) {
                hasBABA = false;
                buyPriceBABA = 0;
            }
        }
    }

    @FXML
    private void handleShowStockDetails() {
        if (tabAMZN.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(AMZN));
            lblStockName.setText("Amazon");
        }
        if (tabF.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(F));
            lblStockName.setText("Ford");
        }
        if (tabGM.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(GM));
            lblStockName.setText("GM");
        }
        if (tabGE.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(GE));
            lblStockName.setText("GE");
        }
        if (tabPLUG.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(PLUG));
            lblStockName.setText("PLUG");
        }
        if (tabDIS.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(DIS));
            lblStockName.setText("DIS");
        }
        if (tabSQ.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(SQ));
            lblStockName.setText("SQ");
        }
        if (tabJNJ.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(JNJ));
            lblStockName.setText("JNJ");
        }
        if (tabNKLA.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(NKLA));
            lblStockName.setText("NKLA");
        }
        if (tabQS.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(QS));
            lblStockName.setText("QS");
        }
        if (tabAAPL.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(AAPL));
            lblStockName.setText("AAPL");
        }
        if (tabTSLA.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(TSLA));
            lblStockName.setText("TSLA");
        }
        if (tabFB.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(FB));
            lblStockName.setText("FB");
        }
        if (tabTWTR.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(TWTR));
            lblStockName.setText("TWTR");
        }
        if (tabMFST.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(MFST));
            lblStockName.setText("MFST");
        }
        if (tabBABA.isSelected()) {
            lblStockCurrentValue.setText(String.valueOf(BABA));
            lblStockName.setText("BABA");
        }
    }

    @FXML
    private void notEnoughMoney() {
        System.out.println("You do not have enough money to buy this stock.");
    }


    @FXML
    private void handleNewEarnings() {
        new AnimationTimer() {
            @Override
            public void handle(long timeCurrent2) {

                if (timeCurrent2 - graphTimer2 > 30000000000.0) {
                    graphTimer2=System.nanoTime();

                    if(fEarnings && gmEarnings && amznEarnings){
                        fEarnings=false;
                        gmEarnings=false;
                        geEarnings=false;
                        plugEarnings=false;
                        disEarnings=false;
                        sqEarnings=false;
                        jnjEarnings=false;
                        nklaEarnings=false;
                        qsEarnings=false;
                        aaplEarnings=false;
                        tslaEarnings=false;
                        fbEarnings=false;
                        twtrEarnings=false;
                        mfstEarnings=false;
                        babaEarnings=false;
                        quarter++;
                    }
                    if(quarter>4){
                        quarter=1;
                    }
                    stocksNeedingEarnings.clear();
                    if(!fEarnings){
                        stocksNeedingEarnings.add(F);
                    }
                    if(!gmEarnings){
                        stocksNeedingEarnings.add(GM);
                    }
                    if(!amznEarnings){
                        stocksNeedingEarnings.add(AMZN);
                    }
                    if(!geEarnings){
                        stocksNeedingEarnings.add(GE);
                    }
                    if(!plugEarnings){
                        stocksNeedingEarnings.add(PLUG);
                    }
                    if(!disEarnings){
                        stocksNeedingEarnings.add(DIS);
                    }
                    if(!sqEarnings){
                        stocksNeedingEarnings.add(SQ);
                    }
                    if(!jnjEarnings){
                        stocksNeedingEarnings.add(JNJ);
                    }
                    if(!nklaEarnings){
                        stocksNeedingEarnings.add(NKLA);
                    }
                    if(!qsEarnings){
                        stocksNeedingEarnings.add(QS);
                    }
                    if(!aaplEarnings){
                        stocksNeedingEarnings.add(AAPL);
                    }
                    if(!tslaEarnings){
                        stocksNeedingEarnings.add(TSLA);
                    }
                    if(!fbEarnings){
                        stocksNeedingEarnings.add(FB);
                    }
                    if(!twtrEarnings){
                        stocksNeedingEarnings.add(TWTR);
                    }
                    if(!mfstEarnings){
                        stocksNeedingEarnings.add(MFST);
                    }
                    if(!babaEarnings){
                        stocksNeedingEarnings.add(BABA);
                    }

                    int stock = (int) (Math.random() * stocksNeedingEarnings.size());
                    double stockChange = stocksNeedingEarnings.get(stock);
                    News n = new News();
                    Stocks s = new Stocks();
                    String earnings = n.earningsReport();
                    if (stockChange > F-1&& stockChange<F+1&&!fEarnings) {
                        F = s.changePriceEarnings(F, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "Ford", quarter));
                        fEarnings=true;
                    }
                    if (stockChange >AMZN-1&&stockChange<AMZN+1&&!amznEarnings) {
                        AMZN = s.changePriceEarnings(AMZN, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "AMZN", quarter));
                        amznEarnings=true;
                    }
                    if (stockChange >GM-1&&stockChange<GM+1&& !gmEarnings) {
                        GM = s.changePriceEarnings(GM, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "GM", quarter));
                        gmEarnings=true;
                    }
                    if (stockChange >GE-1&&stockChange<GE+1&& !geEarnings) {
                        GE = s.changePriceEarnings(GM, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "GE", quarter));
                        geEarnings=true;
                    }
                    if (stockChange >PLUG-1&&stockChange<PLUG+1&& !plugEarnings) {
                        PLUG = s.changePriceEarnings(PLUG, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "PLUG", quarter));
                        plugEarnings=true;
                    }
                    if (stockChange >DIS-1&&stockChange<DIS+1&& !disEarnings) {
                        DIS = s.changePriceEarnings(DIS, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "DIS", quarter));
                        disEarnings=true;
                    }
                    if (stockChange >SQ-1&&stockChange<SQ+1&& !sqEarnings) {
                        SQ = s.changePriceEarnings(SQ, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "SQ", quarter));
                        sqEarnings=true;
                    }
                    if (stockChange >JNJ-1&&stockChange<JNJ+1&& !jnjEarnings) {
                        JNJ = s.changePriceEarnings(JNJ, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "JNJ", quarter));
                        jnjEarnings=true;
                    }
                    if (stockChange >NKLA-1&&stockChange<NKLA+1&& !nklaEarnings) {
                        NKLA = s.changePriceEarnings(NKLA, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "NKLA", quarter));
                        nklaEarnings=true;
                    }
                    if (stockChange >QS-1&&stockChange<QS+1&& !qsEarnings) {
                        QS = s.changePriceEarnings(QS, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "QS", quarter));
                        qsEarnings=true;
                    }
                    if (stockChange >AAPL-1&&stockChange<AAPL+1&& !aaplEarnings) {
                        AAPL = s.changePriceEarnings(AAPL, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "AAPL", quarter));
                        aaplEarnings=true;
                    }
                    if (stockChange >TSLA-1&&stockChange<TSLA+1&& !tslaEarnings) {
                        TSLA = s.changePriceEarnings(TSLA, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "TSLA", quarter));
                        tslaEarnings=true;
                    }
                    if (stockChange >FB-1&&stockChange<FB+1&& !fbEarnings) {
                        FB = s.changePriceEarnings(FB, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "FB", quarter));
                        fbEarnings=true;
                    }
                    if (stockChange >TWTR-1&&stockChange<TWTR+1&& !twtrEarnings) {
                        TWTR = s.changePriceEarnings(TWTR, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "TWTR", quarter));
                        twtrEarnings=true;
                    }
                    if (stockChange >MFST-1&&stockChange<MFST+1&& !mfstEarnings) {
                        MFST = s.changePriceEarnings(MFST, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "MFST", quarter));
                        mfstEarnings=true;
                    }
                    if (stockChange >BABA-1&&stockChange<BABA+1&& !babaEarnings) {
                        BABA = s.changePriceEarnings(BABA, earnings);
                        lstEarningsNews.getItems().add(n.earningsReportWording(earnings, "BABA", quarter));
                        babaEarnings=true;
                    }

                }

            }

        }.start();


    }

    @FXML
    private void handleReport() {
        new AnimationTimer() {
            @Override
            public void handle(long timeCurrent3) {

                if (timeCurrent3 - graphTimer3> 20000000000.0) {
                    graphTimer3=System.nanoTime();

                    if(fEarnings && gmEarnings && amznEarnings){
                        fEarnings=false;
                        gmEarnings=false;
                        geEarnings=false;
                        plugEarnings=false;
                        disEarnings=false;
                        sqEarnings=false;
                        jnjEarnings=false;
                        nklaEarnings=false;
                        qsEarnings=false;
                        aaplEarnings=false;
                        tslaEarnings=false;
                        fbEarnings=false;
                        twtrEarnings=false;
                        mfstEarnings=false;
                        babaEarnings=false;
                        quarter++;
                    }
                    stocksNeedingEarnings.clear();
                    if(!fEarnings){
                        stocksNeedingEarnings.add(F);
                    }
                    if(!gmEarnings){
                        stocksNeedingEarnings.add(GM);
                    }
                    if(!amznEarnings){
                        stocksNeedingEarnings.add(AMZN);
                    }
                    if(!geEarnings){
                        stocksNeedingEarnings.add(GE);
                    }
                    if(!plugEarnings){
                        stocksNeedingEarnings.add(PLUG);
                    }
                    if(!disEarnings){
                        stocksNeedingEarnings.add(DIS);
                    }
                    if(!sqEarnings){
                        stocksNeedingEarnings.add(SQ);
                    }
                    if(!jnjEarnings){
                        stocksNeedingEarnings.add(JNJ);
                    }
                    if(!nklaEarnings){
                        stocksNeedingEarnings.add(NKLA);
                    }
                    if(!qsEarnings){
                        stocksNeedingEarnings.add(QS);
                    }
                    if(!aaplEarnings){
                        stocksNeedingEarnings.add(AAPL);
                    }
                    if(!tslaEarnings){
                        stocksNeedingEarnings.add(TSLA);
                    }
                    if(!fbEarnings){
                        stocksNeedingEarnings.add(FB);
                    }
                    if(!twtrEarnings){
                        stocksNeedingEarnings.add(TWTR);
                    }
                    if(!mfstEarnings){
                        stocksNeedingEarnings.add(MFST);
                    }
                    if(!babaEarnings){
                        stocksNeedingEarnings.add(BABA);
                    }

                    int stock = (int) (Math.random() * stocksNeedingEarnings.size());
                    Double stockNews = stocksNeedingEarnings.get(stock);
                    News n = new News();
                    Stocks s = new Stocks();
                    String report = n.newsReport();
                    double posOrNeg = Math.random();
                    boolean isPos;

                    if (stockNews >F-1&&stockNews<F+1&& !fEarnings) {
                        F = s.changePriceReport(F, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "Ford"));
                        fEarnings=true;
                    }
                    if (stockNews >AMZN-1&&stockNews<AMZN+1&& !amznEarnings) {
                        AMZN = s.changePriceReport(AMZN, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "AMZN"));
                        amznEarnings=true;
                    }
                    if (stockNews >GM-1&&stockNews<GM+1&& !gmEarnings) {
                        GM = s.changePriceReport(GM, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "GM"));
                        gmEarnings=true;
                    }
                    if (stockNews >GE-1&&stockNews<GE+1&& !geEarnings) {
                        GE = s.changePriceReport(GM, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "GE"));
                        geEarnings=true;
                    }
                    if (stockNews >PLUG-1&&stockNews<PLUG+1&& !plugEarnings) {
                        PLUG = s.changePriceReport(PLUG, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "PLUG"));
                        plugEarnings=true;
                    }
                    if (stockNews >DIS-1&&stockNews<DIS+1&& !disEarnings) {
                        DIS = s.changePriceReport(DIS, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "DIS"));
                        disEarnings=true;
                    }
                    if (stockNews >SQ-1&&stockNews<SQ+1&& !disEarnings) {
                        SQ = s.changePriceReport(SQ, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "SQ"));
                        sqEarnings=true;
                    }
                    if (stockNews >JNJ-1&&stockNews<JNJ+1&& !jnjEarnings) {
                        JNJ = s.changePriceReport(JNJ, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "JNJ"));
                        jnjEarnings=true;
                    }
                    if (stockNews >NKLA-1&&stockNews<NKLA+1&& !nklaEarnings) {
                        NKLA = s.changePriceReport(NKLA, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "NKLA"));
                        nklaEarnings=true;
                    }
                    if (stockNews >QS-1&&stockNews<QS+1&& !sqEarnings) {
                        QS = s.changePriceReport(QS, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "QS"));
                        qsEarnings=true;
                    }
                    if (stockNews >AAPL-1&&stockNews<AAPL+1&& !aaplEarnings) {
                        AAPL = s.changePriceReport(AAPL, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "AAPL"));
                        aaplEarnings=true;
                    }
                    if (stockNews >TSLA-1&&stockNews<TSLA+1&& !tslaEarnings) {
                        TSLA = s.changePriceReport(TSLA, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "TSLA"));
                        tslaEarnings=true;
                    }
                    if (stockNews >FB-1&&stockNews<FB+1&& !fbEarnings) {
                        FB = s.changePriceReport(FB, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "FB"));
                        fbEarnings=true;
                    }
                    if (stockNews >TWTR-1&&stockNews<TWTR+1&& !twtrEarnings) {
                        TWTR = s.changePriceReport(TWTR, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "TWTR"));
                        twtrEarnings=true;
                    }
                    if (stockNews >MFST-1&&stockNews<MFST+1&& !mfstEarnings) {
                        MFST = s.changePriceReport(MFST, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "MFST"));
                        mfstEarnings=true;
                    }
                    if (stockNews >BABA-1&&stockNews<BABA+1&& !babaEarnings) {
                        BABA = s.changePriceReport(BABA, report);
                        lstNewsReports.getItems().add(n.newsReportWording(report, "BABA"));
                        babaEarnings=true;
                    }

                }

            }

        }.start();


    }

    @FXML
    private void lightTheme(){

    }

    @FXML
    private void handleLimitOrder(){

        if (tabF.isSelected()) {
            numSharesToSellLimitF = Integer.parseInt(txtLimitNumShares.getText());
            limitF=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabGM.isSelected()) {
            numSharesToSellLimitGM = Integer.parseInt(txtLimitNumShares.getText());
            limitGM=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabAMZN.isSelected()) {
            numSharesToSellLimitAMZN = Integer.parseInt(txtLimitNumShares.getText());
            limitAMZN=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabGE.isSelected()) {
            numSharesToSellLimitGE = Integer.parseInt(txtLimitNumShares.getText());
            limitGE=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabPLUG.isSelected()) {
            numSharesToSellLimitPLUG = Integer.parseInt(txtLimitNumShares.getText());
            limitPLUG=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabDIS.isSelected()) {
            numSharesToSellLimitDIS = Integer.parseInt(txtLimitNumShares.getText());
            limitDIS=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabSQ.isSelected()) {
            numSharesToSellLimitSQ = Integer.parseInt(txtLimitNumShares.getText());
            limitSQ=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabJNJ.isSelected()) {
            numSharesToSellLimitJNJ = Integer.parseInt(txtLimitNumShares.getText());
            limitJNJ=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabNKLA.isSelected()) {
            numSharesToSellLimitNKLA = Integer.parseInt(txtLimitNumShares.getText());
            limitNKLA=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabQS.isSelected()) {
            numSharesToSellLimitQS = Integer.parseInt(txtLimitNumShares.getText());
            limitQS=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabAAPL.isSelected()) {
            numSharesToSellLimitAAPL = Integer.parseInt(txtLimitNumShares.getText());
            limitAAPL=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabTSLA.isSelected()) {
            numSharesToSellLimitTSLA = Integer.parseInt(txtLimitNumShares.getText());
            limitTSLA=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabFB.isSelected()) {
            numSharesToSellLimitFB = Integer.parseInt(txtLimitNumShares.getText());
            limitFB=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabTWTR.isSelected()) {
            numSharesToSellLimitTWTR = Integer.parseInt(txtLimitNumShares.getText());
            limitTWTR=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabMFST.isSelected()) {
            numSharesToSellLimitMFST = Integer.parseInt(txtLimitNumShares.getText());
            limitMFST=Integer.parseInt(txtLimitSellPrice.getText());
        }

        if (tabBABA.isSelected() && numBABA>= numSharesToSell) {
            numSharesToSellLimitBABA = Integer.parseInt(txtLimitNumShares.getText());
            limitBABA=Integer.parseInt(txtLimitSellPrice.getText());
        }
    }


};







