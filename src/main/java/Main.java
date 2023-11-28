import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MatrixUtils utils = new MatrixUtils();
        double[][] matrixA = utils.getMatrixA("./rdb200/rdb200.mtx");
        double[][] matrixB = utils.getMatrixB("./Trefethen_200/Trefethen_200.mtx");

        new MatrixMultiplier(matrixA, matrixB);
    }
}
