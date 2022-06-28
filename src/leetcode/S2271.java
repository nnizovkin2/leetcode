package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class S2271 {
    public static void main(String[] args) {
        System.out.println(new S2271().maximumWhiteTiles(new int[][]{new int[]{1,1},new int[]{10,11}}, 2));
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = maximumWhiteTilesBeg(tiles, carpetLen);
        for (int[] tile : tiles) {
            int t =-tile[0];
            tile[0]=-tile[1];
            tile[1]=t;
        }
        return Math.max(max, maximumWhiteTilesBeg(tiles, carpetLen));
    }

    public int maximumWhiteTilesBeg(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int[] partS = new int[tiles.length];
        int[] begin = new int[tiles.length];
        begin[0]=tiles[0][0];
        partS[0]=tiles[0][1]-begin[0]+1;
        for (int i = 1; i < partS.length; i++) {
            begin[i]=tiles[i][0];
            partS[i]=partS[i-1]+tiles[i][1]-begin[i]+1;
        }

        int res = 0;
        for (int i = 0; i < partS.length; i++) {
            int sum=-(i>0?partS[i-1]:0);
            int e=begin[i]+carpetLen-1;
            int ind = Arrays.binarySearch(begin, e);
            ind = ind>=0?ind:(-ind-2);
            sum+=(ind>0?partS[ind-1]:0)+Math.min(e, tiles[ind][1])-begin[ind]+1;
            res=Math.max(res, sum);
        }

        return res;
    }
}