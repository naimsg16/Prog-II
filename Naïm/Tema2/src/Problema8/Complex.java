package Problema8;

import java.text.DecimalFormat;

public class Complex {

    private double realPart;
    private double imaginaryPart;

    public Complex (double realPart, double imaginaryPart){
        setRealPart(realPart);
        setImaginaryPart(imaginaryPart);
    }


    public void setRealPart(double realPart){
        this.realPart = realPart;
    }
    public void setImaginaryPart(double imaginaryPart){
        this.imaginaryPart = imaginaryPart;
    }

    private double module(){
        return Math.sqrt(this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart);
    }
    private double argument(){
        if(this.realPart == 0.0 && this.imaginaryPart == 0.0){
            return 0.0;
        }
        if(imaginaryPart == 0.0 && this.realPart < 0){
            return -90.0;
        }
        return Math.toDegrees(Math.atan(this.imaginaryPart / this.realPart));
    }

    public double getRealPart(){
        return this.realPart;
    }

    public double getImaginaryPart(){
        return this.imaginaryPart;
    }

    public double getModule(){
        return this.module();
    }

    public double getArgument(){
        return this.argument();
    }

    //----------------------------------------------------
    //Instance methods

    public void add (Complex z){
        this.realPart += z.realPart;
        this.imaginaryPart += z.imaginaryPart;
    }

    public void substract(Complex z){
        this.realPart -= z.realPart;
        this.imaginaryPart -= z.imaginaryPart;
    }

    public void multiply (Complex z){
        double module = this.module() * z.module();
        double argument = this.argument() + z.argument();
        this.realPart = module * Math.cos(argument);
        this.imaginaryPart = module * Math.sin(argument);
    }

    public void divide (Complex z){
        double module = this.module() / z.module();
        double argument = this.argument() - z.argument();
        this.realPart = module * Math.cos(argument);
        this.imaginaryPart = module * Math.sin(argument);
    }

    //--------------------------------------------------------------------
    //Static methods

    public Complex add (Complex z1, Complex z2){
        double real = z1.realPart + z2.realPart;
        double imaginary = z1.imaginaryPart + z2.imaginaryPart;
        return new Complex(real,imaginary);
    }
    public Complex substract (Complex z1, Complex z2){
        double real = z1.realPart - z2.realPart;
        double imaginary = z1.imaginaryPart - z2.imaginaryPart;
        return new Complex(real,imaginary);
    }
    public Complex multiply (Complex z1, Complex z2){
        double module = z1.module() * z2.module();
        double argument = z1.argument() + z2.argument();
        return new Complex(module * Math.cos(argument),module * Math.sin(argument));
    }
    public Complex divide (Complex z1, Complex z2){
        double module = z1.module() / z2.module();
        double argument = z1.argument() - z2.argument();
        return new Complex(module * Math.cos(argument),module * Math.sin(argument));
    }


    public boolean equalsComplex(Complex z){
        return this.realPart == z.realPart && this.imaginaryPart == z.imaginaryPart;
    }

    public String toStringBinomial (){
        String formattedRealPart = new DecimalFormat("0.##").format(this.realPart);
        String formattedImaginaryPart = new DecimalFormat("0.##").format(this.imaginaryPart);
        if (this.realPart == 0.0 && this.imaginaryPart == 0.0){
            return "0";
        }
        if(this.realPart == 0.0){
            return formattedImaginaryPart + "i";
        }
        if (this.imaginaryPart == 0.0){
            return formattedRealPart;
        }
        return formattedRealPart + " + " + formattedImaginaryPart + "i";
    }

    public String toStringPolar (){
        String formattedModule = new DecimalFormat("0.##").format(module());
        String formattedArgument = new DecimalFormat("0.##").format(argument());
        return formattedModule + "∠" + formattedArgument + "º";
    }
}
