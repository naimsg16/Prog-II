
import acm.program.CommandLineProgram;

public class Problema1 extends CommandLineProgram{


    public void run(){

        int n = readInt();

        if (isPerfect(n)){

            println("És perfecte.");
        }else {

            println("No és perfecte.");
        }
    }

    public boolean isPerfect(int n){

        int divisors = 0;

        for (int i = n-1; i > 0; i += -1){

            if(n % i == 0){

                divisors += i;

            }
        }

        return(n == divisors);
    }
}