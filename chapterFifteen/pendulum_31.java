package com.example.chapterfifteen;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class pendulum_31 extends Application {
    private double angle = 45; // Initial angle in degrees
    private double angleDelta = 1; // Change in angle per frame
    private double speed = 10; // Speed of the animation (lower value = faster)
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane for the pendulum
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);

        // Create the background rectangle
        Rectangle background = new Rectangle(0, 0, 400, 400);
        background.setFill(Color.LIGHTBLUE); // Set background color

        // Create the pendulum components
        double pivotX = 200, pivotY = 50, length = 150;
        Line string = new Line(pivotX, pivotY, pivotX, pivotY + length);
        Circle bob = new Circle(pivotX, pivotY + length, 20, Color.BLUE);

        // Add background and components to the pane
        pane.getChildren().addAll(background, string, bob);

        // Create the animation
        timeline = new Timeline(new KeyFrame(Duration.millis(speed), e -> {
            angle += angleDelta;
            if (Math.abs(angle) > 45) { // Change direction if the angle exceeds ±45°
                angleDelta *= -1;
            }
            double radians = Math.toRadians(angle);
            double bobX = pivotX + length * Math.sin(radians);
            double bobY = pivotY + length * Math.cos(radians);
            string.setEndX(bobX);
            string.setEndY(bobY);
            bob.setCenterX(bobX);
            bob.setCenterY(bobY);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Handle key events
        pane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                speed = Math.max(1, speed - 1); // Increase speed (lower value = faster)
                timeline.setRate(timeline.getRate() + 0.1);
            } else if (event.getCode() == KeyCode.DOWN) {
                speed = Math.min(100, speed + 1); // Decrease speed
                timeline.setRate(timeline.getRate() - 0.1);
            } else if (event.getCode() == KeyCode.P) {
                timeline.pause(); // Pause the animation
            } else if (event.getCode() == KeyCode.S) {
                timeline.play(); // Resume the animation
            }
        });

        // Add the pane to the scene and display the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Pendulum Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Request focus to enable key events
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
