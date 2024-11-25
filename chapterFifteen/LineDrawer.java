package com.example.chapterfifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineDrawer extends Application {
    private double startX, startY; // Initial starting point for lines

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Set the starting point to the center of the pane
        startX = 300;
        startY = 300;

        Scene scene = new Scene(pane, 600, 600);

        // Handle key presses
        scene.setOnKeyPressed(event -> {
            double endX = startX;
            double endY = startY;

            switch (event.getCode()) {
                case UP:
                    endY -= 10; // Move up
                    break;
                case DOWN:
                    endY += 10; // Move down
                    break;
                case LEFT:
                    endX -= 10; // Move left
                    break;
                case RIGHT:
                    endX += 10; // Move right
                    break;
                default:
                    return; // Ignore other keys
            }

            // Draw the line
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.BLACK);
            pane.getChildren().add(line);

            // Update starting point for the next line
            startX = endX;
            startY = endY;
        });

        primaryStage.setTitle("Draw Lines with Arrow Keys");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Request focus so the scene can receive key events
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
