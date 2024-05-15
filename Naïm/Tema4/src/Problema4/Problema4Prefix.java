package Problema4;

import acm.program.CommandLineProgram;

public class Problema4Prefix extends CommandLineProgram {
    public void run() {
        String text = "abcd";
        String reversed = printReversed(text);
        println("La cadena invertida és " + reversed);
    }

    private String printReversed(String text){
        if(text.isEmpty()){
            throw new UnsupportedOperationException("La paraula és buida");
        }
        return printReversed(text, text.length() - 1);
    }

    private String printReversed(String text, int pos){
        if(pos == 0){
            return String.valueOf(text.charAt(0));
        }
        return text.charAt(pos) + printReversed(text,pos - 1);
    }

    public static void main(String[] args) {
        new Problema4Prefix().start(args);
    }
}
