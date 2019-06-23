package Uebungsblatt7;

public class aufgabe3 {
    public static void main(String[] args) {
        char[] gesucht = "DATEN".toCharArray();
        char[] gesamt = "ALGORITHMEN UND DATENSTRUKTUREN".toCharArray();

        naiveSuche(gesucht, gesamt);
        int count = boyermoore(gesucht, gesamt);
        System.out.println("Count: " + count);
    }

    private static void naiveSuche(char[] gesucht, char[] gesamt) {

        int M = gesucht.length;
        int N = gesamt.length;

        for (int i = 0; i <= (N - M); i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (gesamt[j + i] != gesucht[j])
                    break;
            }

            if (j == M)
                System.out.println("Muster gefunden: Index: " + i);
        }
    }

    private static int boyermoore(char[] gesucht, char[] gesamt) {
        int i, j, sizeOfAlphabet = 28;
        int[] shift = new int[sizeOfAlphabet];
        int n = gesamt.length;
        int m = gesucht.length;

        for (i = 0; i < sizeOfAlphabet; i++)
            shift[i] = m;

        for (i = 0; i < m; i++)
            shift[getIndex(gesucht[i])] = m - i - 1;

        int count = 0;

        j = i = m - 1;
        while (i < n) {
            if (gesamt[i] == gesucht[j]) {
                if (j == 0) {
                    count++;
                    i += m;
                    j = m - 1;
                } else {
                    i--;
                    j--;
                }
            } else {
                if (m - j > shift[getIndex(gesamt[i])]) {
                    i = i + m - j;
                } else {
                    i = i + shift[getIndex(gesamt[i])];
                }

                j = m - 1;
            }
        }

        return count;
    }

    private static int getIndex(char a) {

        if (a == ' ')
            return 26;

        if (a == ',')
            return 27;

        return ((int) a - 65);
    }
}