package Parcial21_22;

public class Cypher {

    private CharPair[] key;
    private int numPairs = 0;

    public Cypher(int initialSize){
        this.key = new CharPair[initialSize];
    }

    public boolean addPair(char from, char to){
        CharPair pair = new CharPair(from,to);
        for(int i = 0; i < this.numPairs; i++){
            if(pair.conflictsWith(this.key[i])){
                return false;
            }
        }
        if(this.numPairs == this.key.length){
            widenKey();
        }
        this.key[numPairs] = pair;
        numPairs += 1;
        return true;
    }

    public Cypher invert(){
        if(this.numPairs == 0){
            return null;
        }
        Cypher decode = new Cypher(this.key.length);
        for(int i = 0; i < this.key.length; i++){
            decode.key[i] = this.key[i].invert();
        }
        return decode;
    }

    public String encode(String input){
        String output = "";
        for( int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(encodeChar(c) != -1){
                output += (char) encodeChar(c);
            }else{
                return null;
            }
        }
        return output;
    }

    private int encodeChar(char c){
        if (c == ' ') {
            return ' ';
        }
        for(int i = 0; i < this.numPairs; i++){
            if(this.key[i].encode(c) != -1){
                return this.key[i].encode(c);
            }
        }
        return -1;
    }
    private void widenKey(){
        CharPair[] newKey = new CharPair[this.key.length * 2];
        for(int i = 0; i < this.numPairs; i++){
            newKey[i] = this.key[i];
        }
        this.key = newKey;
    }
}
