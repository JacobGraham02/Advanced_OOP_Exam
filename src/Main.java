/**
 * Final Exam for my COMP1011 course.
 *
 * @author Nicholas Gardner, 200349007
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Inventoryview.fxml"));
        primaryStage.setTitle("Final Exam");
        primaryStage.setScene(new Scene(root, 825, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        new Thread(new ThreadBuilder()).start();
        launch(args);
    }
}
