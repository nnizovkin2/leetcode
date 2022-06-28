package leetcode;

public class S2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char[] f = floor.toCharArray();
        int fl = f.length;
        int cl = numCarpets + 1;
        int[] da = new int[fl*cl];
        int[] ind = new int[f.length];
        int s = 0;
        for (int i = 0; i < ind.length; i++) {
            if(f[i] == '1') {
                s++;
            }
            ind[i] = s;
        }

        int res = 0;
        if(numCarpets > 1) {
            da[index(carpetLen - 1,1, cl)] = ind[Math.min(carpetLen - 1, fl - 1)];
        } else {
            res = ind[carpetLen - 1];
        }

        for (int i = 0; i < fl; i++) {
            int next = Math.min(i + carpetLen, fl-1);
            int diff = ind[next] - ind[i];
            int j;
            for (j = 0; j < cl - 1; j++) {
                da[index(next,j+1,cl)] = Math.max(da[index(next,j,cl)], Math.max(da[index(i,j,cl)] + diff, next-1>=0?da[index(next-1,j+1,cl)]:0));
            }

            res = Math.max(res, da[index(next,j,cl)]);
        }

        return ind[ind.length-1] - res;
    }

    int index(int i, int j, int l) {
        return i*l+j;
    }
}
