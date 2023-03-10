import java.text.DecimalFormat;
import java.util.Date;

public class MatrixMultiplication {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        for (int i = 100; i < 1001; i+=100) {
            int[][] m1 = matrix.generate(i, i);
            int[][] m2 = matrix.generate(i, i);
            long sTime=0;
            int[][] serialResult = new int[m1.length][m2[0].length];
            for (int j = 0; j < 3; j++) {
                Date serialStart = new Date();
                serialResult = matrix.multiply(m1, m2);
                Date serialEnd = new Date();
                sTime += (serialEnd.getTime() - serialStart.getTime());
            }
            sTime/=3;
            System.out.println("For size = "+i);
            System.out.println("Serial Multiply Time taken in milli seconds: " + sTime);
            int[][] parallelResult = new int[m1.length][m2[0].length];
            double pTime=0;
            int p = 1;
            for (int j = 0; j < 3; j++) {
                Date parallelStart = new Date();
                ParallelThreadsCreator.multiply(m1, m2, parallelResult,p);
                Date parallelEnd = new Date();
                pTime+=(parallelEnd.getTime() - parallelStart.getTime());
            }
            pTime/=3;
            System.out.println("Parallel Multiply Time taken in milli seconds: " + pTime);
            double speedUp=Double.parseDouble(df.format((double)sTime/pTime));
            System.out.println("Speed up = " + speedUp);
            double efficiency = Double.parseDouble(df.format((speedUp/p)*100));
            System.out.println("Efficiency = " + efficiency + " %");
            System.out.println("Both results are the same : "+matrix.check(serialResult,parallelResult));
            System.out.println("-------------------------------------------------");
        }
    }
}
