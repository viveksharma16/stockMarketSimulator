package sample;

import java.awt.desktop.PreferencesEvent;
import java.util.ArrayList;

public class News{

    ArrayList<String> newsEarningsList = new ArrayList<>();
    ArrayList<String> newsReportList = new ArrayList<>();

    public String earningsReport() {
        newsEarningsList.add("failed");
        newsEarningsList.add("met");
        newsEarningsList.add("passed");
        int randNum = (int) ((Math.random())*newsEarningsList.size());
        return newsEarningsList.get(randNum);
    }

    public String earningsReportWording(String earnings, String company, Integer quarter){
        if(earnings.equals("failed")){
            return company +" fails to meet quarter " +quarter +" earnings expectations, hurting the stock value.";

        }
        else if(earnings.equals("met")){
            return company + " successfully meets quarter "+quarter +" expectations.";
        }
        else if(earnings.equals("passed")){
            return company + " beats quarter "+quarter+" earnings expectations, resulting in a skyrocketing stock value!";
        }
        return "";
    }

    public String newsReport(){
        newsReportList.add("optimistic");
        newsReportList.add("fearful");
        newsReportList.add("worst");
        newsReportList.add("best");
        newsReportList.add("strike");
        newsReportList.add("audit issue");
        newsReportList.add("expand");
        newsReportList.add("buy");
        newsReportList.add("increase");
        newsReportList.add("decrease");

        int randNum = (int)((Math.random())*newsReportList.size());

        return newsReportList.get(randNum);
    }

    public String newsReportWording(String report, String company){
        String wording="";
        if(report.equals("optimistic")){
            wording = company + " reports optimistic news about future of company and management, resulting in an increase for share values, by 10 percent.";
        }
        if(report.equals("fearful")){
            wording = company + " suggests fear of slowing business and sales in the future, causing a 30 percent dip in stock price.";
        }
        if(report.equals("worst")){
            wording= "Through a report, it has been revealed that " + company + " has one of the worst possible outlooks in the future, hurting share prices by 40 percent.";
        }
        if(report.equals("best")){
            wording="A recent report suggests that " + company + " has one of the best possible outlooks in the future, resulting in thriving share prices by 30 percent.";
        }
        if(report.equals("strike")){
            wording="Due to recent work conditions, many employees of " + company + " have gone on strike, hurting share values by 10 percent.";
        }
        if(report.equals("audit issue")){
            wording=company + " auditor resigns after a significant audit reporting fault, causing stock prices to dip by 25 percent.";
        }
        if(report.equals("expand")){
            wording=company+" plans to expand factories and offices in attempt to globalize, resulting in thriving share prices by 20 percent.";
        }
        if(report.equals("buy")){
            wording="Recent reports suggest that " + company + " is on the hunt to buy smaller corporations involved in a similar industry. Stock values for "+ company + " increase by a whopping 40 percent.";
        }
        if(report.equals("increase")){
            wording=company + " reports an increase of demand if product, plus an increase in promotional services, causing an increase of 25 percent on share value.";
        }
        if(report.equals("decrease")){
            wording="Report reveals that " + company + " lost a significant demand for its products recently, resulting in plummeting stock value by 25 percent.";
        }
        return wording;
    }
}
