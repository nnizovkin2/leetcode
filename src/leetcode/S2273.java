package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> l = new ArrayList<>();
        String word = words[0];

        for (int i = 1; i < words.length; i++) {
            if(!isEqual(word, words[i])) {
                l.add(word);
                word=words[i];
            }
        }

        l.add(word);

        return l;
    }

    boolean isEqual(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);
        return new String(a1).equals(new String(a2));
    }
}
