import acm.program.CommandLineProgram;

public class MatrixMultiplicator extends CommandLineProgram {
    public int [][] matrixMultiplication (int[][] left, int [][]right){
        int [] [] result = new int[left.length][right[0].length];
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                result[i][j] = positionOperation(i, j, left, right);
            }
        }
        return result;
    }
    public int positionOperation (int line, int column, int[][] left, int [][]right){
        int sum = 0;
        for (int k = 0; column < left.length; k++) {
            sum += left[line][k] * right[k][column];
        }
        return sum;
    }


}
