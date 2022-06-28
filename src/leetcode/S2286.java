package leetcode;
import java.util.Arrays;

class S2286 {
    int[] hall;
    int m;
    int p;
    public S2286(int n, int m) {
        hall=new int[n];
        Arrays.fill(hall, m);
        this.m=m;
        p=0;
    }

    //["BookMyShow","scatter","gather","gather","gather"]
//[[3,999999999],[1000000000,2],[999999999,2],[999999999,2],[999999999,2]]
    public static void main(String[] args) {
        S2286 show=new S2286(3,999999999);
        show.scatter(1000000000,2);
        show.gather(999999999,2);
        show.gather(999999999,2);
    }

    public int[] gather(int k, int maxRow) {
        if(k>m) {
            return new int[]{};
        }

        for(int i=p;i<=maxRow;i++) {
            if(hall[i]>=k) {
                var res=new int[]{i, m-hall[i]};
                hall[i]-=k;
                return res;
            }
        }

        return new int[0];
    }

    public boolean scatter(int k, int maxRow) {
        if((long)m*(maxRow+1-p)<k) {
            return false;
        }

        int r=k;
        int i;
        for(i=p;i<=maxRow;i++) {
            if(r-hall[i]<=0) {
                break;
            }

            r-=hall[i];
        }

        if(i>maxRow) {
            return false;
        }

        for(i=p;i<=maxRow;i++) {
            if(k-hall[i]<=0) {
                if(k==hall[i]) p++;
                hall[i]-=k;
                return true;
            }
            k-=hall[i];
            hall[i]=0;
            p++;
        }

        return true;
    }
}

