package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class S2328 {
    public static void main(String[] args) {
        System.out.println(new S2328().countPaths(new int[][]{{1},{2}}));
    }
    public int countPaths(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] a=new int[grid.length*grid[0].length][3];
        long[][] r=new long[grid.length][grid[0].length];
        long res=0;
        int k=0;
        long mod=1000000007;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                a[k++]=new int[]{grid[i][j],i,j};
            }
        }

        for (long[] row: r) {
            Arrays.fill(row,1);
        }

        Arrays.sort(a, Comparator.comparingInt(ar->ar[0]));
        for(int[] cell: a) {
            int i=cell[1];
            int j=cell[2];
            if(i>0&&grid[i][j]<grid[i-1][j]) {
                r[i-1][j]=(r[i-1][j]+r[i][j])%mod;
            }

            if(i<m-1&&grid[i][j]<grid[i+1][j]) {
                r[i+1][j]=(r[i+1][j]+r[i][j])%mod;
            }

            if(j>0&&grid[i][j]<grid[i][j-1]) {
                r[i][j-1]=(r[i][j-1]+r[i][j])%mod;
            }

            if(j<n-1&&grid[i][j]<grid[i][j+1]) {
                r[i][j+1]=(r[i][j+1]+r[i][j])%mod;
            }

            res=(res+r[i][j])%mod;

        }

        return (int)res;
    }
}
