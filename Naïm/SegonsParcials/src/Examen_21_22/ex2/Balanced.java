package Examen_21_22.ex2;

import acm.program.CommandLineProgram;

public class Balanced extends CommandLineProgram {

    public void run(){
        int[] vector = new int[] {21, 84, 7, 42, 35,-42, 21};
        int factor = 42;
        println(balanced(vector,factor));
    }

    private boolean balanced(int[] vector, int factor){

        return balanced(vector,factor,0,vector.length - 1);
    }

    private boolean balanced(int[] vector, int factor, int begin, int end){
        if(end - begin == 2){
            return vector[begin + 1] == factor; //també funciona amb vector[end - 1]
        } else if (end - begin == 1) {
            return vector[begin] + vector[end] == factor;
        }else {
            return  vector[begin] + vector[end] == factor &&
                    balanced(vector,factor,begin + 1,end - 1)
            ;
        }
    }

    public static void main(String[] args) {
        new Balanced().start(args);
    }

}
