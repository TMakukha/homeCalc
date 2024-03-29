package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseController {

    public void initializeExitButton(Button exitBtn) {
        exitBtn.setOnAction(event -> System.exit(0));
    }

    protected void initializeGoBackButton(Button goBackBtn, String fxmlPath, Button sourceButton) {
        goBackBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            try {
                AnchorPane previousPage = (AnchorPane) loader.load();
                Scene scene = new Scene(previousPage);
                Stage stage = (Stage) sourceButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

