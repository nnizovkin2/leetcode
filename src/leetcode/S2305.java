package leetcode;

import java.util.Arrays;

public class S2305 {
    public static void main(String[] args) {
        System.out.println(new S2305().distributeCookies(new int[]{8,15,10,20,8}, 2));
    }

    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        return distributeCookies(cookies, new int[k], 0, 0, 0);
    }

    public int distributeCookies(int[] cookies, int sums[], int ind, int max, int notEmpty) {
        if(sums.length-notEmpty==cookies.length-ind) {
            return Math.max(max, cookies[cookies.length-1]);
        }

        int res=1000000;
        boolean ne=false;
        for(int i=0;i<sums.length;i++) {
            ne=sums[i]==0;
            sums[i]+=cookies[ind];
            res=Math.min(res, distributeCookies(cookies, sums, ind+1, Math.max(max, sums[i]), notEmpty+(ne?1:0)));
            sums[i]-=cookies[ind];
            if(ne) {
                break;
            }
        }

        return res;
    }
}
