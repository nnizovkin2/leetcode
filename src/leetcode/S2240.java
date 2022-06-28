package leetcode;

import ed.euler.prime.PrimeUtil;

public class S2240 {
    public static void main(String[] args) {
        S2240 s = new S2240();
        var nums = PrimeUtil.primesTill(10000);
        System.out.println(s.waysToBuyPensPencils(53, 5, 7));
        for (int i1 : nums) {
            for (int i2 : nums) {
                if(i1!=i2&&(i1+1)*(i2+1)/2+1!=s.waysToBuyPensPencils(i1*i2,i1,i2)) {
                    System.out.println(i1 + " " + i2);
                }
            }
        }
    }

    public long waysToBuyPensPencils(int t, int c1, int c2) {
        if(t<c1&&t<c2) {
            return 1;
        }

        if(c1>c2) {
            int temp = c1;
            c1=c2;
            c2=temp;
        }
        long res = 0;
        while(t>=0) {
            res+=t/c1+1;
            t-=c2;
        }
        return res;
    }
}
