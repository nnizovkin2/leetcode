package leetcode;

public class S2319 {
    static public boolean checkXMatrix(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {

                if((i==j||i+j+1==grid.length)&&grid[i][j]==0) {
                    return false;
                }

                if(i!=j&&i+j+1!=grid.length&&grid[i][j]!=0) {
                    return false;
                }
            }

        }
        return true;
    }
}
