package sample;

import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class ZoomListener implements EventHandler<ScrollEvent> {

    private Graph graph;


    public ZoomListener(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void handle(ScrollEvent event) {
        if (event.getSource().equals(graph.getChart())) {
            graph.zoom(event.getDeltaY()); //tells the graph to zoom in.
        }

    }
}
