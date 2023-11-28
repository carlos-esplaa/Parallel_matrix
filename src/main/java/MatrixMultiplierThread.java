public class MatrixMultiplierThread extends Thread {
    private final double[][] matrixA;
    private final double[][] matrixB;
    private final double[][] result;
    private final int startRow;

    public MatrixMultiplierThread(double[][] matrixA, double[][] matrixB, double[][] result, int startRow) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.startRow = startRow;
    }

    @Override
    public void run() {
        int numRowsA = matrixA.length;
        int numColsA = matrixA[0].length;
        int numColsB = matrixB[0].length;

        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                result[startRow + i][j] = 0.0;
                for (int k = 0; k < numColsA; k++) {
                    result[startRow + i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }
}
