package com.example.chapterfourteen;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SineCosine_19 extends Application {
    private Polyline sinePolyline = new Polyline();
    private Polyline cosinePolyline = new Polyline();
    private double scaleFactor = 50;

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Pane graphPane = new Pane(); // Separate pane for graph and gridlines
        pane.setCenter(graphPane);

        // Create gridlines and axes
        createGridlinesAndAxes(graphPane);

        // Plot initial sine and cosine functions
        plotSineAndCosine(graphPane);

        // Add input field and button for updating graph
        TextField inputField = new TextField();
        inputField.setPromptText("Enter scale factor...");
        Button updateButton = new Button("Update The Graph");
        updateButton.setOnAction(e -> updateGraph(graphPane, inputField.getText()));

        HBox inputBox = new HBox(10, inputField, updateButton);
        inputBox.setAlignment(Pos.CENTER);

        // Add input box at the bottom
        pane.setBottom(inputBox);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Sine and Cosine Plot with Gridlines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create gridlines and axes
    private void createGridlinesAndAxes(Pane graphPane) {
        // Add gridlines (spaced every 10 pixels)
        for (int i = 0; i <= 600; i += 10) {
            Line verticalGridLine = new Line(i, 0, i, 400);
            Line horizontalGridLine = new Line(0, i, 600, i);

            verticalGridLine.setStroke(Color.LIGHTGRAY);
            verticalGridLine.setOpacity(0.5); // Light gray for better visibility
            horizontalGridLine.setStroke(Color.LIGHTGRAY);
            horizontalGridLine.setOpacity(0.5);

            graphPane.getChildren().addAll(verticalGridLine, horizontalGridLine);
        }

        // Create the X and Y axes
        Line xAxis = new Line(0, 200, 600, 200); // X-axis
        Line yAxis = new Line(300, 0, 300, 400); // Y-axis

        // Add arrows to the axes
        Line xArrow1 = new Line(590, 190, 600, 200);
        Line xArrow2 = new Line(590, 210, 600, 200);
        Line yArrow1 = new Line(290, 10, 300, 0);
        Line yArrow2 = new Line(310, 10, 300, 0);

        // Add labels
        Text xLabel = new Text(570, 220, "X");
        Text yLabel = new Text(310, 20, "Y");

        // Add labels for key points on the X-axis
        graphPane.getChildren().addAll(
                new Text(190, 220, "-2\u03c0"),
                new Text(240, 220, "-\u03c0"),
                new Text(300, 220, "0"),
                new Text(360, 220, "\u03c0"),
                new Text(410, 220, "2\u03c0")
        );

        graphPane.getChildren().addAll(xAxis, yAxis, xArrow1, xArrow2, yArrow1, yArrow2, xLabel, yLabel);
    }

    // Plot sine and cosine graphs
    private void plotSineAndCosine(Pane graphPane) {
        ObservableList<Double> sinePoints = sinePolyline.getPoints();
        ObservableList<Double> cosinePoints = cosinePolyline.getPoints();

        sinePoints.clear();
        cosinePoints.clear();

        for (int x = -170; x <= 170; x++) {
            sinePoints.add(x + 300.0); // Scale X to center graph
            sinePoints.add(200 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI)); // Scale Y

            cosinePoints.add(x + 300.0); // Scale X to center graph
            cosinePoints.add(200 - scaleFactor * Math.cos((x / 100.0) * 2 * Math.PI)); // Scale Y
        }

        sinePolyline.setStroke(Color.RED);
        cosinePolyline.setStroke(Color.BLUE);

        if (!graphPane.getChildren().contains(sinePolyline)) {
            graphPane.getChildren().addAll(sinePolyline, cosinePolyline);
        }
    }

    // Update the graph with a new scale factor
    private void updateGraph(Pane graphPane, String input) {
        try {
            double newScaleFactor = Double.parseDouble(input);
            scaleFactor = newScaleFactor;
            plotSineAndCosine(graphPane);
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + input);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
