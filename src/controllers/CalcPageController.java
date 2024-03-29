package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CalcPageController {
    
    @FXML
    private Button exitBtn;
    
    @FXML
    private Button goBackBtn;
    
    @FXML
    private Label totalPriceLabel;

    @FXML
    private void initialize() {
        // listener exit button
        exitBtn.setOnAction(event -> System.exit(0));
        
        // listener go back button
        goBackBtn.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
            try {
                AnchorPane homePage = (AnchorPane) loader.load();
                
                Scene scene = new Scene(homePage);
                Stage stage = (Stage) goBackBtn.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    // set total price from home page calculate method
    public void updateTotalPrice(double totalPrice) {
        totalPriceLabel.setText(String.format("Итоговая сумма: %.2f", totalPrice));
    }
}

