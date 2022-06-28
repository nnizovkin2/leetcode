package leetcode;

public class S2212 {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bobArrows = new int[12];
        int max = 0;
        int maxIndex = 0;
        boolean parityBit = true;
        int j = 0;
        int r = 1;
        int sum = 0;
        int arrowSum = 0;
        int sign = 1;
        while (j != 11) {
            int addEl = sign*(aliceArrows[j + 1] + 1);
            int w = sign*(j+1);
            bobArrows[j + 1] += addEl;
            sum += w;
            arrowSum += addEl;
            if (max < sum&&arrowSum <= numArrows) {
                max = sum;
                maxIndex = r;
            }
            parityBit = !parityBit;
            if (parityBit) {
                j = 0;
            } else {
                j = 1;
                while ((1 << (j - 1) & r) == 0) {
                    j++;
                }
            }
            sign = ((r ^ (1 << j)) > r)?1:-1;
            r ^= 1 << j;
        }

        bobArrows[11] = 0;
        arrowSum = 0;
        for (int i = 0; i < 11; i++) {
            if((1<<i&maxIndex)!=0) {
                bobArrows[i+1] = aliceArrows[i+1] + 1;
                arrowSum += bobArrows[i+1];
            }
        }
        bobArrows[0] = numArrows - arrowSum;

        return bobArrows;
    }
}
