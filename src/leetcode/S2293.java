package leetcode;

import java.util.Arrays;

public class S2293 {
    public int minMaxGame(int[] nums) {
        int[] t=new int[nums.length/2];
        while(nums.length!=1){
            for(int i=0; i<nums.length/2; i++) {
                if(i%2==0) {
                    t[i]=Math.min(nums[2*i], nums[2*i+1]);
                } else {
                    t[i]=Math.max(nums[2*i], nums[2*i+1]);
                }
            }

            nums= Arrays.copyOf(t, nums.length/2);
        }
        return nums[0];
    }
}
