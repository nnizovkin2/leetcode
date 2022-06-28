package leetcode;

public class S2270 {
    public int waysToSplitArray(int[] nums) {
        long s = 0;

        for (int num: nums) {
            s+=num;
        }

        int res = 0;
        long s2=0;
        for (int i = 0; i < nums.length-1; i++) {
            s2+=nums[i];
            if(s2>=s-s2) {
                res++;
            }
        }

        return res;
    }
}
