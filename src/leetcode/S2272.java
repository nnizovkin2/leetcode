package leetcode;

import java.util.Arrays;

public class S2272 {
    public static void main(String[] args) {
        System.out.println(new S2272().largestVariance("lripaa"));
    }
    public int largestVariance(String s) {
        char[] a = new char[s.length()];
        for (int i = 0; i < a.length; i++) {
            a[i]=s.charAt(a.length-1-i);

        }
        return Math.max(largestVariance0(s), largestVariance0(new String(a)));
    }

    public int largestVariance0(String s) {
        int[][] cur = new int[26][];
        int[][] max = new int[26][];
        int[][] min = new int[26][];
        int[][] minPos = new int[26][];
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        for (int i = 0; i < cur.length; i++) {
            cur[i] = new int[26];
            max[i] = new int[26];
            min[i] = new int[26];
            minPos[i] = new int[26];
            Arrays.fill(minPos[i], -1);
        }

        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int ind = str[i] - 'a';
            cur[ind][ind]++;
            lastPos[ind]=i;
            for (int j = 0; j < 26; j++) {
                if (ind == j) {
                    continue;
                }
                cur[ind][j]++;
                cur[j][ind]--;
                if(min[j][ind]>cur[j][ind]) {
                    minPos[j][ind]=i;
                    min[j][ind]=cur[j][ind];
                }
                if(cur[j][j]>0&&lastPos[j]>minPos[ind][j]) {
                    max[ind][j]=Math.max(max[ind][j], cur[ind][j]-min[ind][j]);
                } else if(cur[j][j]>0) {
                    max[ind][j]=Math.max(max[ind][j], cur[ind][j]-min[ind][j]-1);
                }

            }
        }

        int m = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                m = Math.max(max[i][j], m);
            }
        }

        return m;
    }
}