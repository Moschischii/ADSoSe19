package Uebungsblatt1.Aufgabe4;

import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private int m;
    private int n;
    private int[][] matrix;
    public long zeit;
    public long zaehler;

    Matrix(int m, int n) {
        this.zaehler = 0;
        this.zeit = 0;
        this.m = m;
        this.n = n;
        matrix = new int[m][n];
    }

    public void init() {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    public void initRandom() {
        Random rand = new Random();
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.matrix[i][j] = 3;
                // this.matrix[i][j] = rand.nextInt(10);
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.println("m:"+i+" n:"+j+" Wert:"+this.matrix[i][j]);
            }
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print("Wert für m:"+i+" n:"+j+" eingeben: ");
                int input = scanner.nextInt();
                this.matrix[i][j] = input;
            }
        }
    }

    public Matrix add(Matrix M) {
        this.zaehler = 0;
        if (M.m != this.m || M.n != this.n) {
            System.out.println("Matrix hat nicht die gleiche Größe!");
            return M;
        }
        else {
            Matrix out = new Matrix(this.m, this.n);
            out.zaehler = 0;
            out.zeit = 0;
            final long timeStart = System.currentTimeMillis();
            for (int i = 0; i < out.m; i++) {
                for (int j = 0; j < out.n; j++) {
                    out.zaehler ++;
                    out.matrix[i][j] = (M.matrix[i][j] + this.matrix[i][j]);
                }
            }
            final long timeEnd = System.currentTimeMillis();
            out.zeit = (timeEnd - timeStart);
            System.out.println("Time = " + out.zeit + " ms");
            System.out.println("Aufrufe = " + out.zaehler);
            return out;
        }
    }

    public Matrix mult(Matrix M) {
       if (this.n == M.m) {
           Matrix out = new Matrix(this.m,M.n);
           out.zaehler = 0;
           out.zeit = 0;
           final long timeStart = System.currentTimeMillis();
           for (int i = 0; i < out.m; i++) {
               for (int j = 0; j < out.n; j++) {
                   for (int k = 0; k < this.n; k++) {
                       out.zaehler++;
                       out.matrix[i][j] += (this.matrix[i][k] * M.matrix[k][j]);
                   }
               }
           }
           final long timeEnd = System.currentTimeMillis();
           out.zeit = (timeEnd - timeStart);
           System.out.println("Time = " + out.zeit + " ms");
           System.out.println("Aufrufe = " + out.zaehler);
           return out;
       }
       else {
           System.out.println("Matrix hat nicht die gleiche Größe!");
           return M;
       }
    }
}
