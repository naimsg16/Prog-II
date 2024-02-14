
import acm.program.CommandLineProgram;

public class Problema1 extends CommandLineProgram{


    public void run(){

        int n = readInt();

        if(n > 1) {

            if (isPerfect(n)) {

                println("És perfecte.");
            } else {

                println("No és perfecte.");
            }

        }else{

            println("El número és més petit que 1.");
        }
    }

    public boolean isPerfect(int n){

        int divisors = 0;

        for (int i = 1; i < n ; i++){

            if(n % i == 0){

                divisors += i;

            }
        }

        return(n == divisors);
    }
}