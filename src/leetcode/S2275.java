package leetcode;

public class S2275 {
    public int largestCombination(int[] candidates) {
        int[] r = new int[24];
        for(int c: candidates) {
            int i = 0;
            while(c!=0) {
                r[i]+=((c&1)==1?1:0);
                c>>>=1;
                i++;
            }
        }

        int m = 0;
        for(int i: r) {
            m = Math.max(i, m);
        }

        return m;
    }
}
