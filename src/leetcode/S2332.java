package leetcode;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[20,30,10]
//[19,13,26,4,25,11,21]
//2

//[18,8,3,12,9,2,7,13,20,5]
//[13,10,8,4,12,14,18,19,5,2,30,34]
//1

//[10,20]
//[2,17,18,19]
//2

//[6,8,18,17]
//[6,8,17]
//1

class S2332 {
    public static void main(String[] args) {
        System.out.println(latestTimeCatchTheBus(new int[]{5}, new int[]{7,8}, 1));
        System.out.println(latestTimeCatchTheBus(new int[]{3}, new int[]{2}, 2));
        System.out.println(latestTimeCatchTheBus(new int[]{6,8,18,17}, new int[]{6,8,17}, 1));
        System.out.println(latestTimeCatchTheBus(new int[]{2}, new int[]{2}, 2));
    }

    public static int latestTimeCatchTheBus(int[] b, int[] p, int c) {
        Arrays.sort(b);
        Arrays.sort(p);

        List<Integer>[] groups=new List[b.length];
        int j=0;
        for(int i=0;i<p.length;i++) {
            if(groups[j]==null) groups[j]=new ArrayList<>();
            while(b[j]<p[i]) {
                j++;
                if(j==b.length) break;
                groups[j]=new ArrayList<>();
            }

            if(j==b.length) {
                break;
            }

            if(groups[j].size()==c) {
                j++;
                if(j==b.length) break;
                groups[j]=new ArrayList<>();
            }

            groups[j].add(i);
        }

        for(int i=b.length-1;i>=0;i--) {
            if(groups[i]==null||groups[i].isEmpty()||(groups[i].size()<c&&p[groups[i].get(groups[i].size()-1)]!=b[i])) {
                return b[i];
            }

            for(j=groups[i].size()-1;j>=0;j--) {
                int k=groups[i].get(j);
                if(k==0||p[k]-1!=p[k-1]) {
                    return p[k]-1;
                }
            }
        }

        return 0;
    }
}