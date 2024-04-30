import acm.program.*;
public class PROBLEMA6 extends DialogProgram{

    public void run(){
        String str = readLine("ESCRIU UNA CADENA DE CARÀCTERS:");
        String resultat = removeExtremes(str);
        println (resultat);

    }

    public String removeExtremes ( String str ){

            char[] chars = str.toCharArray();

            if(chars.length <= 2){

                return "El string está vacío o solamente consiste en un caràcter";
                // return ""; string buida, no importe
            }

            return new String (chars, 1, chars.length - 2); //la agafem en la posicio 1 i la llargada de caracters menys 2

        }
    public static void main (String[] args) {
        new PROBLEMA6().start(args);
    }

    }

