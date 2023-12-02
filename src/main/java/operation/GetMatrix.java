package operation;

import java.io.IOException;

import static Reader.Reader.readMatrixFromFile;

public class GetMatrix {

    public static double[][] getMatrixA(String path) throws IOException {
        return readMatrixFromFile(path);
    }

    public static double[][] getMatrixB(String path) throws IOException {
        return readMatrixFromFile(path);
    }


    public static double[][] getSubMatrix(double[][] matrix, int startRow, int endRow) {
        double[][] subMatrix = new double[endRow - startRow][matrix[0].length];
        System.arraycopy(matrix, startRow, subMatrix, 0, endRow - startRow);
        return subMatrix;
    }
}
