import acm.program.ConsoleProgram;

public class RemoveSpaces extends ConsoleProgram {

    public void run (){
        String str = "H o l a, com va?";
        String result = removeSpaces(str);
        println(result);
    }
}
    public String removeSpaces (String str){
        char[] strChar = str.toCharArray();
        char[] result = new char[str.length()];
        int indexResult = 0;
        for (int i = 0; i < str.length(); i++){
            if (strChar[i] != ' '){
                result [indexResult] = strChar[i];
                indexResult += 1;
            }
        }
        return new String(result);
    }


