package leetcode;

import java.util.Arrays;

class S2350 {
    public static int shortestSequence(int[] rolls, int k) {
        int res=1;
        boolean[] s=new boolean[k];
        int v=0;
        for(int i=0;i<rolls.length;i++) {
            if(!s[rolls[i]-1]) {
                s[rolls[i]-1]=true;
                v++;
            }
            if(v==k) {
                res++;
                v=0;
                Arrays.fill(s,false);
            }
        }

        return res;
    }
}
