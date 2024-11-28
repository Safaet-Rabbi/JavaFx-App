package com.example.chapterfourteen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import java.util.Scanner;

public class RectangleCompare_23 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Scanner for input
        Scanner input = new Scanner(System.in);

        // Create a Pane and a VBox for layout
        Pane pane = new Pane();
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(10, 5, 5, 10));

        // Prompt the user to enter the parameters of two rectangles
        System.out.print("Enter the center coordinates, width, and height of rectangle 1: ");
        String[] str1 = (input.nextLine()).split("[ ]");
        Rectangle r1 = getRectangle(str1);

        System.out.print("Enter the center coordinates, width, and height of rectangle 2: ");
        String[] str2 = (input.nextLine()).split("[ ]");
        Rectangle r2 = getRectangle(str2);

        // Test if rectangles contain or overlap each other
        String output;
        if (contains(r1, r2)) {
            output = "Rectangle 2 is inside Rectangle 1";
        } else if (contains(r2, r1)) {
            output = "Rectangle 1 is inside Rectangle 2";
        } else if (overlaps(r1, r2)) {
            output = "The rectangles overlap";
        } else {
            output = "The rectangles do not overlap";
        }

        // Add rectangles to the pane
        pane.getChildren().addAll(r1, r2);

        // Add pane and result text to the VBox
        vBox.getChildren().addAll(pane, new Text(20, 0, output));

        // Create a scene and set it in the stage
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setTitle("Rectangle Relationship");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Rectangle getRectangle(String[] s) {
        double centerX = Double.parseDouble(s[0]);
        double centerY = Double.parseDouble(s[1]);
        double width = Double.parseDouble(s[2]);
        double height = Double.parseDouble(s[3]);

        // Adjust center coordinates to top-left corner for JavaFX rendering
        double x = centerX - width / 2;
        double y = centerY - height / 2;

        Rectangle r = new Rectangle(x, y, width, height);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.BLACK);
        return r;
    }

    public boolean contains(Rectangle r1, Rectangle r2) {
        return r2.getX() >= r1.getX() &&
                r2.getY() >= r1.getY() &&
                (r2.getX() + r2.getWidth()) <= (r1.getX() + r1.getWidth()) &&
                (r2.getY() + r2.getHeight()) <= (r1.getY() + r1.getHeight());
    }

    /**
     * Returns true if the specified rectangles overlap.
     */
    public boolean overlaps(Rectangle r1, Rectangle r2) {
        return r1.getX() < r2.getX() + r2.getWidth() &&
                r1.getX() + r1.getWidth() > r2.getX() &&
                r1.getY() < r2.getY() + r2.getHeight() &&
                r1.getY() + r1.getHeight() > r2.getY();
    }

    public static void main(String[] args) {
        launch(args);
    }
}