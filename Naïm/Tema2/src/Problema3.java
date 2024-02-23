import acm.program.ConsoleProgram;

public class Problema3 extends ConsoleProgram {

    int LETTERS = ('z'-'a') + 1;

    public void run(){

        String message = readLine("Write a message for it to be encoded:");
        int distance = readInt("Select the key:");
        String encoded = encodeCaesar(message,realDistance(distance));
        println("The encoded message is: " + encoded );
        println("The plaintext message is: " + encodeCaesar(encoded,realDistance(-distance)));

    }

    public String encodeCaesar(String message, int distance){
        char[] chars = message.toCharArray();

        for(int i = 0; i < chars.length; i++){
            chars[i] = (char) (newCharPosition(chars[i],distance));
        }
        return new String(chars);
    }

    public boolean isLower(char ch){
        return 'a' <= ch && ch <= 'z';
    }
    public boolean isUpper(char ch){
        return 'A' <= ch && ch <= 'Z';
    }
    public int realDistance(int distance){
        int realDistance = distance % LETTERS;
        if(realDistance < 0){
            realDistance += LETTERS;
        }
        return realDistance;
    }
    public int newCharPosition(char ch, int distance){
        int position = ch + distance;
        if(isLower(ch) && position > 'z' ) {
            return ('a' - 1) + (position - 'z');
        }
        if(isUpper(ch) && position > 'Z'){
            return ('A'- 1) + (position - 'Z');
        }
        if(isUpper(ch) || isLower(ch)){
            return position;
        }
        return ch;
    }
}

