package sample;

import javafx.scene.chart.XYChart;

public class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    public Complex add(Complex complex) { //adds complex numbers and returns a new complex number
        double real = this.getRealPart() + complex.getRealPart();
        double imaginary = this.getImaginaryPart() + complex.getImaginaryPart();
        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex complex) { //subtracts complex numbers and returns a new complex number
        double real = this.getRealPart() - complex.getRealPart();
        double imaginary = this.getImaginaryPart() - complex.getImaginaryPart();
        return new Complex(real, imaginary);
    }

    public Complex multiply(Complex complex) { //multiplies two complex numbers
        double real = (complex.getRealPart() * this.getRealPart()) - (this.getImaginaryPart() * complex.getImaginaryPart());
        double imaginary = (this.real * complex.getImaginaryPart()) + (this.imaginary * complex.getRealPart());
        return new Complex(real, imaginary);
    }

    public double getSquaredValue() { //returns squared absolute value
        return real * real + imaginary * imaginary;
    }

    public Complex square() { //squares complex number and returns new one
        return multiply(this);
    }

    public Complex clone() {
        return new Complex(real, imaginary);
    }

    public XYChart.Data<Double, Double> getData() { //puts it into the format for the graph.
        XYChart.Data<Double, Double> data = new XYChart.Data<>();
        data.setXValue(real);
        data.setYValue(imaginary);
        return data;
    }

}
