package Uebungsblatt2.Aufgabe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Registermaschine {

    private Map<Integer, Integer> akku;
    private Map<Integer, Befehl> befehlsrregister;
    private int befehlszaehler;

    public Registermaschine(String dateiPfad) {
        this.befehlszaehler = 0;
        this.befehlsrregister = fileToBefehlsregister(dateiPfad);
        this.akku = new HashMap<>();
        this.akku.put(0,0);
    }

    private Map<Integer, Befehl> fileToBefehlsregister(String dateiPfad) {

        Map<Integer, Befehl> register = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dateiPfad))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                register.put(i,new Befehl(line));
                // System.out.println("i = " + i+ " Befehl = "+ line);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return register;
    }

    public void startProgramm() {
        System.out.println("Start");
        Befehl aktuellerBefehl = this.befehlsrregister.get(befehlszaehler);
        while (!aktuellerBefehl.isEnd()) {
            befehlAusführen(aktuellerBefehl);
            befehlszaehler ++;
            aktuellerBefehl = this.befehlsrregister.get(befehlszaehler);
        }
        System.out.println("End");
    }

    private void befehlAusführen(Befehl befehl) {

        Integer f0Inhalt = this.akku.get(0);
        Integer fAdresse = befehl.getAdresse();
        Integer fAdresseInhalt = this.akku.get(fAdresse);

        // System.out.println("F0-Inhalt: " + f0Inhalt + " FAdresse-Inhalt: " + fAdresseInhalt + " Befehl: "+ befehl.getName() +" FAdresse: " + fAdresse);

        switch (befehl.getName()) {
                // Standardbefehle
            case "ADD":
                this.akku.put(0, (f0Inhalt + fAdresseInhalt));
                break;
            case "SUB":
                this.akku.put(0, (f0Inhalt - fAdresseInhalt));
                break;
            case "MUL":
                this.akku.put(0, (f0Inhalt * fAdresseInhalt));
                break;
            case "DIV":
                this.akku.put(0, (f0Inhalt / fAdresseInhalt));
                break;
            case "LDA":
                this.akku.put(0, fAdresseInhalt);
                break;
            case "LDK":
                this.akku.put(0, fAdresse);
                break;
            case "STA":
                this.akku.put(fAdresse, f0Inhalt);
                break;
            case "INP":
                this.akku.put(fAdresse, getInput());
                break;
            case "OUT":
                System.out.println("OUT: " + f0Inhalt);
                break;
                // Sprungbefehle
            case "JMP":
                befehlszaehler = fAdresse;
                break;
            case "JEZ":
                if (f0Inhalt == 0)
                    befehlszaehler = fAdresse;
                break;
            case "JNE":
                if (f0Inhalt != 0)
                    befehlszaehler = fAdresse;
                break;
            case "JLZ":
                if (f0Inhalt < 0)
                    befehlszaehler = fAdresse;
                break;
            case "JLE":
                if (f0Inhalt <= 0)
                    befehlszaehler = fAdresse;
                break;
            case "JGZ":
                if (f0Inhalt > 0)
                    befehlszaehler = fAdresse;
                break;
            case "JGE":
                if (f0Inhalt >= 0)
                    befehlszaehler = fAdresse;
                break;
             default:
                 System.out.println("Befehl nicht bekannt! ("+befehl.getName()+")");
        }
    }

    private Integer getInput() {
        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
