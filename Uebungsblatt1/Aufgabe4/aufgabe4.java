package Uebungsblatt1.Aufgabe4;

public class aufgabe4 {
    public static void main(String[] args) {
        int m = 0, n = 0;
        add(m,n);
        mult(m,n);
    }

    private static void add(int m, int n) {
        System.out.println("Matrix 1:");
        Matrix matrix1 = new Matrix(m,n);
        matrix1.init();
        matrix1.input();
        System.out.println("Matrix 2:");
        Matrix matrix2 = new Matrix(m,n);
        matrix2.init();
        matrix2.input();
        System.out.println("Add:");
        Matrix matrixNew = matrix1.add(matrix2);
        matrixNew.print();
    }

    private static void mult(int m, int n) {
        System.out.println("Matrix 1:");
        Matrix matrix1 = new Matrix(m,n);
        matrix1.init();
        matrix1.input();
        System.out.println("Matrix 2:");
        Matrix matrix2 = new Matrix(n,m);
        matrix2.init();
        matrix2.input();
        System.out.println("Mult:");
        Matrix matrixNew = matrix1.mult(matrix2);
        matrixNew.print();
    }
}