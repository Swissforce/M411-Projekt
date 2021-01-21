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
     * @param args
     *
     * Ist das Main, von wo die Methoden ausgeführt werden
     */
    public static void main(String[] args) {

        int[] origZahlen = datEinlesen(1000);
        int[] zahlen = origZahlen;

        // --Sarah
        System.out.println("Gnomesort: \n");
        Gnomesort gnomesort = new Gnomesort();
        ausgabeMesswerte(gnomesort.sortGnome(zahlen));

        zahlen = origZahlen;


        /* --Jonas
        System.out.println("Shakersort: \n");
        Shakersort shakersort = new Shakersort();
        ausgabeMesswerte(shakersort.sort(zahlen));

        zahlen = origZahlen;

         */


        // --Martin
        System.out.println("Bubblesort: \n");
        Bubblesort bubblesort = new Bubblesort();
        ausgabeMesswerte(bubblesort.sortBubble(zahlen));

        zahlen = origZahlen;


        // --Martin
        System.out.println("Quicksort: \n");
        Quicksort quicksort = new Quicksort();
        ausgabeMesswerte(quicksort.sortQuick(zahlen));


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

    /**
     *
     * @param messwerte
     *
     * Diese Funktion printet die Messwerte anschaulich aus. Sort Methode als Parameter nehmen (weil es die Messwerte return)
     * und man so keine unnötige Variable braucht
     */
    private static void ausgabeMesswerte(double[] messwerte){
        System.out.println("Iteration Count: " + (int)messwerte[0]);
        System.out.println("Comparision Count: " + (int)messwerte[1]);

        if (messwerte[2] == 0.0 && messwerte[3] == 0.0){
            System.out.println("Time Count: " + "nicht gemessen");
            System.out.println("Memory Count: " + "nicht gemessen");
        }
        else {
            System.out.println("Time Count: " + messwerte[2]);
            System.out.println("Memory Count: " + messwerte[3]);
        }
        System.out.println("\n");
    }
}
