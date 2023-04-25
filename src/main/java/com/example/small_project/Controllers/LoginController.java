package com.example.small_project.Controllers;

import com.example.small_project.DaoImpl.UserDaoImpl;
import com.example.small_project.View;
import com.example.small_project.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class LoginController {

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private AnchorPane loginPane;

    public String lastUser;


    @FXML
    void createNewUser(ActionEvent event) {

        Dialog<ButtonType> createNewUser = new Dialog<>();

        createNewUser.setTitle("Create user");
        createNewUser.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Label user = new Label("Insert username");
        TextField usernameText = new TextField();
        HBox username = new HBox(user, usernameText);

        Label pass = new Label("Insert password");
        TextField passwordText = new TextField();
        HBox password = new HBox(pass, passwordText);


        VBox setup = new VBox(username,password);
        createNewUser.getDialogPane().setContent(setup);
        Optional<ButtonType> button = createNewUser.showAndWait();

        if (button.get() == ButtonType.OK && passwordText.getLength() > 0 && usernameText.getLength() > 0){
            try{
                udi.createUser(usernameText.getText(), passwordText.getText(),0);
            }
            catch (Exception e){

            }
        }
    }

    @FXML
    void loginButton(ActionEvent event) throws IOException, SQLException {

        if(udi.adminExists(usernameTextField.getText(), passwordTextField.getText()) == true){

            lastUser = usernameTextField.getText();
            System.out.println("COMPLETE");
            ViewSwitcher.switchTo(View.ADMIN);


        }

        else if(udi.loginExists(usernameTextField.getText(), passwordTextField.getText()) == true){

            System.out.println("COMPLETE");
            ViewSwitcher.switchTo(View.MAIN);

        }
        else{
            Dialog<ButtonType> enterValidCredentials = new Dialog<>();
            enterValidCredentials.setTitle("Error");
            enterValidCredentials.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
            Label selectCredentials = new Label("Please enter valid credentials to log in");
            enterValidCredentials.getDialogPane().setContent(selectCredentials);

            Optional<ButtonType> knap1 = enterValidCredentials.showAndWait();

            System.out.println("FAILED");
        }
    }

    public String getLastUser(){
        return lastUser;
    }

    UserDaoImpl udi = new UserDaoImpl();



    // Lav en fadetransition + Path (sammen med en ParallelTransition, så det sker på samme tid
}
