package leetcode;

public class S2283 {
    public boolean digitCount(String num) {
        int[] d=new int[10];
        char[] a=num.toCharArray();
        for(int i=0;i<a.length;i++) {
            d[a[i]-'0']++;
            a[i]-='0';
        }
        for(int i=0;i<a.length;i++) {
            if(d[i]!=a[i])return false;
        }

        return true;
    }
}
