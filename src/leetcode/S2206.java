package leetcode;

public class S2206 {
    public boolean divideArray(int[] nums) {
        int density[] = new int[500];
        for(int n: nums) {
            density[n-1]++;
        }
        for(int d: density) {
            if((d&1)==1) {
                return false;
            }
        }

        return true;

    }
}
