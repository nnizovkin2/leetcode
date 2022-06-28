package leetcode;

public class S2299 {
    public boolean strongPasswordCheckerII(String password) {
        char[] p=password.toCharArray();
        char[] sc="!@#$%^&*()-+".toCharArray();
        if(p.length<8) return false;

        char prev=' ';

        int mask=0;

        char curr;
        for(int i=0;i<p.length;i++) {
            curr=p[i];
            if(prev==curr) return false;
            prev=curr;
            if('0'<=curr&&curr<='9') {
                mask|=1;
            } else if('a'<=curr&&curr<='z') {
                mask|=(1<<1);
            } else if('A'<=curr&&curr<='Z') {
                mask|=(1<<2);
            } else {
                for(char ch: sc) {
                    if(curr==ch) {
                        mask|=(1<<3);
                        break;
                    }
                }
            }
        }

        return mask==15;
    }
}
