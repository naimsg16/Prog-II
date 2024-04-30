import acm.program.*;

import java.util.StringTokenizer;

public class PROBLEMA4 extends ConsoleProgram{
}
String DELIMITERS = " .:;,1234567890";

    public void run(){
      String line = readLine("Write something:");
      String longest = longestWord(line);
      println("The longest word in \"" + line + "\" is \"" + longest + "\"" );
}

    public String longestWord(String line){
        StringTokenizer text = new StringTokenizer(line, DELIMITERS);
        String longest = "";
        while(text.hasMoreTokens()){
            String word = text.nextToken();
            if(longest.length() < word.length()) { // Si hi ha més paraules de la mateixa llargada, es queda amb la primera.
                longest = word;
            }
            return longest;
    }