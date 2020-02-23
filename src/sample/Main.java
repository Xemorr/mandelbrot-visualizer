package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mandelbrot Visualiser"); //sets the title
        BorderPane layout = new BorderPane(); //creates the layout, this layout has multiple sections. I only use center layout
        createStartButton(layout); //creates the button
        primaryStage.setScene(new Scene(layout, 300, 250)); //creates scene, this holds the nodes.
        primaryStage.show(); //shows the window.
    }



    public Button createStartButton(BorderPane layout) {
        Button button = new Button("Start");
        layout.setCenter(button);
        button.setOnAction(new StartListener(button, layout));
        return button;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
