package lk.ijse.MobileVision.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.MobileVision.bo.BOFactory;
import lk.ijse.MobileVision.bo.custom.UserBO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginForm {

    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String UserName = txtUserName.getText();
        String Password = txtPassword.getText();

        try{
            boolean useIsExist = userBO.isExistUser(UserName,Password);
            if(useIsExist){
                navigateToMainWindow();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"User Name Password is Wrong").show();
            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        }

    }

    private void navigateToMainWindow() throws IOException{

        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/DashBoardForm.fxml"));
        Scene scene = new Scene(rootNode);

       // root.getScene().clear();
        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Main Form");
        primaryStage.show();

        Stage loginPage = (Stage) txtPassword.getScene().getWindow();
        loginPage.close();
    }

    @FXML
    void hyperSignUpOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/signUpForm.fxml"));

        Scene scene = new Scene(rootNode);

      //  root.getChildren().clear();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign Up Page");
    }

    void clear(){
        txtUserName.clear();
        txtPassword.clear();
    }

}


