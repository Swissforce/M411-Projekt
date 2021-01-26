/**
 * beinhaltet die Methode sortBubble(), die sortiert das Array mittels Bubblesort und gibt die Messwerte zurück
 *
 * @author Martin Düppenbecker
 * @version 1.0
 * @since 20.01.2021
 */

public class Bubblesort extends Sorter{
    public Bubblesort(){

    }

    /**
     * @param zahlen
     * @return double[] bubblesortMessungen
     *
     * Diese Funktion sortiert das Array und gibt die Messwerte zurück
     */

    public double[] sort(int[] zahlen){
        double irerationsCnt = 0;
        double comptCnt = 0;
        double timeCnt;
        double[] bubblesortMessungen = new double[4];

        //ab hier fängt das normale Program an
        int max = zahlen.length;
        int cnt = 0;
        int tmp;
        boolean sortiert = false;

        timeCnt = System.nanoTime();
        while (!sortiert){
            irerationsCnt++;
            sortiert = true;

            comptCnt++; //Schleifen machen +1, wenn sie hinein/hinaus gehen (ansichtsweise)
            for (int j = 0; j < max - 1; j++) {
                irerationsCnt++;
                comptCnt++; //für das for

                comptCnt++; //für das if
                if (zahlen[j] > zahlen[j+1]){
                    tmp = zahlen[j];
                    zahlen[j] = zahlen[j+1];
                    zahlen[j+1] = tmp;

                    sortiert = false;
                }
                cnt++;
            }
        }
        bubblesortMessungen[0] = irerationsCnt;
        bubblesortMessungen[1] = comptCnt;
        bubblesortMessungen[2] = System.nanoTime() - timeCnt;
        bubblesortMessungen[3] = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        return bubblesortMessungen;
    }
}
