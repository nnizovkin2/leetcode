package leetcode;

public class S2327 {
    public static void main(String[] args) {
        System.out.println(new S2327().peopleAwareOfSecret(289,7,23));
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] di=new long[n+1];
        di[1]=1;
        long mod=1000000007;
        long active=0;
        long res=1;
        for(int i=2;i<=n;i++) {
            long it=0;
            if(i-delay>0) {
                it=di[i-delay];
            }

            if(i-forget>0) {
                it=(it+mod-di[i-forget])%mod;
                res=(res+mod-di[i-forget])%mod;
            }

            active=(active+it)%mod;
            di[i]=active;
            res=(res+active)%mod;
        }

        return (int)res;
    }
}
