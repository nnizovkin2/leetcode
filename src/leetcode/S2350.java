package leetcode;

import java.util.BitSet;

public class S2350 {
    public static int shortestSequence(int[] rolls, int k) {
        int res=1;
        BitSet s=new BitSet(k);
        for(int i=0;i<rolls.length;i++) {
            s.set(rolls[i]-1);
            if(s.cardinality()==k) {
                res++;
                s.clear();
            }
        }

        return res;
    }
}
