package Uebungsblatt2.Aufgabe1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Registermaschine {

    private Map<Integer, Integer> akku = new HashMap<>();
    private Map<Integer, Befehl> befehlsrregister;
    private int befehlszaehler;

    public Registermaschine(String dateiPfad) {
        this.befehlszaehler = 0;
        this.befehlsrregister = fileToBefehlsregister(dateiPfad);
    }

    private Map<Integer, Befehl> fileToBefehlsregister(String dateiPfad) {

        Map<Integer, Befehl> register = new HashMap<>();
        String filePath = new File("").getAbsolutePath();
        // System.out.println(filePath+dateiPfad);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath+dateiPfad))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                register.put(i,new Befehl(line));
                System.out.println("i = " + i+ "Befehl = "+ line);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return register;
    }


}
