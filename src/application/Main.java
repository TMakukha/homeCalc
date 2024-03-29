package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Загрузка корневого файла fxml (HomePage.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
        primaryStage.setTitle("Калькулятор стоимости строительства дома (примерный)"); // Установка заголовка окна
        primaryStage.setScene(new Scene(root, 600, 400)); // Установка сцены
        primaryStage.show(); // Отображение окна
    }

    public static void main(String[] args) {
        launch(args); // Запуск приложения
    }
}