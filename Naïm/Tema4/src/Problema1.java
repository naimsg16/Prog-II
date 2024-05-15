import acm.program.CommandLineProgram;

public class Problema1 extends CommandLineProgram {

    public void run() {
        int num = readInt("De quin nombre vols calcular el factorial? ");
        int res = factorial(num);
        println("El factorial de " + num + " és " + res);
    }

    public int factorial (int num){
       if( num == 1 ){
           return 1;
       }
       return num * factorial(num -1);
    }

    public static void main(String[] args) {
        new Problema1().start(args);
    }
}
