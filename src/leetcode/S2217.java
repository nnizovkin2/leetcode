package leetcode;

public class S2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] r = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            r[i] = gen(queries[i], intLength);
        }
        return r;
    }

    private long gen(int query, int l) {
        if (l == 1) {
            if (query < 10) {
                return query;
            } else {
                return -1;
            }
        }

        if (9 * (pow(10, (l & 1) + (l >> 1) - 1)) < query) {
            return -1;
        }

        query--;
        long suffix = 0;
        int dn = (l & 1) + l >> 1;
        int itN = 0;
        long m = 1;
        long middle = 0;
        while (query != 0) {
            int d = query % 10;
            if (itN == 0 && (l & 1) == 1) {
                middle = d;
            } else {
                suffix = suffix * 10 + d;
            }
            query /= 10;
            itN++;
        }
        suffix = 1 + suffix * pow(10, dn - itN);
        long pref = 0;
        long ts = suffix;
        int hs = l >> 1;
        while (hs != 0) {
            pref = pref * 10 + ts % 10;
            ts /= 10;
            hs--;
        }
        if ((l & 1) == 1) {
            pref = pref * 10 + middle;
        }

        pref *= pow(10, l >> 1);

        return pref + suffix;
    }

    long pow(int x, int y) {
        long res = 1;
        int y2 = revert(y);
        while (y != 0) {
            res = res * res * ((y2 & 1) == 1 ? x : 1);
            y2 >>= 1;
            y >>= 1;
        }
        return res;
    }

    int revert(int l) {
        int r = 0;
        while (l != 0) {
            r <<= 1;
            r += l & 1;
            l >>= 1;
        }

        return r;
    }
}
