package Problema2;
import acm.program.*;

import java.io.FileReader;
import java.io.IOException;

public class NumbersSum extends CommandLineProgram {

    private final static String FILE_NAME = "num.txt";
    private int sum;
    private String number;
    private FileReader input;

    public void run(){
        try {
            input = new FileReader(FILE_NAME);
            readChars();
            input.close();
            println("The sum is equal to " + sum);
        } catch (IOException ex) {
            println("There has been an error ;(");
        }

    }

    private void readChars() throws IOException {
        number = "";
        int c = input.read();
        while(c != -1){
            readChar((char) c);
            c = input.read();
        }
        sum += Integer.parseInt(number);
    }

    private void readChar(char c){
        if(Character.isDigit(c)){
            number += (char) c;
        }else if(!number.isEmpty()){
            sum += Integer.parseInt(number);
            number = "";
        }
    }

    public static void main(String[] args) {
        new NumbersSum().start(args);
    }
}
