package Uebungsblatt1.Aufgabe3;

public class aufgabe3 {
    public static void main(String[] args) {
        add();
        mult();
    }

    private static void add() {
        System.out.println("Matrix 1:");
        Matrix matrix1 = new Matrix(2,3);
        matrix1.init();
        matrix1.input();
        System.out.println("Matrix 2:");
        Matrix matrix2 = new Matrix(2,3);
        matrix2.init();
        matrix2.input();
        System.out.println("Add:");
        Matrix matrixNew = matrix1.add(matrix2);
        matrixNew.print();
    }

    private static void mult() {
        System.out.println("Matrix 1:");
        Matrix matrix1 = new Matrix(2,3);
        matrix1.init();
        matrix1.input();
        System.out.println("Matrix 2:");
        Matrix matrix2 = new Matrix(3,2);
        matrix2.init();
        matrix2.input();
        System.out.println("Mult:");
        Matrix matrixNew = matrix1.mult(matrix2);
        matrixNew.print();
    }
}