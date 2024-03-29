package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcPageController extends BaseController{
    
    @FXML
    private Button exitBtn;
    
    @FXML
    private Button goBackBtn;
    
    @FXML
    private Label totalPriceLabel;

    @FXML
    private void initialize() {
    	// listener exit button
        initializeExitButton(exitBtn);

        // listener go back button
        initializeGoBackButton(goBackBtn, "/view/HomePage.fxml", goBackBtn);
    }
    
    // set total price from home page calculate method
    public void updateTotalPrice(double totalPrice) {
        totalPriceLabel.setText(String.format("Итоговая сумма: %.2f", totalPrice));
    }
}

