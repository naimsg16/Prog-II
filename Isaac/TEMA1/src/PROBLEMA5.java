import acm.program.*;
public class PROBLEMA5 extends CommandLineProgram{

    public void run (){
        int[][] left = new int[][] {{1, 2, 3}, {4, 5 , 6}, {7, 8, 9}};
        int[][] right = new int[][] {{1, 2, 3}, {4, 5 , 6}, {7, 8, 9}};

        int[][] result = matrixMultiplication(left, right);
        println(result);
    }
    public int[][] matrixMultiplication(int[][] left, int[][] rigth){

        int fR = left.lenght; //filesResultant
        int cR = right[0].lenght; //columnesResultant
        int [][] m = new int[fR][cR];

        for ( int i = 0 ; i < fR; i++){
            for ( int j = 0 ; j < cR ; j++){
                m[i][j] = calc MM(left, right, i, j);
            }
        }
    return(m);
    }

    public int [][] calc MM(int[][]left, int[][]right, int i, int j){
        int valor = 0;

        for(int k=0 ; k < right.lenght ; k++){
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
}

