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

    public String toStringBinomial (){
        String formattedRealPart = new DecimalFormat("0.##").format(this.realPart);
        String formattedImaginaryPart = new DecimalFormat("0.##").format(this.imaginaryPart);
        if(this.realPart == 0){
            return formattedImaginaryPart + "i";
        }
        if (this.imaginaryPart == 0){
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
