package leetcode;

import java.util.ArrayList;
import java.util.List;

public class S2248 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        short[] f = new short[1001];
        int[] t;
        for (int i = 0; i < nums.length; i++) {
            t = nums[i];
            for (int j = 0; j < t.length; j++) {
                f[t[j]]++;
            }
        }

        int l = nums.length;
        for (int i = 0; i < f.length; i++) {
            if(f[i]==l) {
                res.add(i);
            }
        }

        return res;
    }
}
