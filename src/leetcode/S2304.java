package leetcode;

import java.util.Arrays;
//[[5,3],[4,0],[2,1]]
//[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
public class S2304 {
    public static void main(String[] args) {
        System.out.println(new S2304().minPathCost(new int[][]{new int[]{5,3},new int[]{4,0},new int[]{2,1}},
        new int[][]{new int[]{9,8},new int[]{1,5},new int[]{10,12},new int[]{18,6},new int[]{2,4},new int[]{14,3}}));
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[] sums=new int[grid[0].length];
        int[] m=new int[grid[0].length];

        for(int i=0;i<grid.length;i++) {
            if(i==grid.length-1) {
                for(int j=0;j<grid[0].length;j++) {
                    sums[j]+=grid[i][j];
                }
            } else {
                Arrays.fill(m, 100000);
                for(int j=0;j<grid[0].length;j++) {
                    for(int k=0;k<grid[0].length;k++) {
                        m[k]=Math.min(m[k], sums[j]+grid[i][j]+moveCost[grid[i][j]][k]);
                    }
                }
                for(int j=0;j<grid[0].length;j++) {
                    sums[j]=m[j];
                }
            }
        }

        int res=1000000;
        for(int s: sums) {
            res=Math.min(s,res);
        }

        return res;
    }
}
