package leetcode;

public class S2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] s = text.toCharArray();
        char pr = pattern.charAt(0);
        char suf = pattern.charAt(1);
        int prn = 0;
        int sn = 0;
        long res = 0;
        for (char c : s) {
            if(c==suf) {
                sn++;
                res+=prn;
            }
            if(c==pr) {
                prn++;
            }
        }

        res+=Math.max(prn, sn);

        return res;
    }
}
