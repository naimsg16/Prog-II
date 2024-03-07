package Problema6;
import acm.program.*;
public class Problema6 extends CommandLineProgram{

    public void run(){

        //testAdd();
        Rational r = Rational.add(new Rational(1,-2),new Rational(4,3));
        println(r.toString());

    }

    public void test(){


    }

    public void testAdd(){
        Rational[] expected = new Rational[] {new Rational(3,4),
                                              new Rational(5,6),
                                              new Rational(-4,7)};
//        Rational[] operations = ;

        check(expected[0],Rational.add(new Rational(1,4),new Rational(2,4)),"add",0);

    }

    public void check(Rational expected, Rational actual, String operation, int test){
        if(expected.equalsRational(actual)){
            println("OK in test #" + test + " of " + operation);
        }else{
            print("WRONG in test #" + test + " of " + operation);
            print("\t it is " + actual.toString() + " but it should be " + expected.toString());
        }
    }


    public static void main(String[] args){
        new Problema6().start(args);
    }

}
