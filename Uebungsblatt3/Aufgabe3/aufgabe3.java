package Uebungsblatt3.Aufgabe3;

import java.util.Arrays;

public class aufgabe3 {

    public static void main(String[] args) {
        int a[] = {-5,13,-32,7,-3,17,23,12,-35,19};
        int b[] = {-5,13,-32,7,-3,17,23,12,-35,19};
        int c[] = {-5,13,-32,7,-3,17,23,12,-35,19};

        insertionSort(a);
        System.out.println("Ergebins Insert: " + Arrays.toString(a));

        /*
        bubbleSort(b);
        System.out.println("Ergebins Bubble: " + Arrays.toString(b));

        selectionSort(c);
        System.out.println("Ergebins Selection: " + Arrays.toString(c));
        */
    }

    private static void insertionSort(int a[]) {
        int n = a.length;
        int i, j, key;

        for (j = n-1; j >= 0; j--) {

            key = a[j];
            i = j+1;

            while (i < n &&  a[i] < key) {
                a[i-1] = a[i];
                i = i+1;
            }

            a[i-1] = key;
            System.out.println("Array = " + Arrays.toString(a) + " bei Key = " + key);
        }
    }

    // TODO: Maximum soll nach hinten wandern
    private static void bubbleSort(int a[]) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = n-2; j >= i; j--) {
                System.out.println("Array = " + Arrays.toString(a));
                if (a[j] > a[j+1]) {
                    int h = a[j];
                    a[j] = a[j+1];
                    a[j+1] = h;
                    System.out.println("Tausche " + h +" und " + a[j]);
                }
            }
        }
    }

    // TODO: Auswahl ueber Maximum
    private static void selectionSort(int a[]) {
        int n = a.length;

        int i, j, min;
        for (i = 0; i < n; i++) {
            min = i;
            for (j = i; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            int h = a[i];
            a[i] = a[min];
            a[min] = h;
            System.out.println("Array = " + Arrays.toString(a) + " Tausche " + h +" und " + a[i]);
        }
    }
}