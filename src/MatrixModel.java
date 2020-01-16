public class MatrixModel {
    int[][] matrix;
    int columnSize;
    int rowSize;
    public MatrixModel(int m, int n){
        matrix = new int[m][n];
        this.columnSize = m;
        this.rowSize = n;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRowSize(){
        return rowSize;
    }

    public int getColumnsSize(){
        return columnSize;
    }
    public int getMatrixElement(int i, int j){
        return matrix[i][j];
    }
    public void setMatrixElement(int i, int j, int element) {
        this.matrix[i][j] = element;
    }
    public void addMatrixElement(int i, int j,int element){
        this.matrix[i][j] += element;
    }
    public void setMatrix(MatrixModel matrix){
        this.matrix = matrix.getMatrix();
    }

}
