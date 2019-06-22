package Uebungsblatt7;

public class aufgabe3 {
    public static void main(String[] args) {
        char[] gesucht = "DATEN".toCharArray();
        char[] gesamt = "ALGORITHMEN UND DATEN- STRUKTUREN".toCharArray();

        naiveSuche(gesucht, gesamt);
    }

    private static void naiveSuche(char[] gesucht, char[] gesamt) {

        int M = gesucht.length;
        int N = gesamt.length;

        for (int i = 0; i <= (N - M); i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (gesamt[j+i] != gesucht[j])
                    break;
            }

            if (j == M)
                System.out.println("Muster gefunden: Index: " + i);
        }
    }
}