package leetcode;

import java.util.Arrays;

public class S2242 {
    public static void main(String[] args) {
//        [14,12,10,8,1,2,3,1]
//[[1,0],[2,0],[3,0],[4,0],[5,1],[6,1],[7,1],[2,1]]
        int[][] a = new int[2][];
        a[0] = new int[]{2,1,0};
        a[1] = new int[]{0,0,0};
        new S2242().insert(a, 3, 1);
        System.out.println(new S2242().maximumScore(new int[]{14,12,10,8,1,2,3,1},
                new int[][]{{1,0},{2,0},{3,0},{4,0},{5,1},{6,1},{7,1},{2,1}}));
    }

    public int maximumScore(int[] scores, int[][] edges) {
        int[][][] val = new int[scores.length][][];
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];

            add(s, e, val, scores[e]);
            add(e, s, val, scores[s]);
        }

        int res = 0;
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int rc = scores[s] + scores[e];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int sc = val[s][0][i];
                    int ec = val[e][0][j];
                    int scNode = val[s][1][i];
                    int ecNode = val[e][1][j];
                    if(sc!=-1&&ec!=-1&&rc+sc+ec>res&&ecNode!=s&&scNode!=e&&ecNode!=scNode) {
                        res = rc+sc+ec;
                    }
                }
            }
        }
        return res!=0?res:-1;
    }

    void add(int s, int e, int[][][] val, int score) {
        if(val[s]==null) {
            val[s] = new int[2][];
            val[s][0] = new int[]{-1,-1,-1};
            val[s][1] = new int[3];
        }
        insert(val[s], score, e);
    }

    void insert(int[][] scores, int score, int node) {
        if (scores[0][0] < score) {
            scores[0][2] = scores[0][1];
            scores[1][2] = scores[1][1];
            scores[0][1] = scores[0][0];
            scores[1][1] = scores[1][0];
            scores[0][0] = score;
            scores[1][0] = node;
        } else if (scores[0][1] < score) {
            scores[0][2] = scores[0][1];
            scores[1][2] = scores[1][1];
            scores[0][1] = score;
            scores[1][1] = node;
        } else if (scores[0][2] < score) {
            scores[0][2] = score;
            scores[1][2] = node;
        }
    }
}
