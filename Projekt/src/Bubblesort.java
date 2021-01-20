/**
 * beinhaltet die Methode sortBubble(), die sortiert das Array mittels Bubblesort und gibt die Messwerte zurück
 *
 * @author Martin Düppenbecker
 * @version 1.0
 * @since 20.01.2021
 */

public class Bubblesort {
    public Bubblesort(){

    }

    /**
     *
     * @param zahlen
     * @return bubblesortMessungen[]
     *
     * Diese Funktion sortiert das Array und gibt die Messwerte zurück
     */
    public double[] sortBubble(int[] zahlen){
        double irerationsCnt = 0;
        double comptCnt = 0;
        double[] bubblesortMessungen = new double[4];

        //ab hier fängt das normale Program an
        int max = zahlen.length;
        int cnt = 0;
        int tmp;
        boolean sortiert = false;

        while (!sortiert){
            irerationsCnt++;
            sortiert = true;

            for (int j = 0; j < max - 1; j++) {
                irerationsCnt++;
                if (zahlen[j] > zahlen[j+1]){
                    comptCnt++;
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
        return bubblesortMessungen;
    }
}
