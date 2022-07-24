package leetcode;

public class S2351 {
    public char repeatedCharacter(String s) {
        boolean[] ind=new boolean[26];
        char[] a=s.toCharArray();

        for(char ch: a) {
            if(ind[ch-'a']) {
                return ch;
            }

            ind[ch-'a']=true;
        }

        return 'a';
    }
}
