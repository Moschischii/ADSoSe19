package Uebungsblatt1.Aufgabe4;

import java.util.Scanner;

public class aufgabe4 {
    public static void main(String[] args) {
        System.out.print("Startgröße der Matrix eingeben: ");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = m;

        System.out.print("Automatisiert? Ja/Nein: ");
        String auto = scanner.next();

        if (auto.equals("Ja")) {

            System.out.print("Maximale Zeit in sek eingeben: ");
            int maxTime = scanner.nextInt();
            System.out.println("Start - Dauer maximal "+maxTime+" sek");
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