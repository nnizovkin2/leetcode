package leetcode;

import java.util.Arrays;

public class S2344 {
    public static void main(String[] args) {
        long s=System.currentTimeMillis();
        System.out.println(minOperations(new int[]{5,5,4,3}, new int[]{279959810,288396765,151959255,994051640,639203575}));
        System.out.println(System.currentTimeMillis()-s);
    }

    public static int minOperations(int[] d, int[] nums) {
        int gcd=nums[0];
        for(int n:nums) {
            gcd=gcd(gcd, n);
        }

        Arrays.sort(d);

        for(int i=0;i<d.length;i++) {
            if(gcd%d[i]==0) return i;
        }

        return -1;
    }

    static int gcd(int a, int b) {
        if(a<b) {
            int t=a;
            a=b;
            b=t;
        }

        while(a%b!=0) {
            a-=b;

            if(a<b) {
                int t=a;
                a=b;
                b=t;
            }
        }

        return b;
    }
}
