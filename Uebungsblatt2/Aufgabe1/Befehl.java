package Uebungsblatt2.Aufgabe1;

public class Befehl {

    private String name;
    private int adresse;

    public Befehl(String befehl) {

        if (!befehl.isEmpty()) {
            // System.out.println("Befehl: " + befehl);
            String [] words = befehl.split(" ", 2);
            // System.out.println("Word: " + words.toString());
            this.name = words[0];
            this.adresse = Integer.parseInt(words[1]);
        }
        else {
            // System.out.println("Befehl ist leer: " + befehl);
        }
    }

    public boolean isEnd() {
        if (this.name.equals("HLT") && this.adresse == 99)
            return true;
        else
            return false;
    }

    public String getName() {
        // TODO: Überprüfung ob Befehl bekannt
        return this.name;
    }

    public int getAdresse() {
        return this.adresse;
    }
}
