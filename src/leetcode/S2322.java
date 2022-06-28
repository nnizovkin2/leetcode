package leetcode;

import java.util.*;

public class S2322 {
    public int minimumScore(int[] nums, int[][] edges) {
        List<Integer>[] al=new ArrayList[nums.length];
        List<Integer>[] clTree=new ArrayList[nums.length];
        int[] p=new int[nums.length];
        for (int i = 0; i < al.length; i++) {
            al[i]=new ArrayList<>();
            clTree[i]=new ArrayList<>();
        }

        for (int[] e: edges) {
            al[e[0]].add(e[1]);
            al[e[1]].add(e[0]);
        }
        int[] xor = Arrays.copyOf(nums, nums.length);
        boolean[] visited=new boolean[nums.length];

        int root=0;

        p[0]=0;
        int tXor=buildTree(root,clTree,xor,visited,al,p);

        Queue<Integer> queue;
        int r=Integer.MAX_VALUE;
        for(int[] e: edges) {
            int s;
            int px;
            if(clTree[e[0]].contains(e[1])) {
                s=e[1];
                px=xor[e[1]];
            } else {
                s=e[0];
                px=xor[e[0]];
            }

            visited=new boolean[nums.length];
            int f=tXor^px;
            visited[s]=true;
            queue = new LinkedList<>(clTree[s]);

            while(!queue.isEmpty()) {
                int ch=queue.poll();
                r=Math.min(r, dif(f, xor[ch], px^xor[ch]));
                queue.addAll(clTree[ch]);
                visited[ch]=true;
            }


            int par=p[s];
            while(true) {
                if(par==0) {
//                    r=Math.min(r,dif(nums[0],xor[0]^px^nums[0],px));
                    visited[par]=true;
                    break;
                }
                r=Math.min(r,dif(tXor^xor[par],xor[par]^px,px));
                visited[par]=true;
                par=p[par];
            }

            for(int i=0;i<nums.length;i++) {
                if(!visited[i]) {
                    r=Math.min(r, dif(f^xor[i], xor[i], px));
                }
            }
        }

        return r;
    }

    int buildTree(int root, List<Integer>[] clTree, int[] xor, boolean[] v, List<Integer>[] al,int[] p) {
        v[root]=true;
        for (int ch: al[root]) {
            if(v[ch]) continue;
            clTree[root].add(ch);
            p[ch]=root;
            xor[root]^=buildTree(ch,clTree,xor,v,al,p);
        }

        return xor[root];
    }

    int dif(int a0, int a1, int a2) {
        int max=Math.max(a0, Math.max(a1, a2));
        int min=Math.min(a0, Math.min(a1, a2));

        return max-min;
    }
}
