import acm.program.ConsoleProgram;

public class RemoveSpaces extends ConsoleProgram{

    public void run (){
        removeSpaces();

    }
    public char [] removeSpaces (char [] chars){
        char [] result = new char [chars.lenght];
        for (int i; i < chars.length; i++){
            int j = 0;
            if(isSpace(chars[i])){
                i++;
            }else{
                result [j] = chars [i];
                j++;
            }
        }
        return result;
    }
    public boolean isSpace (char [] chars []){
        return chars [] = ' ';
    }

}