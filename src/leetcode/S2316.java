package leetcode;

import java.util.HashSet;
import java.util.Set;

public class S2316 {
    public long countPairs(int n, int[][] edges) {
        DisjointUnionSets sets=new DisjointUnionSets(n);
        for(int[] edge: edges) {
            sets.union(edge[0], edge[1]);
        }

        long res=0;

        Set<Integer> s=new HashSet<>();

        long sum=0;
        int[] p=sets.parent;
        for(int i=0;i<p.length;i++) {
            int elP=sets.find(p[i]);
            if(!s.contains(elP)) {
                s.add(elP);
                res+=sum*sets.size[elP];
                sum+=sets.size[elP];
            }
        }



        return res;
    }

    //take from here https://www.geeksforgeeks.org/disjoint-set-data-structures/
    static class DisjointUnionSets {
        int[] rank, parent;
        int n;
        int[] size;

        // Constructor
        public DisjointUnionSets(int n)
        {
            rank = new int[n];
            parent = new int[n];
            size=new int[n];
            this.n = n;
            makeSet();
        }

        // Creates n sets with single item in each
        void makeSet()
        {
            for (int i = 0; i < n; i++) {
                // Initially, all elements are in
                // their own set.
                parent[i] = i;
                size[i]=1;
            }
        }

        // Returns representative of x's set
        int find(int x)
        {
            // Finds the representative of the set
            // that x is an element of
            if (parent[x] != x) {
                // if x is not the parent of itself
                // Then x is not the representative of
                // his set,
                parent[x] = find(parent[x]);

                // so we recursively call Find on its parent
                // and move i's node directly under the
                // representative of this set
            }

            return parent[x];
        }

        // Unites the set that includes x and the set
        // that includes x
        int union(int x, int y)
        {
            // Find representatives of two sets
            int xRoot = find(x), yRoot = find(y);

            // Elements are in the same set, no need
            // to unite anything.
            if (xRoot == yRoot)
                return xRoot;

            int newSize=size[xRoot]+size[yRoot];
            size[xRoot]=newSize;
            size[yRoot]=newSize;
            // If x's rank is less than y's rank
            if (rank[xRoot] < rank[yRoot]) {

                // Then move x under y  so that depth
                // of tree remains less
                parent[xRoot] = yRoot;
                return yRoot;
            }

            // Else if y's rank is less than x's rank
            else if (rank[yRoot] < rank[xRoot]) {

                // Then move y under x so that depth of
                // tree remains less
                parent[yRoot] = xRoot;
                return xRoot;
            }

            else // if ranks are the same
            {
                // Then move y under x (doesn't matter
                // which one goes where)
                parent[yRoot] = xRoot;

                // And increment the result tree's
                // rank by 1
                rank[xRoot] = rank[xRoot] + 1;
                return xRoot;
            }
        }
    }
}
