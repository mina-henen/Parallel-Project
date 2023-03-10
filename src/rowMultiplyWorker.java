import java.util.ArrayList;

public class rowMultiplyWorker implements Runnable {

    private final int[][] result;
    private int[][] matrix1;
    private int[][] matrix2;
    private int[] rows;

    public rowMultiplyWorker(int[][] result, int[][] matrix1, int[][] matrix2, int p,int np) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        int n = matrix1.length/np;
        rows=new int[n];
        for (int i = 0; i < n; i++) {
            rows[i]= p*n+i;
        }
    }

    @Override
    public void run() {
        for (int row : rows) {
            for (int i = 0; i < matrix2[0].length; i++) {
                result[row][i] = 0;
                for (int j = 0; j < matrix1[row].length; j++) {
                    result[row][i] += matrix1[row][j] * matrix2[j][i];
                }
            }
        }
    }
}