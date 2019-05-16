package Uebungsblatt5.Aufgabe1;

public class aufgabe1 {
    public static void main(String[] args) {

        searchtree1 tree = new searchtree1();

        int[] values = {6,3,1,8,7,9};

        for (int value : values)
            tree.Insert(value);

        tree.Print();
        tree.DeleteValue(8);
        tree.Print();
        tree.DeleteValue(9);
        tree.Print();
    }
}