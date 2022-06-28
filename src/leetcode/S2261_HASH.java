package leetcode;

import java.util.HashSet;

public class S2261_HASH {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<Long> s = new HashSet<>();
        long mul = 211;
        long mod= 1746860020068409L;
        long[] hashes = new long[nums.length];
        hashes[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            hashes[i]=(hashes[i-1]+nums[i]*mul)%mod;
            long hash = 0;
            int c = 0;
            for (int j = i; j < nums.length; j++) {
                hash=hash*211+nums[j];
                if(nums[j]%p==0) {
                    c++;
                }
                if(c<=k) {
                    //dirty action.
                    s.add(hash);
                }
            }
        }
        return s.size();
    }
}
