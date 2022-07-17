package leetcode;

import java.util.Arrays;

//[1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1
public class S2333 {
    public static void main(String[] args) {
        System.out.println(minSumSquareDiff(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 4, 1));
    }
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] dif=new int[nums1.length+1];

        for(int i=0;i<nums1.length;i++) {
            dif[i+1]=Math.abs(nums1[i]-nums2[i]);
        }

        Arrays.sort(dif);

        int k=k1+k2;
        int b=dif.length-1;
        int delta=0;
        int dh=0;
        int l=dif.length-1;

        while(k!=0&&b!=0) {
            int i=0;
            while(b-i>1&&dif[b-i]==dif[b-1-i]) i++;
            int p=(l-(b-i-1))*(dif[b-i]-dif[b-i-1]);
            if(p<k) {
                k-=p;
                b-=i+1;
            } else {
                dh=dif[b-i]-k/(l-(b-i-1));
                delta=k%(l-(b-i-1));
                b-=i+1;
                k=0;
            }
        }

        long res=0;

        for(int i=0;i<dif.length;i++) {
            if(i<=b) {
                res+=(long)dif[i]*dif[i];
            } else {
                if(i<=b+delta) {
                    res+=(long)(dh-1)*(dh-1);
                } else {
                    res+=(long)dh*dh;
                }
            }
        }

        return res;
    }
}
