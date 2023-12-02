package operation;
import Printer.*;

public class MatrixMultiplier {

    public MatrixMultiplier(double[][] matrixA, double[][] matrixB) {
        try {
            if (!canMultiply(matrixA, matrixB)) {
                System.out.println("No se puede realizar la multiplicación. El número de columnas de A no coincide con el número de filas de B.");
                return;
            }

            int numRowsA = matrixA.length;
            int numColsB = matrixB[0].length;

            double[][] result = new double[numRowsA][numColsB];

            multiplyMatrices(matrixA, matrixB, result);

            System.out.println("Resultado de la multiplicación de matrices:");
            PrintMatrix.printMatrix(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean canMultiply(double[][] matrixA, double[][] matrixB) {
        return matrixA[0].length == matrixB.length;
    }

    private static void multiplyMatrices(double[][] matrixA, double[][] matrixB, double[][] result) {
        int numRowsA = matrixA.length;
        MatrixMultiplierThread[] threads = new MatrixMultiplierThread[4];

        int partitionSize = numRowsA / threads.length;

        for (int i = 0; i < threads.length; i++) {
            int startRowA = i * partitionSize;
            int endRowA = (i == threads.length - 1) ? numRowsA : (i + 1) * partitionSize;

            double[][] subMatrixA = GetMatrix.getSubMatrix(matrixA, startRowA, endRowA);

            threads[i] = new MatrixMultiplierThread(subMatrixA, matrixB, result, startRowA);
            threads[i].start();
        }

        try {
            for (MatrixMultiplierThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
