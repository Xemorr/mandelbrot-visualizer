package sample;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class Graph {

    private ScatterChart chart;
    private NumberAxis imaginaryAxis;
    private NumberAxis realAxis;
    private double range = 2;

    public Graph() { //creates the argand diagram
        imaginaryAxis = new NumberAxis(range * -1, range, 1/(range*30)); //creates imaginary axis
        realAxis = new NumberAxis(range * -1, range, 1 / (range*30)); //creates real axis
        imaginaryAxis.setLabel("imaginary"); //names it imaginary
        realAxis.setLabel("real"); //names it real
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(realAxis, imaginaryAxis); //creates the chart
        scatterChart.setOnScroll(new ZoomListener(this)); //on scroll, calls the listener
        this.chart = scatterChart;
    }

    public void resetAxis() { //resets axis for zooming in and out
        imaginaryAxis.setTickLength(1 / (range * 10));
        realAxis.setTickLength(1/ (range * 10));
        imaginaryAxis.setUpperBound(range);
        realAxis.setUpperBound(range);
        realAxis.setLowerBound(range * -1);
        imaginaryAxis.setLowerBound(range * -1);
    }

    public ScatterChart getChart() {
        return chart;
    }

    public double getRange() {
        return range;
    }

    public void zoom(double zoomAmount) { //allows you to zoom in by the amount you scrolled.
        range = range - (range / zoomAmount);
        resetAxis();
        recalculateGraph();
    }


    public void recalculateGraph() { //calculates the series for your size graph
        MandelbrotSet mandelbrotSet = new MandelbrotSet(range, range / 50);
        XYChart.Series<Double, Double> mandelbrotSeries = new XYChart.Series<>();
        mandelbrotSeries.getData().addAll(mandelbrotSet.mandelbrotSet);
        mandelbrotSeries.setName("In the Mandelbrot Set.");
        XYChart.Series<Double, Double> fiveHundredPlus = new XYChart.Series<>();
        fiveHundredPlus.setName("Five Hundred+ Iterations");
        fiveHundredPlus.getData().addAll(mandelbrotSet.fiveHundredPlus);
        XYChart.Series<Double, Double> oneHundredPlus = new XYChart.Series<>();
        oneHundredPlus.setName("One Hundred+ Iterations");
        oneHundredPlus.getData().addAll(mandelbrotSet.oneHundredPlus);
        chart.getData().clear();
        chart.getData().add(mandelbrotSeries);
        chart.getData().add(fiveHundredPlus);
        chart.getData().add(oneHundredPlus);
    }

}
