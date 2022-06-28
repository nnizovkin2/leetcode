package leetcode;

import java.util.Arrays;

public class S2260 {
    public int minimumCardPickup(int[] cards) {
        int max=cards[0];
        for(int i: cards) {
            max=Math.max(max, i);
        }
        int[] ind=new int[max+1];
        Arrays.fill(ind,-1);
        int d=1000000;
        int pos;
        for(int i=0; i<cards.length; i++) {
            pos = ind[cards[i]];
            ind[cards[i]]=i;
            if(pos!=-1&&i-pos+1<d) {
                d=i-pos+1;
            }
        }

        return d!=1000000?d:-1;
    }
}

