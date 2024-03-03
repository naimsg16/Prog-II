import acm.program.*;

public class Problema7 extends DialogProgram {

    public void run(){

        String str = readLine("Write something:");
        String result = removeSpaces(str);
        println(result);
    }

    public String removeSpaces (String str){

        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];

        for( int i = 0; i < chars.length; i++){

            if(chars[i] != ' '){

                result[i] = chars[i];

            }
        }

        return new String(result);

    }
}

