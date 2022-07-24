package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class S2352 {
    public static int equalPairs(int[][] grid) {
        int n=grid.length;
        HashMap<Integer,int[]> rh=new HashMap<>();
        HashMap<Integer,Integer> c=new HashMap<>();

        for(int i=0;i<n;i++) {
            int h=0;
            for(int j=0;j<n;j++) {
                h*=29;
                h+=grid[i][j];
            }

            rh.put(h, grid[i]);
            c.put(h,c.getOrDefault(h,0)+1);
        }

        int r=0;

        int[] a=new int[n];

        for(int i=0;i<n;i++) {
            int h=0;
            for(int j=0;j<n;j++) {
                h*=29;
                h+=grid[j][i];
                a[j]=grid[j][i];
            }

            if(rh.containsKey(h)&& Arrays.equals(rh.get(h),a)) r+=c.get(h);
        }

        return r;
    }
}
