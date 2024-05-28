package fr.insa.meyer.projetinfofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // Load options from the text file
        List<String> options = loadOptionsFromFile("Options.txt");
        choiceBox.getItems().addAll(options);

        // Create a Label to display the selected option
        Label selectedOptionLabel = new Label("Please select an option");

        // Set a listener to update the Label based on the selected option
        choiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            int selectedIndex = newValue.intValue();
            if (selectedIndex >= 0) {
                String selectedOption = choiceBox.getItems().get(selectedIndex);
                selectedOptionLabel.setText("You picked " + selectedOption);
            }
        });

        // Create a layout and add the ChoiceBox and Label
        VBox layout = new VBox(10);
        layout.getChildren().addAll(choiceBox, selectedOptionLabel);

        // Set up the scene and stage
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceBox Example");
        primaryStage.show();
    }

    private List<String> loadOptionsFromFile(String filename) {
        List<String> options = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 6) {
                    String optionName = parts[1];
                    boolean includeInChoiceBox = parts[4].equals("1");
                    if (includeInChoiceBox) {
                        options.add(optionName);
                        System.out.println("Added: " + optionName);
                    } else {
                        System.out.println("Skipped: " + optionName);
                    }
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return options;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
