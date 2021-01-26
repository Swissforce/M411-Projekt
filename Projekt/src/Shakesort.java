/**
 * Diese Klasse sortiert ein Array aufsteigen mittels Shakesort.
 *
 * @author Jonas Rhbary
 * @version 1.5
 * @since 20.01.2021
 */

public class Shakesort {

    /**
     * Default konstruktor
     */
    public Shakesort() {
    }

    /**
     * Diese Methode sortiert das gegebene Array mit dem Shakesort. Dieser funktioniert folgenderweise, beim ersten Durchgang
     * speichert er die erste Zahl in die Variabel i. Dann vergleicht er jede Zahl danach und schaut, ob diese grösser ist.
     * Die grösste Zahl wird dann so oft geswapt, bis es am ende des Arrays ankommt und lässt die Zahl dort. Danach passiert
     * genau das Gleiche, einfach umgekehrt. Die kleinste Zahl wird in die Variabel j gespeichert und wird so oft geswapt
     * bis diese Zahl wieder am anfang des Arrays ankommt und lässt die dort. Dieses Prozedere wird so oft wiederholt, bis
     * alle Zahlen sortiert sind.
     *
     * @param zahlen
     * @return messArray[]
     */
    public static double[] sort(int[] zahlen) {
        double iterationCnt = 0; //Anz. Durchgänge durch while-Schleife
        double compCnt = 0;   //Anz. benötigte Vergleiche
        double memoryCnt = 0;
        double timeCnt = 0;
        double[] messArray = new double[4]; //[0]:iterationCntr, [1]:compCntr, [2]:timeCntr, [3]: memoryCntr

        double start = System.nanoTime();

        for (int i = 0; i < zahlen.length/2; i++) {
            compCnt++; iterationCnt++;
            boolean swapped = false;
            for (int j = i; j < zahlen.length - i - 1; j++) {
                    iterationCnt++; compCnt++;
                if (zahlen[j] < zahlen[j+1]) {
                    compCnt++;
                    int temp = zahlen[j];
                    zahlen[j] = zahlen[j+1];
                    zahlen[j+1] = temp;
                }
            }
            for (int j = zahlen.length - 2 - i; j > i; j--) {
                compCnt++; iterationCnt++;
                if (zahlen[j] > zahlen[j-1]) {
                    compCnt++;
                    int temp = zahlen[j];
                    zahlen[j] = zahlen[j-1];
                    zahlen[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }

        double finish = System.nanoTime();

        timeCnt =(finish - start);
        memoryCnt = Runtime.getRuntime().totalMemory();

        messArray[0] = iterationCnt;
        messArray[1] = compCnt;
        messArray[2] = timeCnt;
        messArray[3] = memoryCnt;

        return messArray;

    }
}
