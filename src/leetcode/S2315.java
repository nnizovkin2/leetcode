package leetcode;

public class S2315 {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] p = new long[m+1][n+1];

        for(int[] price: prices) {
            p[price[0]][price[1]]=price[2];
        }

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {

                long c;
                for(int k=1;k<=i/2;k++) {
                    c=p[k][j]+p[i-k][j];
                    if(p[i][j]<c) p[i][j]=c;
                }

                long[] a=p[i];
                for(int k=1;k<=j/2;k++) {
                    c=a[k]+a[j-k];
                    if(p[i][j]<c) p[i][j]=c;
                }
            }
        }

        return p[m][n];
    }
}
