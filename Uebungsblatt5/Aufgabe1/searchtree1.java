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

    private void CheckAndDelete(tree_element1 current, tree_element1 before) {

        // System.out.println("Current Value: " + current.value + " Right: " + current.right.value + " Left: " + current.left.value);
        // System.out.println("Before Value: " + before.value + " Right: " + before.right.value + " Left: " + before.left.value);

        if (current.right == null && current.left == null) {

            if (before.right == current)
                before.right = null;
            else
                before.left = null;
        }
        else if (current.right != null && current.left == null) {
            if (before.right == current)
                before.right = current.right;
            else
                before.left = current.right;
        }
        else if (current.right == null) {
            if (before.right == current)
                before.right = current.left;
            else
                before.left = current.left;
        }
        else {
            // Knoten durch Knoten mit kleinstem Wert rechts ersetzen (Inorder-Nachfolger)

            tree_element1 smallestRight = current.right;
            tree_element1 currentSearch = current.right;

            while (currentSearch.right != null) {
                smallestRight = currentSearch.right;

                if (currentSearch.value < smallestRight.value)
                    smallestRight = currentSearch;

                currentSearch = currentSearch.right;
            }

            if (smallestRight != current.right)
                smallestRight.right = current.right;

            if (smallestRight != current.left)
                smallestRight.left = current.left;

            current.left = null;
            current.right = null;

            if (before.right == current)
                before.right = smallestRight;
            else
                before.left = smallestRight;

        }
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

    boolean Contains(Object o) {

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


    void DeleteValue(Object o) {

        tree_element1 current = root;
        tree_element1 before = null;

        while (current != null) {

            if (current.value == (int) o) {
                CheckAndDelete(current, before);
                break;
            }
            else {
                before = current;
                if ((int) o <= current.value)
                    current = current.left;
                else
                    current = current.right;
            }
        }
    }

    void Print() {
        Print(root);
        System.out.println();
    }
}
