package Uebungsblatt5.Aufgabe1;

class tree_element1 {

    int value;
    tree_element1 left;
    tree_element1 right;


    public void printElement() {

        System.out.print("Value: " + value);

        if (left != null)
            System.out.print(" Left: " + left.value);
        else
            System.out.print(" Left: null");

        if (right != null)
            System.out.println(" Right: " + right.value);
        else
            System.out.println(" Right: null");

    }

}
