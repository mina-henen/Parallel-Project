import java.util.ArrayList;
import java.util.List;

public class ParallelThreadsCreator {
    public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result, int threadsN) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsN; i++) {
            rowMultiplyWorker task = new rowMultiplyWorker(result, matrix1, matrix2, i,threadsN);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            waitForThreads(threads);
        }
    }
    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
