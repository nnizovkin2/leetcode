package leetcode;

public class S2278 {
    public int percentageLetter(String s, char letter) {
        char[] str = s.toCharArray();
        int n = 0;
        for(char ch: str) {
            if(ch==letter) {
                n++;
            }
        }

        return n*100/s.length();
    }
}
