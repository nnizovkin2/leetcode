package leetcode;

public class S2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] r=new int[2];

        int[] cs=new int[101];
        for(int n:nums) {
            cs[n]++;
        }

        for(int c:cs) {
            r[0]+=(c>>1);
            r[1]+=(c&1);
        }

        return r;
    }
}
