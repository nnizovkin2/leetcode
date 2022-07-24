package leetcode;

import java.util.HashSet;

public class S2354 {
    public long countExcellentPairs(int[] nums, int k) {
        int[] c=new int[32];
        HashSet<Integer> d=new HashSet<>();

        for(int n: nums) {
            d.add(n);
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
