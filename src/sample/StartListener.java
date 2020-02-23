package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StartListener implements EventHandler<ActionEvent> {

    Button button;
    BorderPane layout;
    public StartListener(Button button, BorderPane layout) {
        this.button = button;
        this.layout = layout;
    }

    @Override
    public void handle(ActionEvent event) {
        if (button.equals(event.getSource())) {
            Graph graph = new Graph(); //creates the graph
            layout.getChildren().clear();
            graph.recalculateGraph();
            layout.setCenter(graph.getChart());
        }
    }

}
