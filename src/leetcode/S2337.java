package leetcode;

public class S2337 {
    public boolean canChange(String start, String target) {
        char[] s=start.toCharArray();
        char[] t=target.toCharArray();

        char cur='_';
        int si=findNext(s,-1);
        int ti=findNext(t,-1);
        while(si!=s.length&&ti!=t.length) {
            if(s[si]!=t[ti]||(s[si]=='L'&&si<ti)||(s[si]=='R'&&si>ti)) return false;
            si=findNext(s,si);
            ti=findNext(t,ti);
        }

        if(si==s.length&&ti==t.length) return true;
        return false;
    }

    int findNext(char[] a, int i) {
        while(++i<a.length&&a[i]=='_');
        return i;
    }
}
