import acm.program.*;
import java.util.StringTokenizer;

public class Problema4 extends ConsoleProgram{

    String DELIMITERS = " .;:,0123456789";

    public void run(){
        String line = readLine("Write something:");
        String longest = longestWord(line);
        println("The longest word in \"" + line + "\" is \"" + longest + "\"" );
    }

    public String longestWord(String line){
        StringTokenizer txt = new StringTokenizer(line,DELIMITERS);
        String longest = txt.nextToken();
        while(txt.hasMoreTokens()){
            String next = txt.nextToken();
            if(longest.length() < next.length()){ // Si hi ha més paraules de la mateixa llargada, es queda amb la primera.
                longest = next;
            }
        }
        return longest;
    }
}
