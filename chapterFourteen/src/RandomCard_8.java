package com.example.chapterfourteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RandomCard_8 extends Application {

    private static final int TOTAL_CARDS = 54;
    private static final int CARDS_PER_ROW = 9;
    private List<Image> cardImages = new ArrayList<>();
    private Label messageLabel;
    private GridPane cardGrid; // Keep a reference to the GridPane to update it

    @Override
    public void start(Stage primaryStage) {
        loadCardImages();
        setupGameBoard(primaryStage);
    }

    // Load all 54 card images into the cardImages list
    private void loadCardImages() {
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            String imagePath = "/images/" + i + ".png";

            // Ensure the image path is correct
            if (getClass().getResource(imagePath) == null) {
                System.out.println("Image not found: " + imagePath);
            } else {
                Image image = new Image(getClass().getResource(imagePath).toExternalForm(), false);
                cardImages.add(image);
            }
        }
        Collections.shuffle(cardImages); // Shuffle the card images initially
    }

    // Setup the game board
    private void setupGameBoard(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Label to display a message
        messageLabel = new Label("Displaying all 54 cards");
        messageLabel.setFont(new Font(30));
        root.setTop(messageLabel);

        // GridPane to display the cards in rows
        cardGrid = new GridPane();
        cardGrid.setHgap(10);
        cardGrid.setVgap(10);
        root.setCenter(cardGrid);

        // Place the cards in a 9-card-per-row layout
        populateCardGrid();

        // Button to shuffle the cards
        Button shuffleButton = new Button("Shuffle Cards");
        shuffleButton.setOnAction(e -> shuffleCards());
        root.setBottom(shuffleButton);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Displaying 54 Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Populate the card grid with images
    private void populateCardGrid() {
        cardGrid.getChildren().clear(); // Clear the grid before adding new cards
        for (int i = 0; i < cardImages.size(); i++) {
            ImageView cardView = new ImageView(cardImages.get(i));
            cardView.setFitWidth(70);
            cardView.setFitHeight(100);

            int row = i / CARDS_PER_ROW;
            int col = i % CARDS_PER_ROW;
            cardGrid.add(cardView, col, row);
        }
    }

    // Shuffle the cards and update the grid
    private void shuffleCards() {
        Collections.shuffle(cardImages); // Shuffle the card images
        messageLabel.setText("Cards shuffled!");
        populateCardGrid(); // Repopulate the grid with shuffled cards
    }

    public static void main(String[] args) {
        launch(args);
    }
}
