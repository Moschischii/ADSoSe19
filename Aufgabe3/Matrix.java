package Aufgabe3;

import java.util.Scanner;

public final class Matrix {

    final int m;
    final int n;
    final int[][] matrix;

    Matrix(int m, int n) {
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
                System.out.print("Wert für m:"+i+" n:"+j+" eingeben:");
                int input = scanner.nextInt();
                this.matrix[i][j] = input;
            }
        }
    }

    public Matrix add(Matrix M) {
        if (M.m != this.m || M.n != this.n) {
            System.out.println("Matrix hat nicht die gleiche Größe!");
            return M;
        }
        else {
            Matrix out = new Matrix(this.m, this.n);
            for (int i = 0; i < out.m; i++) {
                for (int j = 0; j < out.n; j++) {
                    out.matrix[i][j] = (M.matrix[i][j] + this.matrix[i][j]);
                }
            }
            return out;
        }
    }

    public Matrix mult(Matrix M) {
       if (this.m != M.n) {
           System.out.println("Matrix hat nicht die gleiche Größe!");
           return M;
       }
       else {
           Matrix out = new Matrix(this.m,M.n);
           for (int i = 0; i < out.m; i++) {
               for (int j = 0; j < out.n; i++) {
                   for (int k = 0; k < this.n; k++) {
                       out.matrix[i][j] += (this.matrix[i][k] * M.matrix[k][j]); //TODO: fix out ouf bounds
                   }
               }
           }
           return out;
       }
    }
}
