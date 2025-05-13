package codeinterviewquestions.matrixoperation;

public class MatrixOperations {

    public static void main(String[] args) {
        // Example matrix

        int[][] matrix = {

                {1, 2, 3, 4},

                {5, 6, 7, 8},

                {9, 10, 11, 12},

                {13, 14, 15, 16}

        };

    // Function call to print matrix in wave order

        printWaveOrder(matrix);
    }

//    Q155. Write a program in Java to print the elements of the matrix in Wave Order.
//        (The matrix can have different numbers of rows and columns).
    public static void printWaveOrder(int[][] matrix) {

        int rows = matrix.length;

        int cols = matrix[0].length;

        for (int col = 0; col < cols; col++) {

            if (col % 2 == 0) {

                // Even index columns: top to bottom

                for (int row = 0; row < rows; row++) {

                    System.out.print(matrix[row][col] + " ");
                }

            } else {

                // Odd index columns: bottom to top

                for (int row = rows - 1; row >= 0; row--) {

                    System.out.print(matrix[row][col] + " ");
                }

            }
        }
    }
}
