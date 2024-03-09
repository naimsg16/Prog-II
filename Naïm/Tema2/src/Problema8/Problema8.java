package Problema8;
import acm.program.*;

public class Problema8 extends CommandLineProgram{

    public void run(){
        Complex z = new Complex(1,1);
        println(z.toStringBinomial());
        println(z.toStringPolar());
    }

    public static void main(String[] args){
        new Problema8().start(args);
    }
}


