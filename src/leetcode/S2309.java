package leetcode;

public class S2309 {
    public String greatestLetter(String s) {
        char[] a=new char[26];

        for(int ch: s.toCharArray()) {
            if(ch<='Z') {
                a[ch-'A']|=1;
            } else {
                a[ch-'a']|=2;
            }
        }

        char res=0;

        for(int i=0;i<26;i++) {
            if(a[i]==3) {
                res=(char)('A'+i);
            }
        }

        return res!=0?String.valueOf(res):"";
    }
}
