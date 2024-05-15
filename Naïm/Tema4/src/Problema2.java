import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {
    public void run() {
        println("De quins nombres vols calcular els factorials? ");
        int num1 = readInt("Primer nombre: ");
        int num2 = readInt("Segon nombre: ");
        int res = mcd(num1, num2);
        println("El mcd de " + num1 + " i " + num2 + " és " + res);
    }

    public int mcd (int num1, int num2){
        if(num1 == num2){
            return num1;
        }
        if(num1 > num2){
            return mcd(num1 - num2, num2);
        }else{
            return mcd(num1, num2 - num1);
        }
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }

}
