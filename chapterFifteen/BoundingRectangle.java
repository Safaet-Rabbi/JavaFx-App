package com.example.chapterfifteen;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BoundingRectangle extends Application {

    private ArrayList<Circle> points = new ArrayList<>();
    private Pane pane = new Pane();
    private Rectangle boundingRect = new Rectangle();
    private Text instructionText = new Text(20, 20, "Click to add points, right-click to remove.");

    @Override
    public void start(Stage primaryStage) {
        // Set up the pane and scene
        pane.getChildren().add(instructionText);
        pane.setOnMouseClicked(event -> handleMouseClick(event.getX(), event.getY(), event.getButton()));

        // Bounding rectangle properties
        boundingRect.setFill(Color.TRANSPARENT);
        boundingRect.setStroke(Color.RED);
        boundingRect.setStrokeWidth(2);
        pane.getChildren().add(boundingRect);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Bounding Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handle mouse click for adding/removing points
    private void handleMouseClick(double x, double y, MouseButton button) {
        if (button == MouseButton.PRIMARY) {
            addPoint(x, y);
        } else if (button == MouseButton.SECONDARY) {
            removePoint(x, y);
        }
    }

    // Add a new point at the specified position
    private void addPoint(double x, double y) {
        Circle point = new Circle(x, y, 10, Color.BLUE);
        points.add(point);
        pane.getChildren().add(point);
        updateBoundingRectangle();
    }

    // Remove the point closest to the specified position
    private void removePoint(double x, double y) {
        Circle closestPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (Circle point : points) {
            double distance = Math.sqrt(Math.pow(point.getCenterX() - x, 2) + Math.pow(point.getCenterY() - y, 2));
            if (distance < minDistance) {
                minDistance = distance;
                closestPoint = point;
            }
        }

        if (closestPoint != null) {
            points.remove(closestPoint);
            pane.getChildren().remove(closestPoint);
            updateBoundingRectangle();
        }
    }

    // Update the bounding rectangle to encompass all points
    private void updateBoundingRectangle() {
        if (points.isEmpty()) {
            boundingRect.setWidth(0);
            boundingRect.setHeight(0);
            boundingRect.setX(0);
            boundingRect.setY(0);
            return;
        }

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;

        for (Circle point : points) {
            double x = point.getCenterX();
            double y = point.getCenterY();
            minX = Math.min(minX, x - 10);  // 10 is the radius of the point
            minY = Math.min(minY, y - 10);
            maxX = Math.max(maxX, x + 10);
            maxY = Math.max(maxY, y + 10);
        }

        boundingRect.setX(minX);
        boundingRect.setY(minY);
        boundingRect.setWidth(maxX - minX);
        boundingRect.setHeight(maxY - minY);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
