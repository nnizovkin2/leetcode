package leetcode;

public class S2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int ts1=0;
        int ts2=0;

        for(int i=0;i<nums1.length;i++) {
            ts1+=nums1[i];
            ts2+=nums2[i];
        }

        return Math.max(max(nums1, nums2), max(nums2, nums1));
    }

    private int max(int[] nums1, int[] nums2) {
        int ts2;
        int ts1;
        int max=0;
        int min=0;

        ts1=0;
        ts2=0;
        for(int i = 0; i< nums1.length; i++) {
            max=Math.max(max, ts1-ts2-min);
            ts1+= nums1[i];
            ts2+= nums2[i];
            min=Math.min(min, ts1-ts2);
        }

        return max + ts2;
    }
}
