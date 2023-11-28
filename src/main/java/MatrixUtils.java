import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {

    public static double[][] readMatrixFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            int numRows = 0;
            int numCols = 0;
            List<double[]> rows = new ArrayList<>();

            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                if (!line.trim().startsWith("%")) {
                    String[] values = line.split(" ");
                    int i = Integer.parseInt(values[0]) - 1;
                    int j = Integer.parseInt(values[1]) - 1;
                    double value = Double.parseDouble(values[2]);

                    numRows = Math.max(numRows, i + 1);
                    numCols = Math.max(numCols, j + 1);

                    while (rows.size() <= i) {
                        rows.add(new double[numCols]);
                    }

                    rows.get(i)[j] = value;
                }
            }

            double[][] matrix = new double[numRows][numCols];
            for (int i = 0; i < numRows; i++) {
                matrix[i] = rows.get(i);
            }

            return matrix;
        }
    }


    public static double[][] getMatrixA(String path) throws IOException {
        return readMatrixFromFile(path);
    }

    public static double[][] getMatrixB(String path) throws IOException {
        return readMatrixFromFile(path);
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static double[][] getSubMatrix(double[][] matrix, int startRow, int endRow) {
        double[][] subMatrix = new double[endRow - startRow][matrix[0].length];
        System.arraycopy(matrix, startRow, subMatrix, 0, endRow - startRow);
        return subMatrix;
    }
}
