package com.example.chapterfifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RotateRectangleApp extends Application {

    private static final double ROTATE_ANGLE = 15.0;  // The angle by which to rotate the rectangle (15 degrees)
    private Rectangle rectangle;

    @Override
    public void start(Stage primaryStage) {
        // Create a rectangle with initial properties
        rectangle = new Rectangle(200, 100, Color.BLUE);

        // Create a Rotate button
        Button rotateButton = new Button("Rotate");
        rotateButton.setOnAction(e -> rotateRectangle());

        // Set up the layout with the rectangle and the button
        StackPane root = new StackPane();
        root.getChildren().addAll(rectangle, rotateButton);

        // Position the button below the rectangle
        StackPane.setAlignment(rotateButton, javafx.geometry.Pos.BOTTOM_CENTER);

        // Set up the scene and stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Rotate Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to rotate the rectangle by 15 degrees
    private void rotateRectangle() {
        rectangle.setRotate(rectangle.getRotate() + ROTATE_ANGLE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
