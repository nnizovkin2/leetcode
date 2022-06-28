package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class S2300 {
    public static void main(String[] args) {
        new S2300().successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] a=new int[100001];
        for(int p: potions) {
            a[p]++;
        }

        int[] c=new int[100001];
        int s=0;
        for(int i=100000;i>=0;i--) {
            s+=a[i];
            c[i]=s;
        }

        int[] res = new int[spells.length];
        for(int i=0;i<spells.length;i++) {
            int sp=spells[i];
            long b=success/sp+(success%sp!=0?1:0);

            if(b<=100000) {
                res[i]=c[(int)b];
            } else {
                res[i]=0;
            }
        }

        return res;
    }
}
