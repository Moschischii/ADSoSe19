package Uebungsblatt2.Aufgabe1;

public class Befehl {

    private String name;
    private int adresse;

    public Befehl(String befehl) {

        String [] words = befehl.split(" ", 2);
        this.name = words[0];
        this.adresse = Integer.parseInt(words[1]);
    }

    public boolean isEnd() {
        if (this.name.equals("HLT") && this.adresse == 99)
            return true;
        else
            return false;
    }

    public String getName() {
        return this.name;
    }

    public int getAdresse() {
        return this.adresse;
    }
}
