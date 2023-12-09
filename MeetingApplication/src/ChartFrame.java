import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

// create the init() with the jswing and javafx scenes being created

public class ChartFrame extends JFrame{
	
	public ChartFrame(String[] timesAvailable){
		setTitle("Chart");
		initComponents(timesAvailable);
	}
	
	private void initComponents(String[] timesAvailable) {
		final JFXPanel fxPanel = new JFXPanel();
		fxPanel.setSize(1000, 1000);
		add(fxPanel);
		setSize(750, 750);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				initFX(fxPanel,timesAvailable);
			}           
	});

}
	// this method will add a scene to the fx panel
	 private static void initFX(JFXPanel fxPanel, String[] timesAvailable) {
	        // This method is invoked on the JavaFX thread
	        Scene scene = createScene(timesAvailable);
	        fxPanel.setScene(scene);
	    }
	 
	 private static Scene createScene(String[] times) {
		 	 HashMap<String,Integer> map = new HashMap<>();
		 	 // inputting all the hours the customers have selected
		 	 for(String time: times) {
		 		 map.put(time, 1);
		 	 }
		     Random rand = new Random();
		     String[] hours = Company.companyTimes;
		     // adding the data for other users in the company
		     for(String hour: hours) {
		    	 map.put(hour, rand.nextInt(10));
		     }
		     System.out.println(map);
		     Scene scene = new Scene(new Group());
		     ObservableList<PieChart.Data> pieChartData =
		                FXCollections.observableArrayList(
		                new PieChart.Data("9:00 am", map.get("9:00 am")),
		                new PieChart.Data("10:00 am", map.get("10:00 am")),
		                new PieChart.Data("11:00 am", map.get("11:00 am")),
		                new PieChart.Data("12:00 pm", map.get("12:00 pm")),
		                new PieChart.Data("1:00 pm", map.get("1:00 pm")),
		     			new PieChart.Data("2:00 pm", map.get("2:00 pm")),
		     			new PieChart.Data("3:00 pm", map.get("3:00 pm")),
		     			new PieChart.Data("4:00 pm", map.get("4:00 pm")),
		     			new PieChart.Data("5:00 pm", map.get("5:00 pm")));
		        final PieChart chart = new PieChart(pieChartData);
		        chart.setTitle("Available Hours");
		        ((Group) scene.getRoot()).getChildren().add(chart);
	        return (scene);
	    }
}
