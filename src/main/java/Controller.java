import operation.GetMatrix;
import operation.MatrixMultiplier;

import java.io.IOException;

public class Controller {
    public void controller() throws IOException {
        double[][] matrixA = GetMatrix.getMatrixA("./rdb200/rdb200.mtx");
        double[][] matrixB = GetMatrix.getMatrixB("./Trefethen_200/Trefethen_200.mtx");
        long startTime = System.currentTimeMillis();

        new MatrixMultiplier(matrixA, matrixB);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Tiempo de ejecución: " + elapsedTime + " milisegundos");
    }


}

