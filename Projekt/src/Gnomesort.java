/**
 * Diese Klasse sortiert ein Array aufsteigen mittels Gnomesort.
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 20.01.2021
 */

public class Gnomesort extends Sorter{

    public Gnomesort() {

    }

    /**
     * Die Methode sortiert das übergebene Array aufsteigend, indem sie jeweils  von links nach rechts zwei aufeinanderfolgende,
     * vom Counter definierte Werte vergleicht. Wenn diese in der richtigen Reihenfolge sind, bewegt sich der Counter
     * einen Schritt nach rechts und vergleicht dort erneut. Falls die zwei verglichenen Werte jedoch in falscher
     * Reihenfolge stehen, werden diese getauscht und der Counter bewegt sich nach links und vergleicht dort wieder von neuem.
     *
     * @param array
     * @return int[] gnomesortMessungen
     */
    public double[] sort(int[] array) {

        double iterationCnt = 0; //Anz. Durchgänge durch while-Schleife
        double compCnt = 0;   //Anz. benötigte Vergleiche
        double timeCnt = 0;
        double memoryCnt = 0;
        double[] messArray = new double[4]; //[0]:iterationCntr, [1]:compCntr, [2]:timeCntr, [3]: memoryCntr

        int cntr = 0;
        int temp;

        double timeStart = System.nanoTime();

        while (cntr < array.length - 1) {
            iterationCnt++;

            compCnt++;
            if (array[cntr + 1] < array[cntr]) {

                //swap Beginn
                temp = array[cntr];
                array[cntr] = array[cntr + 1];
                array[cntr + 1] = temp;
                //swap Ende

                compCnt++;
                if (cntr > 0) {
                    cntr--;
                } else {
                    cntr++;
                }
            } else {
                cntr++;
            }

        }

        double timeEnd = System.nanoTime();
        timeCnt = timeEnd - timeStart;

        memoryCnt = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        messArray[0] = iterationCnt;
        messArray[1] = compCnt;
        messArray[2] = timeCnt;
        messArray[3] = memoryCnt;

        return messArray;
    }

}
