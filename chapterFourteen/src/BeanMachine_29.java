package com.example.chapterfourteen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class BeanMachine_29 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Constants for machine dimensions and layout
        final double MACHINE_WIDTH = 300;
        final double MACHINE_HEIGHT = 400;
        final double PEG_RADIUS = 5;
        final int ROWS = 7; // Number of rows of pegs
        final double HORIZONTAL_SPACING = 20; // Space between pegs horizontally
        final double VERTICAL_SPACING = 30; // Space between pegs vertically
        final double SLOT_HEIGHT = 50; // Height of slots at the bottom

        // Starting position of the top of the machine
        double startX = MACHINE_WIDTH / 2;
        double startY = 50;

        // Draw the triangular outline of the machine
        Line leftLine = new Line(startX, startY, startX - MACHINE_WIDTH / 2, MACHINE_HEIGHT - SLOT_HEIGHT);
        Line rightLine = new Line(startX, startY, startX + MACHINE_WIDTH / 2, MACHINE_HEIGHT - SLOT_HEIGHT);
        Line bottomLine = new Line(startX - MACHINE_WIDTH / 2, MACHINE_HEIGHT - SLOT_HEIGHT, startX + MACHINE_WIDTH / 2, MACHINE_HEIGHT - SLOT_HEIGHT);

        // Style the outline lines
        leftLine.setStroke(Color.DARKGRAY);
        rightLine.setStroke(Color.DARKGRAY);
        bottomLine.setStroke(Color.DARKGRAY);

        pane.getChildren().addAll(leftLine, rightLine, bottomLine);

        // Draw pegs in a triangular formation
        for (int row = 0; row < ROWS; row++) {
            for (int i = 0; i <= row; i++) {
                double x = startX - row * HORIZONTAL_SPACING / 2 + i * HORIZONTAL_SPACING;
                double y = startY + row * VERTICAL_SPACING;
                Circle peg = new Circle(x, y, PEG_RADIUS);
                peg.setFill(Color.DARKBLUE); // Changed color for better visibility
                pane.getChildren().add(peg);
            }
        }

        // Draw vertical slots at the bottom
        for (int i = 0; i <= ROWS + 1; i++) {
            double x = startX - (ROWS * HORIZONTAL_SPACING) / 2 + i * HORIZONTAL_SPACING;
            Line slot = new Line(x, MACHINE_HEIGHT - SLOT_HEIGHT, x, MACHINE_HEIGHT);
            slot.setStroke(Color.DARKGRAY);
            pane.getChildren().add(slot);
        }

        // Add a light background color to the pane
        pane.setStyle("-fx-background-color: #F0F8FF;");

        // Add the scene and stage
        Scene scene = new Scene(pane, MACHINE_WIDTH, MACHINE_HEIGHT);
        primaryStage.setTitle("Bean Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
