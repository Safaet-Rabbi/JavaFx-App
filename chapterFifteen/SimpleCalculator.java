package com.example.chapterfifteen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Stack;

public class SimpleCalculator extends Application {

    private TextField display;

    @Override
    public void start(Stage primaryStage) {
        // Create the text field to display the result
        display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 20px; -fx-alignment: center-right;");

        // Create the buttons for digits and operations
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button btnAdd = new Button("+");
        Button btnSubtract = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        Button btnEquals = new Button("=");
        Button btnClear = new Button("C");

        // Set up the grid layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        // Add buttons to the grid
        grid.add(display, 0, 0, 4, 1);
        grid.add(btn1, 0, 1);
        grid.add(btn2, 1, 1);
        grid.add(btn3, 2, 1);
        grid.add(btnAdd, 3, 1);
        grid.add(btn4, 0, 2);
        grid.add(btn5, 1, 2);
        grid.add(btn6, 2, 2);
        grid.add(btnSubtract, 3, 2);
        grid.add(btn7, 0, 3);
        grid.add(btn8, 1, 3);
        grid.add(btn9, 2, 3);
        grid.add(btnMultiply, 3, 3);
        grid.add(btn0, 0, 4);
        grid.add(btnClear, 1, 4);
        grid.add(btnEquals, 2, 4);
        grid.add(btnDivide, 3, 4);

        // Handle button actions
        btn1.setOnAction(e -> appendToDisplay("1"));
        btn2.setOnAction(e -> appendToDisplay("2"));
        btn3.setOnAction(e -> appendToDisplay("3"));
        btn4.setOnAction(e -> appendToDisplay("4"));
        btn5.setOnAction(e -> appendToDisplay("5"));
        btn6.setOnAction(e -> appendToDisplay("6"));
        btn7.setOnAction(e -> appendToDisplay("7"));
        btn8.setOnAction(e -> appendToDisplay("8"));
        btn9.setOnAction(e -> appendToDisplay("9"));
        btn0.setOnAction(e -> appendToDisplay("0"));
        btnAdd.setOnAction(e -> appendToDisplay("+"));
        btnSubtract.setOnAction(e -> appendToDisplay("-"));
        btnMultiply.setOnAction(e -> appendToDisplay("*"));
        btnDivide.setOnAction(e -> appendToDisplay("/"));
        btnClear.setOnAction(e -> clearDisplay());
        btnEquals.setOnAction(e -> calculateResult());

        // Set up the scene and stage
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Append the clicked button's value to the display
    private void appendToDisplay(String value) {
        display.appendText(value);
    }

    // Clear the display
    private void clearDisplay() {
        display.clear();
    }

    // Calculate the result of the expression
    private void calculateResult() {
        try {
            String result = evaluateExpression(display.getText());
            display.setText(result);
        } catch (Exception e) {
            display.setText("Error");
        }
    }

    // Evaluate the mathematical expression in the display manually
    private String evaluateExpression(String expression) {
        try {
            // Handle basic operators and precedence
            Stack<BigDecimal> values = new Stack<>();
            Stack<Character> operators = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);

                // If the current character is a digit, add it to the current value
                if (Character.isDigit(c)) {
                    int numStart = i;
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        i++;
                    }
                    int numEnd = i;
                    values.push(new BigDecimal(expression.substring(numStart, numEnd)));
                    i--;
                }
                // If the current character is an operator, process the operator stack
                else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(c);
                }
            }

            // Apply remaining operators
            while (!operators.isEmpty()) {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }

            return values.pop().toString();
        } catch (Exception e) {
            return "Error";
        }
    }

    // Check operator precedence
    private boolean hasPrecedence(char operator1, char operator2) {
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return true;
        }
        return false;
    }

    // Apply an operator to two operands
    private BigDecimal applyOperator(char operator, BigDecimal b, BigDecimal a) {
        switch (operator) {
            case '+':
                return a.add(b);
            case '-':
                return a.subtract(b);
            case '*':
                return a.multiply(b);
            case '/':
                if (b.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a.divide(b);
        }
        return BigDecimal.ZERO;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
