package leetcode;

import java.util.Arrays;

public class S2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min=nums[0];
        int res=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-min>k) {
                res++;
                min=nums[i];
            }
        }

        return res;
    }
}
