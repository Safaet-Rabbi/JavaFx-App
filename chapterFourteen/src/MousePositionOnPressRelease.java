package com.example.chapterfifteen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MousePositionOnPressRelease extends Application {

    private boolean isMousePressed = false; // Track mouse press status

    @Override
    public void start(Stage primaryStage) {
        // Create a Text object to display mouse position
        Text positionText = new Text("Mouse Position: ");

        // Set up the layout
        StackPane root = new StackPane();
        root.setPadding(new Insets(20));
        root.getChildren().add(positionText);

        // Event handler to display mouse position when mouse is pressed
        root.setOnMousePressed((MouseEvent event) -> {
            isMousePressed = true;
            updateMousePosition(event, positionText);
        });

        // Event handler to stop displaying the mouse position when the mouse is released
        root.setOnMouseReleased((MouseEvent event) -> {
            isMousePressed = false;
            positionText.setText("Mouse Position: ");
        });

        // Event handler to update mouse position while the mouse button is pressed
        root.setOnMouseMoved((MouseEvent event) -> {
            if (isMousePressed) {
                updateMousePosition(event, positionText);
            }
        });

        // Set up the scene and stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Mouse Position on Press and Release");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to update the position text
    private void updateMousePosition(MouseEvent event, Text positionText) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        positionText.setText("Mouse Position: (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
