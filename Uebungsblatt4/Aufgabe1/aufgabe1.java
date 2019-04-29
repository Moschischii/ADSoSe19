package Uebungsblatt4.Aufgabe1;

import java.util.Arrays;

public class aufgabe1 {
    public static void main(String[] args) {

        int a[] = {-5,13,-32,7,-3,17,23,12,-35,19};

        mergeSort(a, 0,(a.length - 1));
        System.out.println("Ergebins Merge: " + Arrays.toString(a));

        // TODO: implement heapSort

    }

    public static void mergeSort(int a[], int f, int l) {

        if (f<l) {
            int m = (f+l+1)/2;
            mergeSort(a, f, m-1);
            mergeSort(a, m, l);
            merge(a, f, l, m);
        }

    }

    // TODO: add logging
    public static void merge(int a[], int f, int l, int m) {
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
    }
}