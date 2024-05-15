package Problema3;

import acm.program.CommandLineProgram;

public class Problema3Prefix extends CommandLineProgram {
    public void run() {
        int[] v = {3, 5, 0, 7, 6, 9};
        int sum = sumArray(v);
        println("La suma és igual a " + sum);
    }

    private int sumArray(int[] v){
        if(v.length == 0){
            throw new UnsupportedOperationException("L'array és buida");
        }
        return sumArray(v, 0);
    }

    private int sumArray(int[] v, int pos){
        if(pos == v.length - 1){
            return v[v.length - 1];
        }
        return v[pos] + sumArray(v,pos + 1);
    }

    public static void main(String[] args) {
        new Problema3Prefix().start(args);
    }
}
