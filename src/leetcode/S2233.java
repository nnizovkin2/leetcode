package leetcode;

import java.util.Arrays;

//[24,67,5,86,81,73,34,67,88,53,97,87,79,82,35,79,35,43,95,18,27,64,86,46,12,78,86,10,100,14,84,92,1,69,14,77,77
//        ,21,55,54,58,29,83,23,42,21,28,40,71,18,74,44,47,64,45,57,26]
//        96
public class S2233 {
    public static void main(String[] args) {
        System.out.println(new S2233().maximumProduct(new int[]{24, 5, 64, 53, 26, 38}, 54));
    }

    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        long level = nums[0];
        int i;
        for (i = 1; i < nums.length && k > 0; i++) {
            long diff = (nums[i] - level) * i;
            if (diff > k) {
                break;
            }
            k -= diff;
            level = nums[i];
        }

        level += k / i;
        k %= i;

        long res = pow(level + 1, k, mod);
        res = res * pow(level, i - k, mod) % mod;
        for (; i < nums.length; i++) {
            res = (res * nums[i]) % mod;
        }

        return (int) res;
    }

    int pow(long b, int d, int mod) {
        long r = 1;
        while (d > 0) {
            if ((d & 1) == 1) {
                r = (r * b) % mod;
            }
            b = (b * b) % mod;
            d >>= 1;
        }
        return (int) r;
    }
}
