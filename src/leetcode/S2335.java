package leetcode;

public class S2335 {
    public int fillCups(int[] a) {
        int s=a[1]+a[2]+a[0];
        int m=a[0];
        m=Math.max(m,a[1]);
        m=Math.max(m,a[2]);

        if(m<=s-m) {
            return s/2+s%2;
        }

        return m;
    }
}
