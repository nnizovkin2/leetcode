package leetcode;

public class S2317 {
    public int maximumXOR(int[] nums) {
        int res=0;
        for(int n: nums) {
            res|=n;
        }

        return res;
    }
}
