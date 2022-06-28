package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class S2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Bag[] bag=new Bag[rocks.length];
        for(int i=0;i<rocks.length;i++) {
            bag[i]=new Bag(capacity[i],rocks[i]);
        }

        Arrays.sort(bag, Comparator.comparingInt(b -> b.capacity - b.rock));
        int n=0;

        for(Bag b: bag) {
            if(b.capacity-b.rock<=additionalRocks) {
                n++;
                additionalRocks-=b.capacity-b.rock;
            } else {
                return n;
            }
        }

        return n;
    }

    private static class Bag {
        int capacity;
        int rock;

        public Bag(int capacity, int rock) {
            this.capacity=capacity;
            this.rock=rock;
        }
    }
}
