public class MatrixView {
    public void printMatrix(MatrixModel matrix) {
        for (int i = 0; i < matrix.getRowSize(); i++) {
            for (int j = 0; j < matrix.getColumnsSize(); j++) {
                System.out.print(matrix.getMatrixElement(i, j) + " ");
            }
            System.out.println();
        }
    }
}
