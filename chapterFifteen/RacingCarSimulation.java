package com.example.chapterfifteen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RacingCarSimulation extends Application {

    private double x = 0; // Initial x-coordinate of the car
    private final double y = 300; // Fixed y-coordinate for the road
    private double speed = 2; // Initial speed of the car
    private final double canvasWidth = 800; // Width of the canvas
    private boolean isPaused = false;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(canvasWidth, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button pauseResumeButton = new Button("Pause");
        pauseResumeButton.setOnAction(event -> {
            isPaused = !isPaused;
            pauseResumeButton.setText(isPaused ? "Resume" : "Pause");
        });

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(20), e -> {
            if (!isPaused) {
                update(gc);
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(pauseResumeButton);
        BorderPane.setAlignment(pauseResumeButton, javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, canvasWidth, 450);

        // Add key press handlers to the scene

        // Ensure the scene has focus for key events
        primaryStage.setTitle("Car Racing Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void update(GraphicsContext gc) {
        // Clear the canvas
        gc.clearRect(0, 0, canvasWidth, 400);

        // Draw the background
        drawBackground(gc);

        // Redraw the car at the updated x-coordinate
        drawCar(gc, x, y);

        // Update the x-coordinate for the car
        x += speed;
        if (x > canvasWidth) {
            x = -100; // Restart the car from the left
        }
    }

    private void drawBackground(GraphicsContext gc) {
        // Sky
        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0, 0, canvasWidth, 250);

        // Soil
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(0, 250, canvasWidth, 150);

        // Road
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 280, canvasWidth, 60);

        // Trees
        gc.setFill(Color.DARKGREEN);
        for (int i = 0; i < 8; i++) {
            double treeX = i * 100 + 20;
            gc.fillOval(treeX, 180, 40, 40);
            gc.setFill(Color.BROWN);
            gc.fillRect(treeX + 15, 220, 10, 30);
            gc.setFill(Color.DARKGREEN);
        }
    }

    private void drawCar(GraphicsContext gc, double x, double y) {
        // Car base
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y - 20, 80, 20);

        // Car top
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(x + 10, y - 40, 60, 20);

        // Wheels
        gc.setFill(Color.BLACK);
        gc.fillOval(x + 10, y - 10, 15, 15);
        gc.fillOval(x + 55, y - 10, 15, 15);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
