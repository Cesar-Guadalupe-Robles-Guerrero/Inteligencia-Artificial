package my.normalEquation;

public class LinearAlgebra {

    public LinearAlgebra() {
    } // Constructor

    public double[][] Multiplication(double[][] matrixA, double[][] matrixB) {
        int n = matrixA.length, m = matrixB[0].length;
        double[][] matrixAux = new double[n][m];

        if (matrixA[0].length == matrixB.length) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < matrixA[0].length; k++) {
                        matrixAux[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
        }
        return matrixAux;
    }

    public double[][] Transposed(double[][] matrix) {
        double[][] matrixAux = new double[matrix[0].length][matrix.length];
        for (int x = 0; x < matrix.length; x++)
            for (int y = 0; y < matrix[x].length; y++) matrixAux[y][x] = matrix[x][y];
        return matrixAux;
    }

    public double[][] Inverse(double[][] matrix) {
        double det = 1 / det(matrix);
        double[][] transposed = Transposed(Adj(matrix));
        int n = transposed.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) transposed[i][j] *= det;

        return transposed;
    }

    public double det(double[][] x) {
        int n = x.length;
        return switch (n) {
            case 2 -> (x[0][0] * x[1][1]) - (x[1][0] * x[0][1]);
            case 3 -> (x[0][0] * x[1][1] * x[2][2] + x[1][0] * x[2][1] * x[0][2] + x[2][0] * x[0][1] * x[1][2])
                    - (x[2][0] * x[1][1] * x[0][2] + x[1][0] * x[0][1] * x[2][2] + x[0][0] * x[2][1] * x[1][2]);
            default -> 0;
        };
    }

    public double[][] Adj(double[][] matrix) {
        int n = matrix.length, sign=-1;
        double[][] result = new double[n][n], aux = new double[n-1][n-1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sign*=-1;
                for (int k = 0; k < n; k++) {
                    if (k != i) {
                        for (int l = 0; l < n; l++) {
                            if (l != j) {
                                int x = k < i ? k : k - 1;
                                int y = l < j ? l : l - 1;
                                aux[x][y] = matrix[k][l];
                            }
                        }
                    }
                }
                result[i][j] = det(aux) * sign;
            }
        }
        return result;
    }
}