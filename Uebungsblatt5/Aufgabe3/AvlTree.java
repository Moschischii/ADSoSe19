package Uebungsblatt5.Aufgabe3;

public class AvlTree {

    public AvlElem root = null;

    public int GetHeight(AvlElem elem) {
        if (elem == null)
            return -1;
        else
            return elem.height;
    }

    public void UpdateHeight(AvlElem elem) {
        elem.height = 1 + Math.max(GetHeight(elem.left),GetHeight(elem.right));
    }

    public void RotateLeft(AvlElem elem) {
        AvlElem b = elem.right;
        AvlElem elemleft = elem.left;
        int elemval = elem.val;
        elem.right = b.right;
        elem.left = b;
        elem.val = b.val;
        elem.height = b.height;
        b.right = b.left;
        b.left = elemleft;
        b.val = elemval;

        UpdateHeight(elemleft.left);
        UpdateHeight(elem);
    }

    public void RotateRight(AvlElem elem) {
        AvlElem b = elem.left;
        AvlElem elemright = elem.right;
        int elemval = elem.val;
        elem.left = b.left;
        elem.right = b;
        elem.val = b.val;
        elem.height = b.height;
        b.left = b.right;
        b.right = elemright;
        b.val = elemval;

        UpdateHeight(elem.right);
        UpdateHeight(elem);
    }

    public void DoubleRotationLeft(AvlElem elem) {
        RotateRight(elem.right);
        RotateLeft(elem);
    }

    public void DoubleRotationRight(AvlElem elem) {
        RotateLeft(elem.left);
        RotateRight(elem);
    }

    public void CheckRotationLeft(AvlElem elem) {
        if (elem != null) {
            if (elem.right != null) {
                if (GetHeight(elem.right) - GetHeight(elem.left) == 2) {
                    if (GetHeight(elem.right.left) > GetHeight(elem.right.right))
                        DoubleRotationLeft(elem);
                    else
                        RotateLeft(elem);
                }
                else
                    UpdateHeight(elem);
            }
            else
                UpdateHeight(elem);
        }
    }

    public void CheckRotationRight(AvlElem elem) {
        if (elem != null) {
            if (elem.left != null) {
                if (GetHeight(elem.left) - GetHeight(elem.right) == 2) {
                    if (GetHeight(elem.left.right) > GetHeight(elem.left.left))
                        DoubleRotationRight(elem);
                    else
                        RotateRight(elem);
                }
                else
                    UpdateHeight(elem);
            }
            else
                UpdateHeight(elem);
        }
    }

    public void Insert(int i) {
        if (root == null) {
            root = new AvlElem();
            root.height = 0;
            root.val = i;
            root.left = null;
            root.right = null;
        }
        else
            Insert(root, i);
    }

    private void Insert(AvlElem elem, int i) {
        if (i <= elem.val) {
            if (elem.left == null) {
                elem.left = new AvlElem();
                elem.left.height = 0;
                elem.left.val = i;
                elem.left.left = null;
                elem.left.right = null;
                UpdateHeight(elem);
            }
            else {
                Insert(elem.left, i);
                CheckRotationRight(elem);
            }
        }
        else {
            if (elem.right == null) {
                elem.right = new AvlElem();
                elem.right.height = 0;
                elem.right.val = i;
                elem.right.left = null;
                elem.right.right = null;
                UpdateHeight(elem);
            }
            else {
                Insert(elem.right, i);
                CheckRotationLeft(elem);
            }
        }
    }

    public void Delete(int i) {
        if (root != null)
            Delete(root, i, root);
    }

    private void Delete(AvlElem elem, int i, AvlElem parent) {
        // TODO: implement Delete
        if (elem == null)
            return; // value not in tree
        else if (elem.val == i) {
            DeleteElement(elem, parent);
            CheckRotationRight(elem);
            CheckRotationLeft(elem);
        }
        else if(elem.val > i) {
            Delete(elem.right, i, elem);
            CheckRotationRight(elem);
        }
        else {
            Delete(elem.left, i, elem);
            CheckRotationLeft(elem);
        }
    }

    // evtl return Element
    private void DeleteElement(AvlElem elem, AvlElem parent) {
        if (elem.left == null && elem.right == null) {
            // no childs
            if (parent.left == elem) {
                parent.left = null;
                elem = null;
            }
            else {
                parent.right = null;
                elem = null;
            }

            elem = null;
        }
        else {
            if (elem.left == null) {
                if (parent.left == elem) {
                    parent.left = elem.right;
                    elem = null;
                }
                else {
                    parent.right = elem.right;
                    elem = null;
                }
            }
            else if (elem.right == null) {
                if (parent.left == elem) {
                    parent.left = elem.left;
                    elem = null;
                }
                else {
                    parent.right = elem.left;
                    elem = null;
                }
            }
            else {
                // zwei nachfolger
                //TODO: implement case two successors
                AvlElem successor = SmallestElement(elem.right);
                SwapElemValue(elem, successor);
                DeleteElement(successor, FindParent(root, successor, null));
            }
        }
    }

    private AvlElem SmallestElement(AvlElem elem) {
        while (elem.left != null)
            elem = elem.left;

        return elem;
    }

    private void SwapElemValue(AvlElem a, AvlElem b) {
        int cache = b.val;
        b.val = a.val;
        a.val = cache;
    }

    private AvlElem FindParent(AvlElem start, AvlElem elem, AvlElem parent) {

        if (start == null)
            return null;
        else if (start == elem) {
            return parent;
        }
        else if(start.val > elem.val) {
            return FindParent(start.right, elem, start);

        }
        else {
            return FindParent(start.left, elem, start);
        }
    }
}
