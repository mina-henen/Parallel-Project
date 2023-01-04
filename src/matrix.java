import java.util.Random;

public class matrix {
    public static int[][] generate(int rows, int columns) {
        int[][] mat = new int[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                mat[i][j] = random.nextInt(100) * 10;
        return mat;
    }
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int resultRows = matrix1.length;
        int resultColumns = matrix2[0].length;
        int[][] result = new int[resultRows][resultColumns];
        int columns2 = matrix2[0].length;
        for (int i = 0; i < resultRows; i++) {
            for (int j = 0; j < columns2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < resultColumns; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static boolean check(int[][] r1,int[][] r2){
        for (int i = 0; i < r1.length; i++) {
            for (int j = 0; j < r1[0].length; j++) {
                if (r1[i][j]!=r2[i][j])
                    return false;
            }
        }
        return true;
    }
}
