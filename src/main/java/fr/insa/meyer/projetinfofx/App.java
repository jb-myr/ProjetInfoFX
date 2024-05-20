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


*/
/*
import javafx.application.Application;
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
            if ((creapiece==1) && (nbclick==0)){
                startX = e.getX();
                startY = e.getY();
                gc.setFill(Color.RED);
                gc.fillOval(startX - 2.5, startY - 2.5, 5, 5);
                nbclick=1;
            }
            //make a room and second click
            //get coord put dot and draw line 1
            if ((creapiece==1) && (nbclick==1)) {
                endX=e.getX();
                endY=e.getY();
                gc.setFill(Color.RED);
                gc.fillOval(endX - 2.5, endY - 2.5, 5, 5);
                gc.strokeLine(startX, startY, endX, endY);
                nbclick=2;
                startX=e.getX();
                startY=e.getY();
            }
            //make room and 3rd click
            //get coord put dot and draw line 
            if ((creapiece==1) && (nbclick==2)) {
                endX=e.getX();
                endY=e.getY();
                gc.setFill(Color.RED);
                gc.fillOval(endX - 2.5, endY - 2.5, 5, 5);
                gc.strokeLine(startX, startY, endX, endY);
                nbclick=0;
            }
            
        });
       // canvas.setOnMouseReleased(e -> {
            
         //       });

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
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DrawingApp extends Application {
    private List<double[]> points = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing App");

        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseClicked(e -> handleMouseClicked(e, gc));

        Button button1 = new Button("Clear Canvas");
        button1.setOnAction(e -> clearCanvas(gc, canvas));

        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        VBox buttons = new VBox(10, button1, button2, button3);
        HBox root = new HBox(10, canvas, buttons);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMouseClicked(MouseEvent e, GraphicsContext gc) {
        double x = e.getX();
        double y = e.getY();

        // Add the click point
        points.add(new double[]{x, y});

        // Draw the red dot for the current click
        gc.setFill(Color.RED);
        gc.fillOval(x - 2.5, y - 2.5, 5, 5);

        int size = points.size();
        if (size == 2) {
            // Draw a line between the first and second points
            gc.strokeLine(points.get(0)[0], points.get(0)[1], points.get(1)[0], points.get(1)[1]);
        } else if (size == 3) {
            // Draw a line between the second and third points
            gc.strokeLine(points.get(1)[0], points.get(1)[1], points.get(2)[0], points.get(2)[1]);

            // Calculate the fourth point to complete the parallelogram
            double[] p1 = points.get(0);
            double[] p2 = points.get(1);
            double[] p3 = points.get(2);

            double fourthX = p3[0] + (p2[0] - p1[0]);
            double fourthY = p3[1] + (p2[1] - p1[1]);

            // Draw lines to complete the parallelogram
            gc.strokeLine(p3[0], p3[1], fourthX, fourthY);
            gc.strokeLine(fourthX, fourthY, p1[0], p1[1]);

            // Draw the fourth dot
            gc.fillOval(fourthX - 2.5, fourthY - 2.5, 5, 5);
        }
    }

    private void clearCanvas(GraphicsContext gc, Canvas canvas) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        points.clear(); // Clear the stored points
    }
}

*/
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

public class App extends Application {
    private Canvas canvas;
    private GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rectangle Drawing App");

        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();

        Button button1 = new Button("Clear Canvas");
        button1.setOnAction(e -> clearCanvas());

        Button button2 = new Button("Add Points");
        button2.setOnAction(e -> openInputWindow());

        Button button3 = new Button("Button 3");

        VBox buttons = new VBox(10, button1, button2, button3);
        buttons.setAlignment(Pos.CENTER);
        HBox root = new HBox(10, canvas, buttons);
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
                drawRectangle(x1, y1, x2, y2);
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

    private void drawRectangle(double x1, double y1, double x2, double y2) {

        gc.setFill(Color.RED);
        gc.fillOval(x1 - 2.5, y1 - 2.5, 5, 5);
        gc.fillOval(x2 - 2.5, y2 - 2.5, 5, 5);

        double x3 = x1;
        double y3 = y2;
        double x4 = x2;
        double y4 = y1;

        gc.fillOval(x3 - 2.5, y3 - 2.5, 5, 5);
        gc.fillOval(x4 - 2.5, y4 - 2.5, 5, 5);

        gc.strokeLine(x1, y1, x4, y4);
        gc.strokeLine(x4, y4, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x1, y1);
    }
}
