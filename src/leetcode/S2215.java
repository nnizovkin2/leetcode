package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2215 {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            int[] set1 = new int[2001];
            int[] set2 = new int[2001];
            for(int i: nums1) {
                set1[i+1000] = 1;
            }

            for(int i: nums2) {
                set2[i+1000] = 1;
            }

            List<Integer> res0 = new ArrayList<>();
            List<Integer> res1 = new ArrayList<>();;
            for (int i = 0; i < 2001; i++) {
                if(set1[i]==1&&set2[i]==0) {
                    res0.add(i-1000);
                }
                if(set1[i]==0&&set2[i]==1) {
                    res1.add(i-1000);
                }
            }
            return Arrays.asList(res0, res1);
        }
}
