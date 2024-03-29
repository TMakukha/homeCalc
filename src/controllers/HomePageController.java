package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HomePageController {
    
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
        exitBtn.setOnAction(this::handleExit);
        
        // calculation button listener
        calculationBtn.setOnAction(this::handleCalculation);
        
        // radio buttons listener
        oneFloorRadioBtn.setOnAction(this::handleOneFloorSelected);
        twoFloorsRadioBtn.setOnAction(this::handleTwoFloorsSelected);
    }
    
    /**
     * Close application button
     * @param event close applcation
     */
    private void handleExit(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Calculation home price
     * @param event
     */
    private void handleCalculation(ActionEvent event) {
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

