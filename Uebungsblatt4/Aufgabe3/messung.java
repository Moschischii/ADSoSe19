package Uebungsblatt4.Aufgabe3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class messung {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++)
            messungStarten();

    }

    private static void messungStarten() {

        Random random = new Random();
        int size = random.nextInt(1000000);

        System.out.println("------------");
        System.out.println("Größe des Feldes: " + size);

        int[] a = new int[size];

        for (int i = 0; i < a.length; i++) {
            int content = 0;

            while (content > 10000 || content < 1000)
                content = random.nextInt(10000);

            a[i] = content;
        }

        int[] b = Arrays.copyOf(a,a.length);
        int[] c = Arrays.copyOf(a,a.length);
        long timeStart, timeEnd, zeitCount, zeitHeap, zeitMerge, schnellsteZeit;

        timeStart = System.currentTimeMillis();
        countSort(a,(a.length),1000);
        timeEnd = System.currentTimeMillis();
        zeitCount = (timeEnd - timeStart);
        // System.out.println("Zeit: " + zeitCount + " Count: " + Arrays.toString(a));
        System.out.println("Zeit: " + zeitCount + " Count");

        timeStart = System.currentTimeMillis();
        mergeSort(b,0,(b.length-1));
        timeEnd = System.currentTimeMillis();
        zeitMerge = (timeEnd - timeStart);
        // System.out.println("Zeit: " + zeitMerge + " Merge: " + Arrays.toString(b));
        System.out.println("Zeit: " + zeitMerge + " Merge");

        timeStart = System.currentTimeMillis();
        heapSort(c, 0, (c.length-1));
        timeEnd = System.currentTimeMillis();
        zeitHeap = (timeEnd - timeStart);
        // System.out.println("Zeit: " + zeitHeap + " Heap: " + Arrays.toString(c));
        System.out.println("Zeit: " + zeitHeap + " Heap");

        if (zeitCount < zeitHeap) {
            schnellsteZeit = zeitCount;
        }
        else
            schnellsteZeit = zeitHeap;

        if (zeitMerge < schnellsteZeit)
            schnellsteZeit = zeitMerge;

        System.out.println("Schnellste Zeit: " + schnellsteZeit);
        System.out.println("------------");
        System.out.println(" ");
    }

    /*
     * Count Sort
     */

    private static void countSort(int[] a, int n, int smallest) {

        int j = smallest;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(a[i]))
                map.replace(a[i],(map.get(a[i])+1));
            else
                map.put(a[i],1);
        }

        for (int i = 0; i < n; i++) {

            while (!map.containsKey(j) || map.get(j)==0)
                j++;

            a[i]=j;
            map.replace(j,(map.get(j)-1));
        }
    }

    /*
     * Heap Sort
     */

    private static void heapSort(int[] a, int f, int l) {
        buildheap(a, f, l);
        for (int i = l; i > f; i--) {
            // swap
            int old = a[f];
            a[f] = a[i];
            a[i] = old;

            heapify(a, f, i-1, f);
        }
    }

    private static void buildheap(int[] a, int f, int l) {
        int n = l-f+1;
        for (int i = (f + (n-2)/2); i >= f; i--) {
            heapify(a, f, l ,i);
        }
    }

    private static void heapify(int[] a, int f, int l, int root) {
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
    }
}
