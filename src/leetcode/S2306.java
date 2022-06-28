package leetcode;

import java.util.*;

public class S2306 {
    //took from fastest solution
    public long distinctNames(String[] ideas) {
        Map<String, Integer> m=new HashMap<>();

        int[] r=new int[26];
        int[][] d=new int[26][];

        for (int i=0;i<d.length;i++) {
            d[i]=new int[26];

        }
        for(int i=0;i<ideas.length;i++) {
            String str=ideas[i];
            int ch=str.charAt(0)-'a';
            String s=str.substring(1);
            m.put(s, m.getOrDefault(s, 0)|1<<ch);
            r[ch]++;
        }

        long res=0;
        for(int v: m.values()) {
            int vi=v;
            int i=0;
            int sum=0;
            while(vi!=0) {
                if((vi&1)==1) {
                    int vj=v;
                    int j=0;
                    sum++;
                    while(vj!=0) {
                        if((vj&1)==1&&i!=j) {
                            d[i][j]++;
                        }
                        j++;
                        vj >>= 1;
                    }
                }
                i++;
                vi>>=1;
            }
        }

        for (int i=0;i<26;i++) {
            for (int j=i+1;j<26;j++) {
                if(i!=j) {
                    res+= (long) (r[i] - d[i][j]) *(r[j]-d[i][j]);
                }
            }
        }

        return res*2;
    }
}
