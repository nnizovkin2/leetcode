package leetcode;

import java.util.List;

public class S2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] res = new int[k + 1];
        int[] t = new int[k + 1];
        for (List<Integer> pile : piles) {
            int sum = 0;
            int m = Math.min(pile.size(), k);
            for (int j = 0; j < m; j++) {
                sum += pile.get(j);
                for (int l = j + 1; l < res.length; l++) {
                    if (t[l] < res[l - j - 1] + sum) {
                        t[l] = res[l - j - 1] + sum;
                    }
                }
            }
            System.arraycopy(t, 1, res, 1, res.length - 1);
        }
        return res[k];
    }
}
