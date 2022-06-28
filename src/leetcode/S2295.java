package leetcode;

import java.util.HashMap;
import java.util.Map;

public class S2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> t = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            t.put(nums[i],i);
        }

        for(int i=0;i<operations.length;i++) {
            int ind=t.remove(operations[i][0]);
            t.put(operations[i][1],ind);
        }

        for(var entry: t.entrySet()) {
            nums[entry.getValue()]=entry.getKey();
        }

        return nums;
    }
}
