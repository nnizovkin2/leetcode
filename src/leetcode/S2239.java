package leetcode;

public class S2239 {
    public static void main(String[] args) {
        System.out.println(new S2239().findClosestNumber(new int[]{-1, -4,-2,1,4,8}));
    }

    public int findClosestNumber(int[] nums) {
        int res = Integer.MIN_VALUE;
        long mod = -(long)Integer.MIN_VALUE;
        for (int num : nums) {
            long t = num < 0?-(long)num:num;
            if(t<mod||res==-t) {
                mod = t;
                res = num;
            }
        }

        return res;
    }
}
