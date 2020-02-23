package sample;

import javafx.scene.chart.XYChart;

import java.util.HashSet;
import java.util.Set;

public class MandelbrotSet {

    Complex previousPoint;
    int numberOfIterations = 1000;
    Set<XYChart.Data<Double, Double>> mandelbrotSet = new HashSet<>();
    Set<XYChart.Data<Double, Double>> fiveHundredPlus = new HashSet<>();
    Set<XYChart.Data<Double, Double>> oneHundredPlus = new HashSet<>();

    public MandelbrotSet(double range, double granularity) {
        for (double i = -1 * range; i < range; i += granularity) {
            for (double j = -1 * range; j < range; j += granularity) {
                Complex complex = new Complex(i, j);
                previousPoint = new Complex(0, 0); //mandelbrot always starts at 0 + 0i
                int mandelbrotStability = getMandelbrotStability(complex);
                if (mandelbrotStability == 1000) { //is in the mandelbrot set for 1000 iterations.
                    mandelbrotSet.add(complex.getData());
                }
                else if (mandelbrotStability >= 500) { //is very stable, but not in set.
                    fiveHundredPlus.add(complex.getData());
                }
                else if (mandelbrotStability >= 100) { //is quite stable
                    oneHundredPlus.add(complex.getData());
                }
            }
        }
    }

    public int getMandelbrotStability(Complex complex) {
        //iterates through doing the mandelbrot formula
        // until the square of the absolute is 8,
        // or iterations have ended.
        for (int k = 0; k < numberOfIterations; k++) {
            previousPoint = previousPoint.square();
            previousPoint = previousPoint.add(complex);
            double squaredValue = previousPoint.getSquaredValue();
            if (squaredValue > 8) {
                return k;
            }
        }
        return 1000;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

}
