package leetcode;

public class S2318 {
    public int distinctSequences(int n) {
        if(n==1) return 6;
        if(n==2) return 22;

        int[] s=new int[66];
        s[12]=1;
        s[13]=1;
        s[14]=1;
        s[15]=1;
        s[16]=1;
        s[21]=1;
        s[31]=1;
        s[41]=1;
        s[51]=1;
        s[61]=1;
        s[23]=1;
        s[25]=1;
        s[32]=1;
        s[34]=1;
        s[35]=1;
        s[43]=1;
        s[45]=1;
        s[52]=1;
        s[53]=1;
        s[54]=1;
        s[56]=1;
        s[65]=1;

        int[] st=new int[66];
        n-=2;
        while(n-->0) {
            for (int i = 0; i < 66; i++) {
                for (int j = 1; j <= 6; j++) {
                    if(s[i]!=0) {
                        if (s[i] != 0 && check(i % 10, j) && j != i / 10) {
                            int ind=(i%10)*10+j;
                            st[ind]=(s[i]+st[ind])%1000000007;
                        }
                    }
                }
            }

            s=st;
            st=new int[66];
        }
        int res=0;
        for(int i=0;i<66;i++) {
            res=(res+s[i])%1000000007;
        }

        return res;
    }

    boolean check(int i, int j) {
        if(i==4&&j==6) return false;
        if(i==6&&j==4) return false;
        return i!=j&&(i==1||j==1||(i%j!=0&&j%i!=0));
    }
}
