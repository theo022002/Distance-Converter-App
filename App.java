import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) 
    {
        // Create a title label for the application with specific styling
        Label titleLabel = new Label("Convert Distance");
        titleLabel.setFont(new Font("Arial", 18));  // Set font size and style
        titleLabel.setTextFill(Color.WHITE);        // Set font color
        titleLabel.setStyle("-fx-background-color: #C0392B; -fx-padding: 10px; -fx-font-weight: bold;");

        // Centering the title using HBox
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);  // Center align the title
        titleBox.setStyle("-fx-background-color: #C0392B;");  // Set background color of the title

        // Label for amount input and text field for entering a number
        Label label = new Label("Enter the amount: ");
        TextField textField = new TextField(); // TextField for user input

        // Label and ChoiceBox for selecting the unit to convert from
        Label label2 = new Label("From");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("foot", "inch", "mile", "yard", "meter", "cm", "mm");
        choiceBox.setValue("From Unit");  // Default value in ChoiceBox

        // Label and ChoiceBox for selecting the unit to convert to
        Label label3 = new Label("To");
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        choiceBox2.getItems().addAll("foot", "inch", "mile", "yard", "meter", "cm", "mm");
        choiceBox2.setValue("To Unit");  // Default value in ChoiceBox

        // Buttons for submitting the form, reversing units, and closing the app
        Button button = new Button("Submit");
        Button button_rev = new Button("Reverse");
        Button button_close = new Button("Close");
        
        // Labels to show the result of the conversion
        Label resultLabel = new Label();
        Label resultLabel2 = new Label();
        Label label_line = new Label("\n");

        // VBox to hold all the elements vertically with spacing between them
        VBox vbox = new VBox(10); 
        
        // HBoxes to organize components horizontally
        HBox hbox_amount = new HBox(10);
        HBox hbox_from = new HBox(10); 
        HBox hbox_to = new HBox(10); 
        HBox hbox_button = new HBox(10); 
        HBox resultBox = new HBox(resultLabel);

        // Add components to the VBox and HBoxes
        vbox.getChildren().addAll(titleBox);
        hbox_amount.getChildren().addAll(label, textField);
        hbox_from.getChildren().addAll(label2, choiceBox);
        hbox_to.getChildren().addAll(label3, choiceBox2);
        vbox.getChildren().addAll(hbox_amount, hbox_from, hbox_to);
        hbox_button.getChildren().addAll(button, button_rev, button_close);
        vbox.getChildren().addAll(hbox_button, label_line, resultBox, resultLabel2);

        // Close button action: close the application
        button_close.setOnAction(e ->
        {
            primaryStage.close();
        });

        // Reverse button action: swap the values in the "From" and "To" ChoiceBoxes
        button_rev.setOnAction(e ->
        {
            String temp = choiceBox.getValue(); 
            choiceBox.setValue(choiceBox2.getValue()); 
            choiceBox2.setValue(temp); 
        });

        // Submit button action: process the conversion and display the result
        button.setOnAction(e -> 
        {
            try
            { 
                // Get the amount entered by the user
                double amount = Double.parseDouble(textField.getText());
                
                // Get the selected units from the ChoiceBoxes
                String FromUnit = choiceBox.getValue();
                String ToUnit = choiceBox2.getValue();
                
                // Check if valid units are selected, otherwise show an error
                if(choiceBox.getValue().equals("From Unit") || choiceBox2.getValue().equals("To Unit"))
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Please select a valid unit code.");
                    alert.setContentText("The code unit must be valid.");
                    alert.showAndWait();
                }
                else
                {
                    // Styling the result label
                    resultLabel.setText(String.format("ANSWER"));
                    resultLabel.setFont(new Font("Arial", 15));
                    resultLabel.setTextFill(Color.WHITE);
                    resultLabel.setStyle("-fx-background-color: #C0392B; -fx-padding: 10px; -fx-font-weight: bold;");
                    resultBox.setAlignment(Pos.CENTER);
                    resultBox.setStyle("-fx-background-color: #C0392B;");

                    // Perform the conversion using a method (Convert.Converter method assumed)
                    double res = Convert.Converter(amount, FromUnit, ToUnit, 7);
                    
                    // Format and display the result based on the conversion result
                    if(res < 1e-2)
                        resultLabel2.setText(String.format("%.2f %s = %.5f %s", amount, FromUnit, res, ToUnit));
                    else
                    resultLabel2.setText(String.format("%.2f %s = %.2f %s", amount, FromUnit, res, ToUnit));
                }
            }
            catch (NumberFormatException ex)
            {
                // Show an alert dialog when input is invalid (non-numeric input)
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Please enter a valid number");
                alert.setContentText("The amount must be a valid number.");
                alert.showAndWait();
            }
        });

        // Set up the scene with the main layout and set it for the stage
        Scene scene = new Scene(vbox, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Distance Converter");  // Set window title
        primaryStage.show();
    }

    // Launch the JavaFX application
    public static void main(String[] args) 
    {
        launch(args);
    }
}    