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

    public s02tatic void main(String[] args) {
        launch(args);
    }

}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    private boolean canDraw = false;  // Flag to toggle drawing mode

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CodeQuest: JavaFX Adventure");

        // Create a Canvas on the left
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        // Create a Coin object
        Coin coin = new Coin(1, gc);

        // Add mouse event handler to the canvas
        canvas.setOnMouseClicked(e -> {
            if (!canDraw) {
                coin.drawCoin(e.getX(), e.getY());
            }
        });

        // Create a VBox to hold buttons on the right
        VBox buttonBox = new VBox(10);  // Spacing between buttons
        Button clearButton = new Button("Clear");
        Button toggleDrawButton = new Button("Enable Drawing");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // Add options to the ChoiceBox
        choiceBox.getItems().addAll("Option 1", "Option 2", "Option 3");
        choiceBox.setValue("Option 1");  // Set default value

        // Set action for clear button
        clearButton.setOnAction(e -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        // Set action for toggle draw button
        toggleDrawButton.setOnAction(e -> {
            canDraw = !canDraw;  // Toggle the drawing flag
            toggleDrawButton.setText(canDraw ? "Disable Drawing" : "Enable Drawing");  // Update button text
        });

        // Add components to the VBox
        buttonBox.getChildren().addAll(clearButton, toggleDrawButton, choiceBox);

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


*/import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    private double startX, startY, endX, endY;
    int creapiece = 0;
    int nbclick=0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing App");

        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(e -> {
            // if you want to make a room and it is your first click
            //get coord and put red dot
            if ((creapiece==1)&&(nbclick==0)){
                startX = e.getX();
                startY = e.getY();
                gc.setFill(Color.RED);
                gc.fillOval(startX - 2.5, startY - 2.5, 5, 5);
                nbclick++;
            }
            //make a room and second click
            //get coord put dot and draw line 1
            if ((creapiece==1)&&(nbclick==1)) {
                endX=e.getX();
                endY=e.getY();
                gc.setFill(Color.RED);
                gc.fillOval(endX - 2.5, endY - 2.5, 5, 5);
                gc.strokeLine(startX, startY, endX, endY);
                nbclick++;
                startX=e.getX();
                startY=e.getY();
            }
            //make room and 3rd click
            //get coord put dot and draw line 
            if ((creapiece==1)&&(nbclick==2)) {
                endX=e.getX();
                endY=e.getY();
                gc.setFill(Color.RED);
                gc.fillOval(endX - 2.5, endY - 2.5, 5, 5);
                gc.strokeLine(startX, startY, endX, endY);
                nbclick=0;
            }
            
        });
        canvas.setOnMouseReleased(e -> {
            
                });

        Button button1 = new Button("Clear Canvas");
        button1.setOnAction(e -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });
        Button button2 = new Button("piece");
        button2.setOnAction (e ->{
            creapiece=1;
        });
        Button button3 = new Button("Button 3");

        VBox buttons = new VBox(10, button1, button2, button3);
        HBox root = new HBox(10, canvas, buttons);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
