import acm.program.*;
public class PROBLEMA5 extends CommandLineProgram{

    public void run (){
        int[][] left = new int[][] {{1, 2, 3}, {4, 5 , 6}, {7, 8, 9}};
        int[][] right = new int[][] {{1, 2, 3}, {4, 5 , 6}, {7, 8, 9}};

        int[][] result = matrixMultiplication(left, right);
        println(result);
    }
    public int[][] matrixMultiplication(int[][] left, int[][] right){

        int fR = left.length; //filesResultant
        int cR = right[0].length; //columnesResultant
        int [][] m = new int[fR][cR];

        for ( int i = 0 ; i < fR; i++){
            for ( int j = 0 ; j < cR ; j++){
                m[i][j] = calcMM(left, right, i, j);
            }
        }
    return(m);
    }

    public int calcMM(int[][]left, int[][]right, int i, int j){
        int val = 0;

        for(int k=0 ; k < right.length ; k++){
            val += left[i][k] * right[k][j];

        }
    return(val);
    }

    public void println(int[][] matrix) {
        print("{");

        for (int i = 0; i < matrix.length; ++i) {

            print("{");

            for (int j = 0; j < matrix[i].length; ++j) {

                print(matrix[i][j]);

                if ( j != matrix[i].length-1) {

                    print(", ");

                }

            }

            print("}");

            if ( i != matrix.length-1) {

                print(", ");

            }

        }

        println("}");
    }
    public static void main (String[] args) {
        new PROBLEMA5().start(args);
    }
}

