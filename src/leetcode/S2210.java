package leetcode;

public class S2210 {
    public int countHillValley(int[] nums) {
        int prev = -1;
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int cur = nums[i];
            int next = nums[i+1];
            if(cur > next && cur > prev && prev != -1) {
                res++;
            }
            if(cur < next && cur < prev) {
                res++;
            }
            if(next!=cur) {
                prev = cur;
            }
        }
        return res;
    }
}
