package Problema6;
import acm.program.*;

import java.util.StringTokenizer;

public class Problema6 extends CommandLineProgram{

    public void run(){

        test();

    }

    public void test(){
        testAdd();
        testSubstract();
    }

    public void testAdd(){
        Rational[] expected = new Rational[] {
                new Rational(3,4),
                new Rational(5,6),
                new Rational(-4,3),
                new Rational(4,1)
        };
        Rational[] operator1 = new Rational[] {
                new Rational(1,4),
                new Rational(7,12),
                new Rational(13,-6),
                new Rational(20,9)
        };
        Rational[] operator2 = new Rational[] {
                new Rational(2,4),
                new Rational(2,8),
                new Rational(5,6),
                new Rational(16,9)
        };
        for( int i = 0; i < expected.length; i++){
            check(expected[i],Rational.add(operator1[i],operator2[i]),"add",i+1);
        }

    }

    public void testSubstract(){
        Rational[] expected = new Rational[] {
                new Rational(-11,10),
                new Rational(0,1),
                new Rational(7,30),
                new Rational(1,1)
        };
        Rational[] operator1 = new Rational[] {
                new Rational(3,-5),
                new Rational(2,8),
                new Rational(5,6),
                new Rational(6,4)
        };
        Rational[] operator2 = new Rational[] {
                new Rational(2,4),
                new Rational(1,4),
                new Rational(3,5),
                new Rational(1,2)
        };
        for( int i = 0; i < expected.length; i++){
            check(expected[i],Rational.substract(operator1[i],operator2[i]),"substract",i+1);
        }
    }

    public void testMultiplication(){
        Rational[] expected = new Rational[] {
                new Rational(3,14),
                new Rational(4,1),
                new Rational(5,2),
                new Rational(-12,1)
        };
        Rational[] operator1 = new Rational[] {
                new Rational(3,4),
                new Rational(4,3),
                new Rational(-5,3),
                new Rational(-9,6)
        };
        Rational[] operator2 = new Rational[] {
                new Rational(2,7),
                new Rational(6,2),
                new Rational(9,-6),
                new Rational(8,1)
        };
        for( int i = 0; i < expected.length; i++){
            check(expected[i],Rational.substract(operator1[i],operator2[i]),"multiplication",i+1);
        }

    }

    public void check(Rational expected, Rational actual, String operation, int test){

        if(expected.equalsRational(actual)){
            println("OK in test #" + test + " of " + operation);
        }else{
            print("WRONG in test #" + test + " of " + operation);
            println(":it is " + actual.toString() + " but it should be " + expected.toString());
        }
    }


    public static void main(String[] args){
        new Problema6().start(args);
    }

}
