package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S2261_TRIE {
    public static void main(String[] args) {
        System.out.println(new S2261_TRIE().countDistinct(new int[]{2,3,3,2,2}, 2, 2));
    }
    HashMap<Integer, HashMap> trie = new HashMap<>();
    int counter = 0;

    public int countDistinct(int[] nums, int k, int p) {
        int[] m = new int[nums.length+1];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%p==0) {
                c++;
            }
            m[i+1]=c;
        }
        HashMap[] pos = new HashMap[nums.length];
        Arrays.fill(pos, new HashMap<>());

        c=0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            for (int j = c; j<i+1; j++) {
                if(m[i+1]-m[j]>k) {
                    c++;
                    continue;
                }

                pos[j]=add(v,pos[j]);
            }
        }

        return counter;
    }

    HashMap<Integer, HashMap> add(Integer i, Map<Integer, HashMap> trie) {
        HashMap<Integer, HashMap> res = trie.get(i);
        if (res == null) {
            res = new HashMap<>();
            trie.put(i, res);
            counter++;
            return res;
        }

        return res;
    }
}