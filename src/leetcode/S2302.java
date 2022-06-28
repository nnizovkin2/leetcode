package leetcode;

public class S2302 {
    public long countSubarrays(int[] nums, long k) {
        int ind=-1;
        long d=0;
        long res=0;
        long sum=0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];

            while((sum-d)*(i-ind)>=k) {
                ind++;
                d+=nums[ind];
            }

            res+=(i-ind);
        }

        return res;
    }
}
