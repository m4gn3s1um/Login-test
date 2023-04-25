package com.example.small_project.Controllers;

import com.example.small_project.DaoImpl.UserDaoImpl;
import com.example.small_project.Model.User;
import com.example.small_project.Controllers.LoginController;
import com.example.small_project.View;
import com.example.small_project.ViewSwitcher;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class AdminController {
    @FXML
    private MFXListView userList;

    @FXML
    private Label adminWelcomeLabel;

    public void initialize(){
        createUserList();
        adminWelcomeLabel.setText("Welcome ");
    }

    public void createUserList(){
        List<User> users = usd.userList();
        for(User us : users)
            userList.getItems().add(us);
    }


    public void removeUser(ActionEvent actionEvent) {
    }

    public void makeAdmin(ActionEvent actionEvent) {
    }


    UserDaoImpl usd = new UserDaoImpl();

    public void logOut(ActionEvent actionEvent) throws IOException {
        ViewSwitcher.switchTo(View.LOGIN);
    }

    public void userTrack(MouseEvent mouseEvent) {
        ObservableList valgteIndeks = (ObservableList) userList.getSelectionModel().getSelectedValues();
        System.out.println("Hej");
    }
}
