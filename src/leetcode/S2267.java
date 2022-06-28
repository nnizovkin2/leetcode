package leetcode;

public class S2267 {
    public boolean hasValidPath(char[][] grid) {
        boolean[][] row = new boolean[grid[0].length][];
        for (int i = 0; i < row.length; i++) {
            row[i]=new boolean[Math.max(grid.length,grid[0].length)];
            row[i][0]=true;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < row.length; j++) {
                if(j==0) {
                    row[0]=newR(row[0], grid[i][j]=='(');
                    continue;
                }

                boolean[] l = newR(row[j-1], grid[i][j]=='(');
                boolean[] d = i!=0?newR(row[j], grid[i][j]=='('):l;
                for (int k = 0; k < row[j].length; k++) {
                    row[j][k]=l[k]|d[k];
                }
            }
        }
        return row[grid[0].length-1][0];
    }

    boolean[] newR(boolean[] r, boolean isOpen) {
        boolean[] res = new boolean[r.length];
        if(isOpen) {
            res[0]=false;
            System.arraycopy(r, 0, res, 1, r.length - 1);

            return res;
        }
        res[r.length-1]=false;
        System.arraycopy(r, 1, res, 0, r.length - 1);

        return res;
    }
}
