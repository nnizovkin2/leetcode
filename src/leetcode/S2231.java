package leetcode;

import java.util.Arrays;

public class S2231 {
    public static void main(String[] args) {
        System.out.println(new S2231().largestInteger(243));
    }

    public int largestInteger(int num) {
        int[] r = new int[10];
        int n = 0;
        while(num != 0) {
            r[n++]=num%10;
            num/=10;
        }

        int res = 0;
        int mi;
        for (int i=n-1; i>=0; i--) {
            mi = i;
            for (int j = i - 1; j >= 0; j--) {
                if(r[mi]<r[j]&&(r[mi]&1)==(r[j]&1)) {
                    mi=j;
                }
            }
            res = res * 10 + r[mi];
            r[mi] = r[i];
        }

        return res;
    }
}
