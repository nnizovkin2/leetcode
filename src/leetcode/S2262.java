package leetcode;

import java.util.Arrays;

public class S2262 {
    public long appealSum(String s) {
        char[] a=s.toCharArray();
        long[] pref=new long[26];
        Arrays.fill(pref,(long)-1);
        long r=0;
        long sum=0;
        for(int i=0;i<a.length;i++){
            sum+=i-pref[a[i]-'a'];
            pref[a[i]-'a']=i;
            r+=sum;
        }

        return r;
    }
}
