package leetcode;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class S2280 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(p->p[0]));
        int res=0;
        long pdx=1;
        long pdy=Integer.MIN_VALUE;

        for(int i=1;i<stockPrices.length;i++) {
            long dx=stockPrices[i][0]-stockPrices[i-1][0];
            long dy=stockPrices[i][1]-stockPrices[i-1][1];
            if(dx*pdy!=pdx*dy) {
                pdx=dx;
                pdy=dy;
                res++;
            }
        }

        return res;
    }
}
