
package block3projectP1.print;

import block3projectP1.business.TimeLineSearch;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 * @author Krypton
 */

public class ShowChart {
    
    //An observablelist that contains the piechart data
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableList(new ArrayList<PieChart.Data>());
    
    //Create a new instance of the TimeLineSearch class to get data
    TimeLineSearch timeLine = new TimeLineSearch();
    
    //A constructor that creates a new piechart everytime it's been initialized
    public PieChart getPieChart(String keyWord) {
        
        //Clears the observablelist to avoid overlapping from previous data
        pieChartData.clear();
        
        //A map to store all word and amount of times they've appeared
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        
        //Passes on the searched key word to the twitter time line search
        timeLine.timeLineSearch(keyWord);
        
        //After the time line searched has finished his task
        //I retrieve the ten top words and store it in the HashMap list
        list = timeLine.getList();
        
        //A for-loop to add every single word with their value on to the pieChartData
        for(String key : list.keySet()) {
            pieChartData.add(new PieChart.Data(key + " (" + list.get(key) + ")", list.get(key)));
        }
        
        //Create a new chart with the new made piechart data
        PieChart chart = new PieChart(pieChartData);
        
        //Set the chart title as the searched key word
        chart.setTitle("Searched key word: " + keyWord);
        
        //Set the length between the name label and the piechart
        chart.setLabelLineLength(10);
        
        //Set the bar of names to the left side
        chart.setLegendSide(Side.LEFT);
        
        //Clear the HashMap list when the operation is finished
        list.clear();
        
        //Returns the new made chart, to the caller
        return chart;
    }   
}
