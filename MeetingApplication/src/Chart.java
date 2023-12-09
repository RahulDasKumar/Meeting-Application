import java.util.HashMap;
import java.util.Random;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 

public class Chart extends Application {
	 HashMap<String,Integer> map = new HashMap<>();
    private Random rand = new Random();
    private String[] hours = Company.companyTimes;
    
    public Chart(String[] times) {
    	
    }
    
    @Override
	public void start(Stage stage) {
        stage.setTitle("Line Chart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Hours");       
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Available Hours");
                                
        XYChart.Series Userseries = new XYChart.Series();
        XYChart.Series Defaultseries = new XYChart.Series();

        Userseries.setName("Your Available Hours");
        Defaultseries.setName("Employees available hours");
            for(int i = 0; i<hours.length; i++) {
        	map.put(hours[i], rand.nextInt(10));
        }
        // input in users data
//        for(int i = 0; i<times.length; i++) {
//        	Defaultseries.getData().add(new XYChart.Data(times[i], 1));
//        }
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(Userseries,Defaultseries);
        stage.setScene(scene);
    }
	






 
}