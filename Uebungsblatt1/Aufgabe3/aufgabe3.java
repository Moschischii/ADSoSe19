package Uebungsblatt1.Aufgabe3;

public class aufgabe3 {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(2,3);
        matrix.init();
        matrix.input();
        matrix.print();
        Matrix matrixNewAdd = matrix.add(matrix);
        matrixNewAdd.print();
        System.out.println("Mult new");
        Matrix matrixNewMult = matrix.mult(matrixNewAdd);
        System.out.println("Print Mult");
        matrixNewMult.print();
    }
}