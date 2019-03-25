package Uebungsblatt1.Aufgabe1;

public class aufgabe1 {
    public static void main(String[] args) {

        for (int a = 30; a <= 40; a++) {
            for (int b = 30; b <= 40; b++) {
                System.out.print("a = "+ a +", b = "+ b);
                System.out.print(", ggT: " + ggT(a,b));
                System.out.print(", ggT rekursiv: " + ggTRec(a,b,0));
                System.out.print(", kgV: " + kgV(a,b));
                System.out.println(", a * b = " + a*b);
            }

        }
    }

    public static int ggT(int a, int b) {
        int r = 0;
        while (true) {
            r = a % b;
            a = b;
            b = r;
            if (r == 0)
                return a;
        }
    }

    public static int ggTRec(int a, int b, int r) {
        r = a % b;
        a = b;
        b = r;
        if (r == 0)
            return a;
        else
            return ggTRec(a,b,r);
    }

    public static int kgV(int a, int b) {
        int kgV = ( (a*b) / ggT(a,b) );
        return kgV;
    }
}