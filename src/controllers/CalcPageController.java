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
    private Label lengthLabel;
    
    @FXML
    private Label widthLabel;
    
    @FXML
    private Label floorsCountLabel;
    
    @FXML
    private Label squareLabel;
    
    @FXML 
    private Label roofLabel;
    
    @FXML
    private Label wallLabel;
    
    @FXML
    private Label foundationLabel;
    
    @FXML
    private void initialize() {
    	// listener exit button
        initializeExitButton(exitBtn);

        // listener go back button
        initializeGoBackButton(goBackBtn, "/view/HomePage.fxml", goBackBtn);
    }
    
    public void updateLengthOutput(double length) {
    	lengthLabel.setText(String.format("Длина: %.2f", length));
    }
    
    public void updateWidthOutput(double width) {
    	widthLabel.setText(String.format("Ширина: %.2f", width));
    }
    
    public void updateFloorsCountOutput(int floorsCount) {
    	floorsCountLabel.setText(String.format("Количество этажей: %d", floorsCount));
    }
    
    public void updateSquareOutput(double square) {
    	squareLabel.setText(String.format("Площадь фундамента: %.2f", square));
    }
    
    public void updateRoofOutput(String roofType) {
    	roofLabel.setText(String.format("Тип крыши: %s", roofType));
    }
    
    public void updateWallOutput(String wallType) {
    	wallLabel.setText(String.format("Тип стен: %s", wallType));
    }
    
    public void updateFoundationOutput(String foundationType) {
    	foundationLabel.setText(String.format("Тип фундамента: %s", foundationType));
    }
    // set total price from home page calculate method
    public void updateTotalPrice(double totalPrice) {
        totalPriceLabel.setText(String.format("Итоговая сумма: %.2f", totalPrice));
    }
}

