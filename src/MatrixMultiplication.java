import java.util.Date;

public class MatrixMultiplication {
    public static void main(String[] args) {
        for (int i = 100; i < 1001; i+=100) {
            int[][] m1 = matrix.generate(i, i);
            int[][] m2 = matrix.generate(i, i);
            Date serialStart = new Date();
            int[][] serialResult = matrix.multiply(m1, m2);
            Date serialEnd = new Date();
            System.out.println("For size = "+i);
            System.out.println("Serial Multiply Time taken in milli seconds: " + (serialEnd.getTime() - serialStart.getTime()));
            int[][] parallelResult = new int[m1.length][m2[0].length];
            Date parallelStart = new Date();
            ParallelThreadsCreator.multiply(m1, m2, parallelResult);
            Date parallelEnd = new Date();
            System.out.println("Parallel Multiply Time taken in milli seconds: " + (parallelEnd.getTime() - parallelStart.getTime()));
        }

    }
}
