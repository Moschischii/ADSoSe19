package Uebungsblatt4.Aufgabe3;

import java.util.Arrays;

public class aufgabe3 {
    public static void main(String[] args) {

        int a[] = {-5,13,-32,7,-3,17,23,12,-35,19};

        countSort(a, -35, 19);
        System.out.println();
        System.out.println("Ergebins Count: " + Arrays.toString(a));
    }


    //TODO: fix bugs -> out of bounds
    private static void countSort(int a[], int n, int k) {

        int j = 1;
        int[] bin = new int[k+1];

        for (int i = 0; i <= k; i++)
            bin[i] = 0;

        for (int i = 0; i < n; i++)
            bin[a[i]]++;

        System.out.println("-------");
        System.out.println("Count Bin: " + Arrays.toString(bin));

        for (int i = 0; i < n; i++) {

            while (bin[j]==0)
                j++;

            a[i]=j;
            bin[j]--;
        }

    }
}