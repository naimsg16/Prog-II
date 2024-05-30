package Examen_20_21.ex2;

import acm.program.CommandLineProgram;

public class SumOfEven extends CommandLineProgram {

    public void run(){
        int[] vector = {2,5,5,7,3,4,2,6,8,1,4,4,8};
        println(sumOfPairs(vector) == 38);
    }

    private int sumOfPairs(int[] vector){
        return sumOfPairs(vector,vector.length - 1);
    }

    private int sumOfPairs(int[] vector, int pos){
        if( pos == 0 ){
            if(vector[pos] % 2 == 0){
                return vector[pos];
            }
            return 0;
        }
        if(vector[pos] % 2 == 0){
            return vector[pos] + sumOfPairs(vector,pos - 1);
        }
        return sumOfPairs(vector,pos - 1);
    }

    public static void main(String[] args) {
        new SumOfEven().start(args);
    }
}
