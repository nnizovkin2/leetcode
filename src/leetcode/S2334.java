package leetcode;

import java.lang.reflect.Array;
import java.util.*;
//[818,232,595,418,608,229,37,330,876,774,931,939,479,884,354,328]
//3790
public class S2334 {
    public static void main(String[] args) {
        System.out.println(validSubarraySize(new int[]{1,6,3,5,1}, 7));
        System.out.println(validSubarraySize(new int[]{1,6,6,5,1}, 7));
        System.out.println(validSubarraySize(new int[]{8,6,6,5,8}, 7));
        System.out.println(validSubarraySize(new int[]{6,6,6,5,6}, 7));
        System.out.println(validSubarraySize(new int[]{818, 232, 595, 418, 608, 229, 37, 330, 876, 774, 931, 939, 479, 884, 354, 328}, 3790));
    }

    //    n>t/len len>t/n
    public static int validSubarraySize(int[] nums, int t) {
        LinkedList<El> s=new LinkedList<>();
        for(int i=0;i<nums.length;i++) {
            int n=nums[i];
            int len=t/n;

            El l=null;
            while(!s.isEmpty()&&s.getLast().len<len) {
                l=s.removeLast();
                if(l.ind+l.len<i) {
                    return l.len+1;
                }
                if(l.ind+len<=i) {
                    return len+1;
                }
            }

            if(l==null) {
                s.addLast(new El(i, len));
            } else {
                s.addLast(new El(l.ind, len));
            }
        }

        while(!s.isEmpty()) {
            El l=s.removeLast();
            if(l.ind+l.len<=nums.length-1) {
                return l.len+1;
            }
        }

        return -1;
    }

    private static class El {
        int ind;
        int len;

        public El(int ind, int len) {
            this.ind = ind;
            this.len = len;
        }
    }
}
