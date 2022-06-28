package leetcode;

public class S2285 {
    public static long maximumImportance(int n, int[][] roads) {
        int[] a=new int[n];

        int m=0;
        for(int[] r: roads) {
            a[r[0]]++;
            a[r[1]]++;
        }

        for(int v: a) {
            m=Math.max(m,v);
        }

        int[] b=new int[m+1];
        for(int v: a) {
            b[v]++;
        }

        long res=0;
        long ind=n;
        for(long i=m;i>=0;i--) {
            int v=b[(int)i];
            if(v!=0) {
                res+=(v*(2*ind-v+1)*i)>>1;
                ind-=v;
            }
        }

        return res;
    }
}

