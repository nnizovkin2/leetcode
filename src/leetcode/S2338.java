package leetcode;

class S2338 {
    public static void main(String[] args) {
        System.out.println(idealArrays(2,5));
    }

    public static int idealArrays(int n, int maxValue) {
        //add log from fastest solution.
        int b=Math.min((int)(Math.log(maxValue)/Math.log(2))+2,n+1);
        int[][] a=new int[maxValue+1][b];
        a[1][1]=1;
        for(int i=1;i<=maxValue;i++) {
            int[] ai=a[i];
            for(int j=2;i*j<=maxValue;j++) {
                int[] aij=a[i*j];
                aij[1]=1;
                for(int k=1;k<b-1;k++) {
                    if(ai[k]==0) break;
                    aij[k+1]=(ai[k]+aij[k+1]);
                }
            }
        }
        int[][] cnk=new int[n][];
        cnk[1]=new int[]{1,1};

        for(int i=2;i<n;i++) {
            int len=Math.min(b,cnk[i-1].length+1);
            cnk[i]=new int[len];
            cnk[i][0]=1;
            cnk[i][len-1]=1;
            for(int j=1;j<len-1;j++) {
                cnk[i][j]=(cnk[i-1][j-1]+cnk[i-1][j])%1000000007;
            }
        }

        long res=0;
        for(int i=1;i<a.length;i++) {
            for(int j=1;j<b;j++) {
                if(a[i][j]==0) break;
                res=(res+(long)cnk[n-1][j-1]*a[i][j])%1000000007;
            }
        }

        return (int)res;
    }
}
