package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

     //labels
        Label title = new Label("Add User");
        Label usernameLabel = new Label("Username:");
        Label lastNameLabel = new Label("Last Name:");
        Label firstNameLabel = new Label("First Name:");
        Label passwordLabel = new Label("Password:");

      //textfields to enter info
        TextField usernameField = new TextField();
        TextField lastNameField = new TextField();
        TextField firstNameField = new TextField();

        //passwordfield to hide the entered pass.
        PasswordField passwordField = new PasswordField();

        Button saveButton = new Button("Save");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(title, 0, 0, 2, 1);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(firstNameLabel, 0, 3);
        grid.add(firstNameField, 1, 3);
        grid.add(passwordLabel, 0, 4);
        grid.add(passwordField, 1, 4);
        grid.add(saveButton, 1, 5);

      //action for save button
        saveButton.setOnAction(e -> {

            //object to get info later
            EmploymentForm employment = new EmploymentForm();

            //get etnered info
            employment.setUsername(usernameField.getText());
            employment.setLastName(lastNameField.getText());
            employment.setFirstName(firstNameField.getText());
            employment.setPassword(passwordField.getText());
//to handle datatabse operations
            EmploymentFormDao dao = new EmploymentFormDao();

            try {

                //send info stored with employement object to the database
                dao.saveEmploymentForm(employment);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Save");
                alert.setContentText("Successful!");
                alert.showAndWait();

            } catch (Exception exception) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Could not save the user.");
                alert.showAndWait();

                exception.printStackTrace();
            }
        });

        //create windo
        Scene scene = new Scene(grid, 350, 300);
        stage.setTitle("JavaFX Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    	//start javafx application
        launch(args);
    }
}