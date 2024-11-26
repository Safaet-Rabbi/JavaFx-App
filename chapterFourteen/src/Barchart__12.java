package com.example.chapterfourteen;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Barchart__12 extends Application {

    private static final int BAR_WIDTH = 80;   // Width of each bar
    private static final int WINDOW_HEIGHT = 500; // Total window height
    private static final int WINDOW_WIDTH = 500;  // Total window width
    private static final int CHART_MAX_HEIGHT = 300; // Max height for the bars

    @Override
    public void start(Stage primaryStage) {
        // Set up each bar with percentage and color
        VBox projectBox = createBar("Projects - 20%", 0.2, Color.RED);
        VBox quizBox = createBar("Quizzes - 10%", 0.1, Color.BLUE);
        VBox midtermBox = createBar("Midterm Exam - 30%", 0.3, Color.GREEN);
        VBox finalBox = createBar("Final Exam - 40%", 0.4, Color.ORANGE);

        // Horizontal layout for all bars
        HBox barChart = new HBox(15, projectBox, quizBox, midtermBox, finalBox);
        barChart.setAlignment(Pos.BOTTOM_CENTER);

        // BorderPane layout for centering the chart
        BorderPane root = new BorderPane();
        root.setCenter(barChart);

        // Set up the scene and stage
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle("Bar Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to create each bar with label and styling
    private VBox createBar(String labelText, double percentage, Color color) {
        // Bar representing the percentage
        Rectangle bar = new Rectangle(BAR_WIDTH, CHART_MAX_HEIGHT * percentage);
        bar.setFill(color);
        bar.setStroke(Color.BLACK); // Border around each bar

        // Label for each bar
        Text label = new Text(labelText);
        label.setFont(Font.font(14));
        label.setFill(Color.BLACK);

        // StackPane to center label above the bar
        StackPane labelContainer = new StackPane(label);
        labelContainer.setAlignment(Pos.CENTER);

        // Combine label and bar in a VBox
        VBox barBox = new VBox(10, labelContainer, bar);
        barBox.setAlignment(Pos.BOTTOM_CENTER);
        return barBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
