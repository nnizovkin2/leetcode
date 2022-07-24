package leetcode;

import java.util.Arrays;

public class S2354 {
    public long countExcellentPairs(int[] nums, int k) {
        int[] c=new int[32];

        Arrays.sort(nums);
        int dn=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[i-1]) dn++;
        }

        int[] d=new int[dn];

        int ind=0;
        d[ind++]=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[i-1]) d[ind++]=nums[i];
        }

        for(int n: d) {
            c[nb(n)]++;
        }

        long res=0;

        for(int n: d) {
            int nb=nb(n);
            for(int i=0;i<c.length;i++) {
                if(i+nb>=k) {
                    res+=c[i];
                }
            }
        }

        return res;
    }

    int nb(int n) {
        int res=0;
        while(n!=0) {
            res+=(n&1);
            n>>=1;
        }

        return res;
    }
}
