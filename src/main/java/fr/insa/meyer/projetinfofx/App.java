package fr.insa.meyer.projetinfofx;
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    private double startX, startY;
    private boolean canDraw = false;  // Flag to toggle drawing mode

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CodeQuest: JavaFX Adventure");

        // Create a Canvas on the left
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        // Add mouse event handlers to the canvas
        canvas.setOnMousePressed(e -> {
            if (canDraw) {
                startX = e.getX();
                startY = e.getY();
            }
        });

        canvas.setOnMouseDragged(e -> {
            if (canDraw) {
                double endX = e.getX();
                double endY = e.getY();

                // Draw the line as the mouse is dragged
                gc.strokeLine(startX, startY, endX, endY);

                // Update the start coordinates for continuous drawing
                startX = endX;
                startY = endY;
            }
        });

        // Create a VBox to hold buttons on the right
        VBox buttonBox = new VBox(10);  // Spacing between buttons
        Button clearButton = new Button("Clear");
        Button toggleDrawButton = new Button("Enable Drawing");
        Button button3 = new Button("Button 3");

        // Set action for clear button
        clearButton.setOnAction(e -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        // Set action for toggle draw button
        toggleDrawButton.setOnAction(e -> {
            canDraw = !canDraw;  // Toggle the drawing flag
            toggleDrawButton.setText(canDraw ? "Disable Drawing" : "Enable Drawing");  // Update button text
        });

        // Add buttons to the VBox
        buttonBox.getChildren().addAll(clearButton, toggleDrawButton, button3);

        // Create a BorderPane as the main layout
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(canvas);
        borderPane.setRight(buttonBox);

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
