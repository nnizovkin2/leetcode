package leetcode;

public class S2342 {
    public int maximumSum(int[] nums) {
        int[][] m=new int[82][2];

        for(int n:nums) {
            int s=ds(n);
            if(m[s][0]==0) {
                m[s][0]=n;
                continue;
            }

            if(m[s][1]>=n) continue;

            if(m[s][0]<n) {
                m[s][1]=m[s][0];
                m[s][0]=n;
            } else {
                m[s][1]=n;
            }
        }

        int res=-1;

        for(int[] p: m) {
            if(p[0]!=0&&p[1]!=0) res=Math.max(res, p[0]+p[1]);
        }

        return res;
    }

    int ds(int n) {
        int r=0;

        while(n!=0) {
            r+=n%10;
            n/=10;
        }

        return r;
    }
}
