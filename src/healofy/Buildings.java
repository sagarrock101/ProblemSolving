package healofy;

public class Buildings {

    public int totalSnowCoverage(int[] buildings) {
        int totalSnowCoverage = 0;
        for(int i = 1; i < buildings.length - 1; i++) {
           totalSnowCoverage += maxSnowCoverage(buildings, i);
        }
        return totalSnowCoverage;
    }
    //[2, 3, 0, 1, 4]
    /*      |
    *   |   |
    * | |   |
    * | |_| |
    * */

    public int maxSnowCoverage(int[] buildings, int idx) {
        int mxL = 0;
        int mxR = 0;
        int k = idx;
        for(int i = k; i < buildings.length - 1; i++) {
            if(buildings[i + 1] > mxR)
                mxR = buildings[i+1];
        }

        for(int j = k; j > 0; j--) {
            if(buildings[j - 1] > mxL)
                mxL = buildings[j-1];
        }
        int min = Math.min(mxL, mxR);
        if(buildings[k] > 0 && buildings[k] < min)
            min -= buildings[k];

        return min;
    }
}
