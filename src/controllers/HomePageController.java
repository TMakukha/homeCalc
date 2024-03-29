package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.HouseCalculator;

public class HomePageController extends BaseController {
    
    @FXML
    private Button exitBtn;
    
    @FXML
    private Button calculationBtn;
    
    @FXML
    private TextField houseLenghtInput;
    
    @FXML
    private TextField houseWidthInput;
    
    @FXML
    private TextField ceilingHeightInput;
    
    @FXML
    private RadioButton oneFloorRadioBtn;
    
    @FXML
    private RadioButton twoFloorsRadioBtn;
    
    @FXML
    private ChoiceBox<String> roofMaterialChoiceBox;
    
    @FXML
    private ChoiceBox<String> wallMaterialChoiceBox;
    
    @FXML
    private ChoiceBox<String> foundationTypeChoiceBox;

    @FXML
    private void initialize() {
        // choice boxes data
        roofMaterialChoiceBox.getItems().addAll("прямая", "односкатная", "двускатная");
        wallMaterialChoiceBox.getItems().addAll("сруб", "кирпич", "газоблок");
        foundationTypeChoiceBox.getItems().addAll("свайный", "ленточный");
        
        // setup default house data
        houseLenghtInput.setText("0");
        houseWidthInput.setText("0");
        ceilingHeightInput.setText("0");
        
        // exit button listener
        initializeExitButton(exitBtn);
        
        // radio buttons listener
        oneFloorRadioBtn.setOnAction(this::handleOneFloorSelected);
        twoFloorsRadioBtn.setOnAction(this::handleTwoFloorsSelected);
    }
    
    /**
     * Calculation home price
     * @param event
     */
    @FXML
    private void handleCalculation(ActionEvent event) {
        // Check all fields filled
        if (houseLenghtInput.getText().isEmpty() || houseWidthInput.getText().isEmpty() || ceilingHeightInput.getText().isEmpty() ||
                roofMaterialChoiceBox.getValue() == null || wallMaterialChoiceBox.getValue() == null || foundationTypeChoiceBox.getValue() == null) {
            // Throw error if any field is not filled
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все обязательные поля!");
            alert.showAndWait();
            return;
        }

        // if all fields filled go calculation
        double length = Double.parseDouble(houseLenghtInput.getText());
        double width = Double.parseDouble(houseWidthInput.getText());
        int floorCount = oneFloorRadioBtn.isSelected() ? 1 : 2;
        String roofMaterial = roofMaterialChoiceBox.getValue();
        String wallMaterial = wallMaterialChoiceBox.getValue();
        String foundationType = foundationTypeChoiceBox.getValue();

        double totalPrice = HouseCalculator.calculateTotalPrice(length, width, floorCount, roofMaterial, wallMaterial, foundationType);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CalcPage.fxml"));
            Parent calcPageParent = loader.load();
            CalcPageController calcPageController = loader.getController();
            calcPageController.updateLengthOutput(length);
            calcPageController.updateWidthOutput(width);
            calcPageController.updateFloorsCountOutput(floorCount);
            calcPageController.updateSquareOutput(length * width);
            calcPageController.updateRoofOutput(roofMaterial);
            calcPageController.updateWallOutput(wallMaterial);
            calcPageController.updateFoundationOutput(foundationType);
            calcPageController.updateTotalPrice(totalPrice);
            AnchorPane root = (AnchorPane) calculationBtn.getScene().getRoot();

            root.getChildren().setAll(calcPageParent.getChildrenUnmodifiable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * unselect other radiobutton when this was selected
     * @param event
     */
    private void handleOneFloorSelected(ActionEvent event) {
        twoFloorsRadioBtn.setSelected(false);
    }
    
    /**
     * unselect other radiobutton when this was selected
     * @param event
     */
    private void handleTwoFloorsSelected(ActionEvent event) {
        oneFloorRadioBtn.setSelected(false);
    }
}

