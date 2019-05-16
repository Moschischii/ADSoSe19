package Uebungsblatt5.Aufgabe1;

public class searchtree1 {

    private tree_element1 root;

    searchtree1() {
        // DeleteTree(root);
        root = null;
    }

    private void Insert(tree_element1 currentRoot, tree_element1 element1) {

        if (element1.value <= currentRoot.value) {
            if (currentRoot.left == null)
                currentRoot.left = element1;
            else
                Insert(currentRoot.left, element1);
        }
        else {
            if (currentRoot.right == null)
                currentRoot.right = element1;
            else
                Insert(currentRoot.right, element1); }

    }

    private void DeleteTree(tree_element1 root) {

        if (root != null) {
            if (root.left != null)
                DeleteTree(root.left);
            if (root.right != null)
                DeleteTree(root.right);

            root = null;
        }

    }

    private void Print(tree_element1 root) {

        if (root != null) {
            System.out.print("(");
            Print(root.left);
            System.out.print("," + root.value + ",");
            Print(root.right);
            System.out.print(")");
        }
        else
            System.out.print("n");

    }

    void Insert(Object o) {

        tree_element1 element = new tree_element1();
        element.value = (int)o;
        element.left = null;
        element.right = null;

        if (root==null)
            root=element;
        else
            Insert(root, element);

    }

    public boolean Contains(Object o) {

        tree_element1 current = root;

        while (current != null) {

            if (current.value == (int) o)
                return true;
            else {

                if ((int) o <= current.value)
                    current = current.left;
                else
                    current = current.right;
            }
        }

        return false;
    }


    public void DeleteValue(Object o) {

    }

    void Print() {
        Print(root);
        System.out.println();
    }
}
