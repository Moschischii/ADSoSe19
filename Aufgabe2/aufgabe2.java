package Aufgabe2;

import java.util.ArrayList;
import java.util.List;

public class aufgabe2 {
    public static void main(String[] args) {
        int k = 100;
        System.out.println("Sieb k = "+k+" Ergebnis: " +sieb(k).toString());
    }

    public static List sieb(int k) {
        ArrayList<Boolean> alleZahlen = new ArrayList<Boolean>();
        List result = new ArrayList<>();

        for (int i = 0; i <= k; i++)
            alleZahlen.add(i, true);

        for (int i = 2; i <= k; i++) {
            if (alleZahlen.get(i)) {
                int j = i;
                do {
                    j = j + i;
                    if (j <= k)
                        alleZahlen.set(j, false);

                } while (j <= k);
            }
        }

        for (int i = 2; i <= k - 1; i++) {
            if (alleZahlen.get(i))
                result.add(i);
        }

        return result;
    }
}