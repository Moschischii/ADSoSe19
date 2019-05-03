package Uebungsblatt4.Aufgabe1;

import java.util.Arrays;

public class aufgabe1 {
    public static void main(String[] args) {

        int a[] = {-5,13,-32,7,-3,17,23,12,-35,19};
        int b[] = {-5,13,-32,7,-3,17,23,12,-35,19};

        mergeSort(a, 0,(a.length - 1));
        System.out.println();
        System.out.println("Ergebins Merge: " + Arrays.toString(a));

        heapSort(b, 0,(b.length - 1));
        System.out.println();
        System.out.println("Ergebins Heap: " + Arrays.toString(b));
    }

    /*
     * Merge Sort
     */

    private static void mergeSort(int[] a, int f, int l) {

        if (f<l) {
            int m = (f+l+1)/2;
            mergeSort(a, f, m-1);
            mergeSort(a, m, l);
            merge(a, f, l, m);
        }

    }

    private static void merge(int[] a, int f, int l, int m) {
        int n = l-f+1;
        int a1f = f;
        int a1l = m-1;
        int a2f = m;
        int a2l = l;
        int[] anew = new int[n];

        for (int i = 0; i <n; i++) {
            if (a1f <= a1l) {
                if (a2f <= a2l) {
                    if (a[a1f] <= a[a2f])
                        anew[i] = a[a1f++];
                    else
                        anew[i] = a[a2f++];
                }
                else
                    anew[i] = a[a1f++];
            }
            else
                anew[i] = a[a2f++];
        }

        for (int i = 0; i < n; i++)
            a[f+i] = anew[i];

        System.out.println("-------");
        System.out.println("Merge: " + Arrays.toString(a));
    }

    /*
     * Heap Sort
     */

    private static void heapSort(int a[], int f, int l) {
        buildheap(a, f, l);
        for (int i = l; i > f; i--) {
            // swap
            int old = a[f];
            a[f] = a[i];
            a[i] = old;

            heapify(a, f, i-1, f);
        }
    }

    private static void buildheap(int a[], int f, int l) {
        int n = l-f+1;
        for (int i = (f + (n-2)/2); i >= f; i--) {
            heapify(a, f, l ,i);
        }
    }

    private static void heapify(int a[], int f, int l, int root) {
        int largest;
        int left = f+(root-f)*2+1;
        int right = f+(root-f)*2+2;

        if (left <= l && a[left] > a[root])
            largest = left;
        else
            largest = root;

        if (right <= l && a[right] > a[largest])
            largest = right;

        if (largest != root) {
            // swap
            int old = a[root];
            a[root] = a[largest];
            a[largest] = old;

            heapify(a, f, l, largest);
        }

        System.out.println("-------");
        System.out.println("Heapify: " + Arrays.toString(a));
    }
}