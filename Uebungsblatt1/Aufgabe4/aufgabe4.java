package Uebungsblatt1.Aufgabe4;

public class aufgabe4 {
    public static void main(String[] args) {
        int m = 2000, n = 2000;
        int maxTime = 60; // max time in sek
        System.out.println("Start");

        while (true) {
            long multTime = mult(m,n);
            System.out.println("M = " + m + " N = " + n + " Zeit = " + (multTime/1000) + " sek");
            if (multTime/1000 > maxTime) {
                System.out.println("Ergebnis Mult: M = " + m + " N = " + n + " Zeit = " + (multTime/1000) + " sek");
                break;
            }
            m = m + 10;
            n = n + 10;
        }

        long addTime = add(m,n);
        long multTime = mult(m,n);
        System.out.println("Ergebnis Add: M = " + m + " N = " + n + " Zeit = " + (addTime/1000) + " sek");
        System.out.println("Ergebnis Mult: M = " + m + " N = " + n + " Zeit = " + (multTime/1000) + " sek");
        System.out.println("End");
    }

    private static long add(int m, int n) {
        Matrix matrix1 = new Matrix(m,n);
        matrix1.initRandom();
        Matrix matrix2 = new Matrix(m,n);
        matrix2.initRandom();
        Matrix matrixNew = matrix1.add(matrix2);
        return matrixNew.zeit;
    }

    private static long mult(int m, int n) {
        Matrix matrix1 = new Matrix(m,n);
        matrix1.initRandom();
        Matrix matrix2 = new Matrix(n,m);
        matrix2.initRandom();
        Matrix matrixNew = matrix1.mult(matrix2);
        return matrixNew.zeit;
    }
}