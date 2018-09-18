package block3projectP1;

import block3projectP1.print.ShowChart;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * @author Krypton
 */
public class Block3projectP1 extends Application {
    
    
    ShowChart chart = new ShowChart();
    PieChart pieChart = new PieChart();

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        TextField textInput = new TextField();
        Button btnSearch = new Button("Search...");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(0, 25, 25, 0));
        hBox.setAlignment(Pos.BOTTOM_RIGHT);

        hBox.getChildren().addAll(textInput, btnSearch);
        pane.setBottom(hBox);
        
        //An EventHandler that runs when the 'search' button is pressed
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayChart(pane, textInput);
            }
        });

        //An EventHandler that runs when the enter key is pressed
        textInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if (key.getCode().equals(KeyCode.ENTER)) {
                    displayChart(pane, textInput);
                }
            }
        });

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 1200, 725);
        primaryStage.setTitle("Block 3 Project"); //Set stage title
        primaryStage.setWidth(1200); //Set stage width
        primaryStage.setHeight(725); //Set stage height

        primaryStage.setScene(scene); //Place the scene in the stage
        primaryStage.show(); //Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void displayChart(BorderPane pane, TextField text) {
        pane.getChildren().remove(pieChart);

        pieChart.getData().clear();

        pieChart = chart.getPieChart(text.getText());

        pane.setCenter(pieChart);
    }
}
