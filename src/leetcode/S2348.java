package leetcode;

public class S2348 {
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{0,0,0,1,0,0}));
    }
    public static long zeroFilledSubarray(int[] nums) {
        long res=0;
        long c=0;
        for(int n: nums) {
            if(n!=0) {
                res+=c*(c+1)/2;
                c=0;
            } else {
                c++;
            }
        }

        res+=c*(c+1);
        return res;
    }
}
