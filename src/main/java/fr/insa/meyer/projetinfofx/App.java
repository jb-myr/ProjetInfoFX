/*
package fr.insa.meyer.projetinfofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private boolean topSelected = false;
    private boolean rightSelected = false;
    private boolean bottomSelected = false;
    private boolean leftSelected = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Application");

        Button openWindowButton = new Button("Open Window");
        openWindowButton.setOnAction(e -> openSquareWindow());

        VBox root = new VBox(10, openWindowButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openSquareWindow() {
        Stage squareStage = new Stage();
        squareStage.setTitle("Square Window");

        // Create Canvas and GraphicsContext for drawing
        Canvas canvas = new Canvas(100, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Draw initial square
        drawSquare(gc);
        
        //Name the sides of the square
        Text Side1 = new Text("1");
        Text Side2 = new Text("4");
        Text Side3 = new Text("2");
        Text Side4 = new Text("3");
        
        //place the name with the coresponding side
        VBox vertsquare = new VBox (10,Side1, canvas, Side4);
        vertsquare.setAlignment(Pos.CENTER);
        HBox totsquare = new HBox (10, Side2, vertsquare, Side3);
        totsquare.setAlignment(Pos.CENTER);

        // Text and CheckBoxes
        Text instructionText = new Text("Select sides to turn black:");
        CheckBox side1 = new CheckBox("1");
        CheckBox side2 = new CheckBox("2");
        CheckBox side3 = new CheckBox("3");
        CheckBox side4 = new CheckBox("4");

        side1.setOnAction(e -> {
            topSelected = side1.isSelected();
            drawSquare(gc);
            DemandePorteFen();
        });
        side2.setOnAction(e -> {
            rightSelected = side2.isSelected();
            drawSquare(gc);
        });
        side3.setOnAction(e -> {
            bottomSelected = side3.isSelected();
            drawSquare(gc);
        });
        side4.setOnAction(e -> {
            leftSelected = side4.isSelected();
            drawSquare(gc);
        });

        VBox checkboxes = new VBox(10, instructionText, side1, side2, side3, side4);
        checkboxes.setAlignment(Pos.CENTER_LEFT);
        checkboxes.setPadding(new Insets(20));

        // Submit button to close the window
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> squareStage.close());

        VBox controls = new VBox(10, checkboxes, submitButton);
        controls.setAlignment(Pos.CENTER);

        HBox layout = new HBox(20, totsquare, controls);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        squareStage.setScene(scene);
        squareStage.initModality(Modality.APPLICATION_MODAL);
        squareStage.show();
    }

    private void drawSquare(GraphicsContext gc) {
        gc.clearRect(0, 0, 100, 100);
        gc.setStroke(topSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(0, 0, 100, 0); // Top

        gc.setStroke(rightSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(100, 0, 100, 100); // Right

        gc.setStroke(bottomSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(100, 100, 0, 100); // Bottom

        gc.setStroke(leftSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(0, 100, 0, 0); // Left
    }
    private void DemandePorteFen(){
        Stage squareStage = new Stage();
        squareStage.setTitle("Square Window");
        Label nbport = new Label("Nombre de porte sur se mur?");
        TextField inputPorte = new TextField();
        Label nbfen = new Label("Nombre de fenetre sur se mur?");
        TextField inputFenetre = new TextField();
        Button fin= new Button("Submit");
        VBox choix = new VBox (10, nbport, inputPorte, nbfen, inputFenetre, fin);
        choix.setAlignment(Pos.CENTER);
         choix.setPadding(new Insets(20));

        Scene scene = new Scene(choix, 400, 300);
        squareStage.setScene(scene);
        squareStage.initModality(Modality.APPLICATION_MODAL);
        squareStage.show();
    }
}
*/
package fr.insa.meyer.projetinfofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private boolean topSelected = false;
    private boolean rightSelected = false;
    private boolean bottomSelected = false;
    private boolean leftSelected = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Application");

        Button openWindowButton = new Button("Open Window");
        openWindowButton.setOnAction(e -> openSquareWindow());

        VBox root = new VBox(10, openWindowButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openSquareWindow() {
        Stage squareStage = new Stage();
        squareStage.setTitle("Square Window");

        // Create Canvas and GraphicsContext for drawing
        Canvas canvas = new Canvas(100, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Draw initial square
        drawSquare(gc);
        
        //Name the sides of the square
        Text Side1 = new Text("1");
        Text Side2 = new Text("4");
        Text Side3 = new Text("2");
        Text Side4 = new Text("3");
        
        //place the name with the coresponding side
        VBox vertsquare = new VBox (10,Side1, canvas, Side4);
        vertsquare.setAlignment(Pos.CENTER);
        HBox totsquare = new HBox (10, Side2, vertsquare, Side3);
        totsquare.setAlignment(Pos.CENTER);

        // Text and CheckBoxes
        Text instructionText = new Text("Select sides to turn black:");
        CheckBox side1 = new CheckBox("1");
        CheckBox side2 = new CheckBox("2");
        CheckBox side3 = new CheckBox("3");
        CheckBox side4 = new CheckBox("4");

        side1.setOnAction(e -> {
            topSelected = side1.isSelected();
            drawSquare(gc);
            DemandePorteFen();
        });
        side2.setOnAction(e -> {
            rightSelected = side2.isSelected();
            drawSquare(gc);
            DemandePorteFen();
        });
        side3.setOnAction(e -> {
            bottomSelected = side3.isSelected();
            drawSquare(gc);
            DemandePorteFen();
        });
        side4.setOnAction(e -> {
            leftSelected = side4.isSelected();
            drawSquare(gc);
            DemandePorteFen();
        });

        VBox checkboxes = new VBox(10, instructionText, side1, side2, side3, side4);
        checkboxes.setAlignment(Pos.CENTER_LEFT);
        checkboxes.setPadding(new Insets(20));

        // Submit button to close the window
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> squareStage.close());

        VBox controls = new VBox(10, checkboxes, submitButton);
        controls.setAlignment(Pos.CENTER);

        HBox layout = new HBox(20, totsquare, controls);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 300);
        squareStage.setScene(scene);
        squareStage.initModality(Modality.APPLICATION_MODAL);
        squareStage.show();
    }

    private void drawSquare(GraphicsContext gc) {
        gc.clearRect(0, 0, 100, 100);
        gc.setStroke(topSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(0, 0, 100, 0); // Top

        gc.setStroke(rightSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(100, 0, 100, 100); // Right

        gc.setStroke(bottomSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(100, 100, 0, 100); // Bottom

        gc.setStroke(leftSelected ? Color.BLACK : Color.GREY);
        gc.strokeLine(0, 100, 0, 0); // Left
    }

    private void DemandePorteFen(){
        Stage inputStage = new Stage();
        inputStage.setTitle("Input Window");

        Label nbport = new Label("Nombre de porte sur ce mur?");
        TextField inputPorte = new TextField();
        Label nbfen = new Label("Nombre de fenetre sur ce mur?");
        TextField inputFenetre = new TextField();
        Label errorLabel = new Label();
        Label Rev = new Label("Quelle revetement pour ce mur?");
        ChoiceBox<String> rev = new ChoiceBox<>();
        rev.getItems().addAll("Option 1", "Option 2", "Option 3","option4");
        
        errorLabel.setTextFill(Color.RED);
        Button fin = new Button("Submit");

        fin.setOnAction(e -> {
            if (isValidInput(inputPorte.getText()) && isValidInput(inputFenetre.getText())) {
                inputStage.close();
            } else {
                errorLabel.setText("Please enter valid natural numbers for both fields.");
            }
        });

        VBox choix = new VBox(10, nbport, inputPorte, nbfen, inputFenetre, errorLabel, fin);
        choix.setAlignment(Pos.CENTER);
        choix.setPadding(new Insets(20));

        Scene scene = new Scene(choix, 400, 300);
        inputStage.setScene(scene);
        inputStage.initModality(Modality.APPLICATION_MODAL);
        inputStage.show();
    }

    private boolean isValidInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        try {
            int number = Integer.parseInt(input);
            return number >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
