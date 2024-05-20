package fr.insa.meyer.projetinfofx;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

public class App extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private double scale = 1.0;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rectangle Drawing App");
        
        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();
        
        ScrollPane scrollPane = new ScrollPane(canvas);

        Button button1 = new Button("Suprimer");
        button1.setOnAction(e -> clearCanvas());

        Button button2 = new Button("Creation de piece");
        button2.setOnAction(e -> openInputWindow());
        
        Button zoomInButton = new Button("Zoom In");
        zoomInButton.setOnAction(e -> zoomCanvas(1.2));

        Button zoomOutButton = new Button("Zoom Out");
        zoomOutButton.setOnAction(e -> zoomCanvas(0.8));

        Button button3 = new Button("Button 3");
        
        HBox zoomButtons = new HBox(10, zoomInButton, zoomOutButton);
        zoomButtons.setAlignment(Pos.CENTER);
        VBox canvasWithZoom = new VBox(10, zoomButtons, scrollPane);

        VBox buttons = new VBox(10, button1, button2, button3);
        buttons.setAlignment(Pos.CENTER);
        HBox root = new HBox(10, canvasWithZoom, buttons);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void openInputWindow() {
        Stage inputStage = new Stage();
        inputStage.setTitle("Enter les Coordonnes");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label labelX1 = new Label("X1:");
        GridPane.setConstraints(labelX1, 0, 0);
        TextField inputX1 = new TextField();
        GridPane.setConstraints(inputX1, 1, 0);

        Label labelY1 = new Label("Y1:");
        GridPane.setConstraints(labelY1, 0, 1);
        TextField inputY1 = new TextField();
        GridPane.setConstraints(inputY1, 1, 1);

        Label labelX2 = new Label("X2:");
        GridPane.setConstraints(labelX2, 0, 2);
        TextField inputX2 = new TextField();
        GridPane.setConstraints(inputX2, 1, 2);

        Label labelY2 = new Label("Y2:");
        GridPane.setConstraints(labelY2, 0, 3);
        TextField inputY2 = new TextField();
        GridPane.setConstraints(inputY2, 1, 3);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);
        submitButton.setOnAction(e -> {
            try {
                double x1 = Double.parseDouble(inputX1.getText());
                double y1 = Double.parseDouble(inputY1.getText());
                double x2 = Double.parseDouble(inputX2.getText());
                double y2 = Double.parseDouble(inputY2.getText());
                MakeRoom(x1, y1, x2, y2);
                inputStage.close();
            } catch (NumberFormatException ex) {
                // Handle invalid input
            }
        });

        grid.getChildren().addAll(labelX1, inputX1, labelY1, inputY1, labelX2, inputX2, labelY2, inputY2, submitButton);

        Scene scene = new Scene(grid, 300, 200);
        inputStage.setScene(scene);
        inputStage.initModality(Modality.APPLICATION_MODAL);
        inputStage.showAndWait();
    }

    private void MakeRoom(double x1, double y1, double x2, double y2) {
        
        double x3 = x1;
        double y3 = y2;
        double x4 = x2;
        double y4 = y1;

        gc.setFill(Color.RED);
        gc.fillOval(x1 - 2.5, y1 - 2.5, 5, 5);
        gc.fillOval(x2 - 2.5, y2 - 2.5, 5, 5);
        gc.fillOval(x3 - 2.5, y3 - 2.5, 5, 5);
        gc.fillOval(x4 - 2.5, y4 - 2.5, 5, 5);

        gc.strokeLine(x1, y1, x4, y4);
        gc.strokeLine(x4, y4, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x1, y1);
        
        
        // il faut crée les coin avec les coords (x1, y1) etc et les murs
        
       
    }
    private void zoomCanvas(double factor) {
        scale *= factor;
        gc.scale(factor, factor);
        redrawCanvas();
    }

    private void redrawCanvas() {
        // Clear and redraw canvas content as needed (example with dots)
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Add your redraw logic here if needed, for example:
        // drawRectangle(...); // Call to a method that redraws the existing shapes
    }


/*
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private ResizableCanvas canvas;
    private double scale = 1.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rectangle Drawing App");

        canvas = new ResizableCanvas(800, 800);

        ScrollPane scrollPane = new ScrollPane(canvas);
        scrollPane.setPannable(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Button clearButton = new Button("Clear Canvas");
        clearButton.setOnAction(e -> canvas.clearCanvas());

        Button addPointsButton = new Button("Add Points");
        addPointsButton.setOnAction(e -> openInputWindow());

        Button zoomInButton = new Button("Zoom In");
        zoomInButton.setOnAction(e -> zoomCanvas(1.2));

        Button zoomOutButton = new Button("Zoom Out");
        zoomOutButton.setOnAction(e -> zoomCanvas(0.8));

        Button button3 = new Button("Button 3");

        VBox zoomButtons = new VBox(10, zoomInButton, zoomOutButton);
        zoomButtons.setAlignment(Pos.CENTER);
        HBox canvasWithZoom = new HBox(10, zoomButtons, scrollPane);

        VBox buttons = new VBox(10, clearButton, addPointsButton, button3);
        buttons.setAlignment(Pos.CENTER);
        HBox root = new HBox(10, canvasWithZoom, buttons);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openInputWindow() {
        Stage inputStage = new Stage();
        inputStage.setTitle("Enter Coordinates");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label labelX1 = new Label("X1:");
        GridPane.setConstraints(labelX1, 0, 0);
        TextField inputX1 = new TextField();
        GridPane.setConstraints(inputX1, 1, 0);

        Label labelY1 = new Label("Y1:");
        GridPane.setConstraints(labelY1, 0, 1);
        TextField inputY1 = new TextField();
        GridPane.setConstraints(inputY1, 1, 1);

        Label labelX2 = new Label("X2:");
        GridPane.setConstraints(labelX2, 0, 2);
        TextField inputX2 = new TextField();
        GridPane.setConstraints(inputX2, 1, 2);

        Label labelY2 = new Label("Y2:");
        GridPane.setConstraints(labelY2, 0, 3);
        TextField inputY2 = new TextField();
        GridPane.setConstraints(inputY2, 1, 3);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 4);
        submitButton.setOnAction(e -> {
            try {
                double x1 = Double.parseDouble(inputX1.getText());
                double y1 = Double.parseDouble(inputY1.getText());
                double x2 = Double.parseDouble(inputX2.getText());
                double y2 = Double.parseDouble(inputY2.getText());
                canvas.ensureSize(Math.max(x1, x2) + 50, Math.max(y1, y2) + 50);
                canvas.drawRectangle(x1, y1, x2, y2);
                inputStage.close();
            } catch (NumberFormatException ex) {
                // Handle invalid input
            }
        });

        grid.getChildren().addAll(labelX1, inputX1, labelY1, inputY1, labelX2, inputX2, labelY2, inputY2, submitButton);

        Scene scene = new Scene(grid, 300, 200);
        inputStage.setScene(scene);
        inputStage.initModality(Modality.APPLICATION_MODAL);
        inputStage.showAndWait();
    }

    private void zoomCanvas(double factor) {
        scale *= factor;
        canvas.setScaleX(scale);
        canvas.setScaleY(scale);
    }

*/
}
