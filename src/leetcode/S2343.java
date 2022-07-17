package leetcode;

import java.util.Arrays;

public class S2343 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(smallestTrimmedNumbers(new String[]{"102", "473", "251", "814"}, new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}})));
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] q) {
        int sLength=nums[0].length();
        int[][] sInd=new int[sLength][nums.length];
        char[][] a=new char[nums.length][];
        for(int i=0;i<nums.length;i++) {
            a[i]=nums[i].toCharArray();
        }

        int[] c=new int[10];

        for(int i=0;i<sLength;i++) {
            int charInd=sLength-i-1;
            Arrays.fill(c, 0);
            for(char[] arr: a) {
                c[arr[charInd]-'0']++;
            }

            for(int j=1;j<10;j++) {
                c[j]+=c[j-1];
            }

            for(int j=nums.length-1;j>=0;j--) {
                int ind=i!=0?sInd[i-1][j]:j;
                sInd[i][--c[a[ind][charInd]-'0']]=ind;
            }
        }

        int[] res=new int[q.length];
        for(int i=0;i<q.length;i++) {
            res[i]=sInd[q[i][1]-1][q[i][0]-1];
        }

        return res;
    }
}
