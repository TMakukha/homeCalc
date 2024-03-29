module homeCalc {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	exports controllers;
	
	opens controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
