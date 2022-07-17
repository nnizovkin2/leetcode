package leetcode;

import java.util.BitSet;

public class SmallestInfiniteSet {
    BitSet bs = new BitSet(1001);

    public SmallestInfiniteSet() {
        bs.set(0, 1001);
    }

    public int popSmallest() {
        int res = bs.nextSetBit(0);
        bs.set(res, false);
        return res + 1;
    }

    public void addBack(int num) {
        bs.set(num - 1);
    }
}
