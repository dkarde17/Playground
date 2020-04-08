import java.util.Scanner;

public class FibonacciMatrixImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        do {
            System.out.println("Please enter the position that you want the fibonacci number for, starting from 0");
            System.out.println("Enter negative number for ");
            n = scanner.nextInt();
            int[][] baseMatrix = {{0, 1}, {1, 1}};
            int[][] f0f1Matrix = {{1}, {1}};
            int[][] resultMatrix = null;
            if (n < 0)
                System.exit(0);
            else if (n == 0 || n == 1) {
                resultMatrix = f0f1Matrix;
            } else resultMatrix = multiplyMatrices(raiseMatrixToThePower(baseMatrix, n-1), f0f1Matrix);
            System.out.println(n + "th fibonacci number = " + resultMatrix[1][0]);
            System.out.println();
        } while (n >= 0);
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        assert col1 == row2;
        int[][] res = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                int sum = 0;
                for (int k = 0; k < col1; k++)
                    sum += matrix1[i][k]*matrix2[k][j];
                res[i][j] = sum;
            }
        }
        return res;
    }

    private static int[][] raiseMatrixToThePower(int[][] matrix, int pow) {
        if (pow == 1)
            return matrix;
        else if (pow%2 == 0)
            return raiseMatrixToThePower(multiplyMatrices(matrix, matrix), pow/2);
        else return multiplyMatrices(raiseMatrixToThePower(multiplyMatrices(matrix, matrix), pow/2), matrix);
    }
}
