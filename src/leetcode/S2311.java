package leetcode;

public class S2311 {
    public int longestSubsequence(String s, int k) {
        char[] a=s.toCharArray();
        int n=0;
        int ind=0;
        int shift;
        for(int i=a.length-1;i>=0;i--) {
            shift=a.length-1-i;
            int v=a[i]-'0';
            if(v==0||shift<30&&n+(1<<shift)<=k) {
                n+=(v<<shift);
                ind++;
            }
        }

        return ind;
    }
}
