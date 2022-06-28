package leetcode;

public class S2320 {
    public int countHousePlacements(int n) {
        long[] ai=new long[n];
        long[] noai=new long[n];
        ai[0]=1;
        noai[0]=1;

        for(int i=1;i<n;i++) {
            ai[i]=noai[i-1];
            noai[i]=(noai[i-1]+ai[i-1])%1000000007;
        }

        long l = ai[n - 1] + noai[n - 1];
        return (int)(l*l%1000000007L);
    }
}
