package leetcode;

public class S2310 {
    public int minimumNumbers(int num, int k) {
        if(num==0) {
            return 0;
        }

        if((k==0&&num%10!=0)||(k==5&&(num%10!=5&&num%10!=0))||((num&1)==1&&(k&1)==0)) {
            return -1;
        }

        int mod=num%10;

        int l=k;
        int i=1;
        while(l!=mod) {
            l=(l+k)%10;
            i++;
        }

        if(k*i>num) {
            return -1;
        }

        return i;
    }
}
