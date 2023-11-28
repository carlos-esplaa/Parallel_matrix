import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class ParallelMultiplicationTest {
    @Test
    public void testMatrixMultiplication1() {
        double[][] matrixA = {
                {2, 1, 5, 3},
                {0, 7, 1, 6},
                {9, 2, 4, 4},
                {3, 6, 7, 2}
        };

        double[][] matrixB = {
                {6, 1, 2, 3},
                {4, 5, 6, 5},
                {1, 9, 8, -8},
                {4, 0, -8, 5}
        };

        long startTime = System.currentTimeMillis();

        assertTimeout(Duration.ofSeconds(5), () -> {
            new MatrixMultiplier(matrixA, matrixB);
        });

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Tiempo de ejecución: " + executionTime + " milisegundos");
    }

    @Test
    public void testMatrixMultiplication2() {
        double[][] matrixA = {
                {2, 1, 5, 3, 54, 13},
                {0, 7, 1, 6, 5, 1},
                {9, 2, 4, 4, 6, 3},
                {3, 6, 7, 2, 12, 6},
                {5, 4, 7, 9, 4, 2},
                {8, 13, 24, 10, 5, 8}
        };

        double[][] matrixB = {
                {6, 1, 2, 3, 33, 5},
                {4, 5, 6, 5, 23, 2},
                {1, 9, 8, -8, 3, 8},
                {4, 0, -8, 5, 43, 12},
                {45, 34, 7, 19, 4, 1},
                {9, 1, 12, 74, 3, 73}
        };

        long startTime = System.currentTimeMillis();

        assertTimeout(Duration.ofSeconds(5), () -> {
            new MatrixMultiplier(matrixA, matrixB);
        });

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Tiempo de ejecución: " + executionTime + " milisegundos");
    }
}
