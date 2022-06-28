package leetcode;

public class S2269 {
    public static void main(String[] args) {
        System.out.println(new S2269().divisorSubstrings(430043, 2));
    }

    public int divisorSubstrings(int num, int k) {
        int copy=num;
        int n = 0;
        int d = 1;
        int res = 0;
        while(num!=0) {
            k--;
            if(k>=0) {
                n+=num%10*d;
            } else {
                n=n/10+num%10*d;
            }
            if(k>0) {
                d*=10;
            }
            res+=(k<=0)&&n>0&&copy%n==0?1:0;
            num/=10;
        }

        return res;
    }
}
