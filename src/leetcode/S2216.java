package leetcode;

public class S2216 {
    public int minDeletion(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1] || (size&1)==1) {
                size++;
            }
        }
        size++;
        return nums.length-((size&1)==1?size-1:size);
    }
}
