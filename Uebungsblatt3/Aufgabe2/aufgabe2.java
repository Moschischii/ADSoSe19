package Uebungsblatt3.Aufgabe2;

import java.util.Arrays;

public class aufgabe2 {

    public static void main(String[] args) {
        int a[] = {-5,13,-32,7,-3,17,23,12,-35,19};

        int insert[] = insertionSort(a);
        System.out.println("Ergebins Insert: " + Arrays.toString(insert));
    }

    private static int[] insertionSort(int a[]) {
        int n = a.length;
        int i, j, key;

        for (j = 1; j < n; j++) {

            key = a[j];
            i = j-1;

            while (i >= 0 &&  a[i] > key) {
                a[i+1] = a[i];
                i = i-1;
            }

            a[i+1] = key;
            System.out.println("Array = " + Arrays.toString(a) + " bei Key = " + key);
        }

        return a;
    }
}