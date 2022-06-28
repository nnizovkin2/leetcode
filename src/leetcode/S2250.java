package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//[[1,2],[2,3],[2,5]]
//[[2,1],[1,4]
//[[7,1],[2,6],[1,4],[5,2],[10,3],[2,4],[5,9]]
//[[10,3],[8,10],[2,3],[5,4],[8,5],[7,10],[6,6],[3,6]]
//[[1,1],[2,2],[3,3]]
//[[1,3],[1,1]]

public class S2250 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new S2250().countRectangles(new int[][]{{1,1},{2,2},{3,31}},
                new int[][]{{1,29},{1,1}})));
    }

    //add code from the fastest solution
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Comparator<int[]> c = Comparator.comparingInt(a -> a[0]);
        int[][] pwi = new int[points.length][];
        for (int i = 0; i < points.length; i++) {
            int[] t = new int[3];
            t[0]=points[i][0];
            t[1]=points[i][1];
            t[2]=i;
            pwi[i]=t;
        }
        Arrays.sort(rectangles, c);
        Arrays.sort(pwi, c);
        int ri = rectangles.length-1;
        int pi = pwi.length-1;
        int[] f = new int[101];
        int[] res = new int[pwi.length];
        while (true) {
            if (pi<0) {
                return res;
            }

            if (ri<0) {
                while (pi>=0) {
                    res[pwi[pi][2]] = f[pwi[pi][1]];
                    pi--;
                }
            } else if (pwi[pi][0] > rectangles[ri][0]) {
                res[pwi[pi][2]] = f[pwi[pi][1]];
                pi--;
            } else {
                int y = rectangles[ri][1];
                for (int i = 1; i <= y; i++) {
                    f[i]++;
                }
                ri--;
            }
        }
    }
}