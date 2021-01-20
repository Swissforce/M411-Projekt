/**
 * Diese Klasse beinhaltet das Main und eine Methode, die die Daten von dem dat-File in ein array umwandelt
 *
 * @author Martin Düppenbecker
 * @version 1.0
 * @since 20.01.2021
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class mainKlasse {

    /**
     * Main Klasse
     * @param args
     */
    public static void main(String[] args) {
        int[] zahlen = datEinlesen(10);

        System.out.println(Arrays.toString(zahlen));
    }

    /**
     *
     * @param groesse
     * @return int[] zahlen
     *
     * Diese Funktion liest die Daten eines der 3 Files ein und gibt sie in einem int Array zurück
     */
    private static int[] datEinlesen(int groesse){

        //Schaut, dass die Grösse korrekt ist
        if (groesse != 10 && groesse != 100 && groesse != 1000){
            System.out.println("Bitte Grösse 10, 100 oder 1000 angeben");
            return null;
        }

        int zaehler = 0;
        int[] zahlen = new int[groesse];

        //Falls das File an einem Falschem Path ist, deshalb try-catch
        try {
            //Kreiert ein File- & ein Scanner-Objekt
            File data = new File("Projekt\\Datafiles\\" + groesse + "Digits.dat");
            Scanner scanner = new Scanner(data);

            //geht durch das File durch und liest es in ein Array ein
            while (zaehler < groesse){
                zahlen[zaehler] = scanner.nextInt();
                zaehler++;
            }
        }
        catch (Exception e){
            System.out.println("Ein Fehler ist aufgetreten:");
            System.out.println(e.getMessage());
        }

        finally {
            return zahlen;
        }
    }


}
