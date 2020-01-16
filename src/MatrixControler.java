import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixControler {
    Scanner input = new Scanner(System.in);
    MatrixModel matrixA;
    MatrixModel matrixB;
    MatrixModel matrixC;
    public MatrixControler(){}
    public MatrixControler(int mA,int nA, int mB, int nB){
        matrixA = new MatrixModel(mA,nA);
        matrixB = new MatrixModel(mB,nB);
    }

    public void addMatrixElements(MatrixModel matrix){
        try {
            for (int i = 0; i < matrix.getRowSize(); i++) {
                for (int j = 0; j < matrix.getColumnsSize(); j++) {
                    System.out.println("Podaj liczbe:" + i + " " + j);
                    matrix.setMatrixElement(i, j, input.nextInt());
                }
            }
        }catch (InputMismatchException e){
            System.err.println("Unexpected input");
        }
    }

    public MatrixModel multiplyMatrix(MatrixModel matrixAi, MatrixModel matrixBi ){
        if(matrixAi.getColumnsSize() == matrixB.getRowSize()) {
            MatrixModel matrixC = new MatrixModel(matrixAi.getRowSize(),matrixBi.getColumnsSize());
            for(int i = 0; i < matrixAi.getRowSize();i++){
                for(int j = 0; j <  matrixBi.getColumnsSize(); j++){
                    for (int k = 0; k < matrixAi.getColumnsSize(); k++) {
                        matrixC.addMatrixElement(i,j ,matrixAi.getMatrixElement(i,k) * matrixBi.getMatrixElement(k,j));
                    }
                }
            }
            this.matrixC = matrixC;
            return matrixC;
        }else{
            System.err.println("Matrix size not compatible");
            return null;
        }

    }

    public void transposeMatrix(MatrixModel matrix){
        MatrixModel matrixT = new MatrixModel(matrix.getColumnsSize(),matrix.getRowSize());
        for (int i = 0; i < matrix.getRowSize();i++){
            for (int j = 0; j < matrix.getColumnsSize(); j++){
                matrixT.setMatrixElement(j,i,matrix.getMatrixElement(i,j));
            }
        }
        matrix.setMatrix(matrixT);
    }

    public void printMatrix(MatrixModel matrix){
            MatrixView matrixView = new MatrixView();
            matrixView.printMatrix(matrix);
    }

    public void run(){
        MatrixControler matrix = new MatrixControler();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Wybierz co chcesz zrobic:");
            System.out.println("1: Wprowadz macierze");
            System.out.println("2: Operacje arytmetyczne");
            System.out.println("3: Wyswietl macierze");
            System.out.println("4: Wyjscie z programu");
            int i = input.nextInt();
            while (i != 4) {
                if (i == 1) {
                    System.out.println("Podaj ilosc wierszy macierzy A");
                    int mA = input.nextInt();
                    System.out.println("Podaj ilosc kolumn macierzy A");
                    int nA = input.nextInt();
                    System.out.println("Podaj ilosc wierszy macierzy B");
                    int mB = input.nextInt();
                    System.out.println("Podaj ilosc kolumn macierzy B");
                    int nB = input.nextInt();

                    matrix = new MatrixControler(mA,nA,mB,nB);

                    System.out.println("Dodaj elementy macierzy A");
                    matrix.addMatrixElements(matrix.matrixA);
                    System.out.println("Dodaj elementy macierzy B");
                    matrix.addMatrixElements(matrix.matrixB);
                } else if (i == 2) {
                    System.out.println("Wybierz operacje:");
                    System.out.println("1: Transponuj macierze wejsciowe");
                    System.out.println("2: Pomnoz macierze wejsciowe");
                    System.out.println("3: Transponuj macierz wynikowa");
                    i = input.nextInt();
                    if(i == 1){
                        matrix.transposeMatrix(matrix.matrixA);
                        matrix.transposeMatrix(matrix.matrixB);
                    }else if(i == 2){
                        matrix.multiplyMatrix(matrix.matrixA, matrix.matrixB);
                    }else if(i == 3){
                        matrix.transposeMatrix(matrix.matrixC);
                    }
                } else if (i == 3) {
                    System.out.println("Wybierz jaka macierz chcesz wyswietlic");
                    System.out.println("1: Macierze wejsciowe");
                    System.out.println("2: Macierz wynikową");
                    i = input.nextInt();
                    if (i == 1) {
                        matrix.printMatrix(matrix.matrixA);
                        matrix.printMatrix(matrix.matrixB);
                    }else if(i == 2){
                        matrix.printMatrix(matrix.matrixC);
                    }
                }
                System.out.println("Wybierz co chcesz zrobic:");
                System.out.println("1: Wprowadz macierze");
                System.out.println("2: Operacje arytmetyczne");
                System.out.println("3: Wyswietl macierze");
                System.out.println("4: Wyjscie z programu");
                i = input.nextInt();
            }
            System.out.println("Exit...");
        }catch (InputMismatchException | NullPointerException e){
            System.err.println("Niedozowlone dzialanie");
        }

    }
}
