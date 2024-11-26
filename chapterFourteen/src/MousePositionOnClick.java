package com.example.chapterfifteen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MousePositionOnClick extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Text object to display mouse position
        Text positionText = new Text("Mouse Position: ");

        // Set up the layout
        StackPane root = new StackPane();
        root.setPadding(new Insets(20));
        root.getChildren().add(positionText);

        // Event handler to display mouse position when mouse is clicked
        root.setOnMouseClicked((MouseEvent event) -> {
            double x = event.getSceneX();
            double y = event.getSceneY();
            positionText.setText("Mouse Position: (" + x + ", " + y + ")");
        });

        // Set up the scene and stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Mouse Position on Click");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
