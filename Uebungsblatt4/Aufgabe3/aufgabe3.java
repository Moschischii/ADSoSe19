package Uebungsblatt4.Aufgabe3;

import java.util.Arrays;
import java.util.HashMap;

public class aufgabe3 {
    public static void main(String[] args) {

        int[] a = {-5,13,-32,7,-3,17,23,12,-35,19};  // auch negative Werte erlaubt

        countSort(a, a.length, -35);
        System.out.println();
        System.out.println("Ergebins Count: " + Arrays.toString(a));
    }


    private static void countSort(int[] a, int n, int smallest) {

        int j = smallest;
        // int k = biggest; // wird nicht mehr benötigt

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i]))
                map.replace(a[i],(map.get(a[i])+1));
            else
                map.put(a[i],1);
        }

        System.out.println("-------");
        System.out.println("Count Bin: " + map.toString());

        for (int i = 0; i < n; i++) {

            while (!map.containsKey(j) || map.get(j)==0)
                j++;

            a[i]=j;
            map.replace(j,(map.get(j)-1));
        }

    }
}