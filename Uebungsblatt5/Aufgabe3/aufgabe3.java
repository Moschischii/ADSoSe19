package Uebungsblatt5.Aufgabe3;

public class aufgabe3 {
    public static void main(String[] args) {

        AvlTree tree = new AvlTree();

        // Insert
        int[] values = {5, 6, 9, 12, 13, 3, 8, 10, 11, 16, 15, 14, 7, 4, 2, 1};

        for (int value : values)
            tree.Insert(value);

        // Delete
        int[] deletes = {12,8,5,4,3,6,15,14};

        for (int delete : deletes)
            tree.Delete(delete);

    }
}