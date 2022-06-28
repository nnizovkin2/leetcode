package leetcode;

import java.util.TreeSet;

public class S2276 {
    /**
     * Your CountIntervals object will be instantiated and called as such:
     * CountIntervals obj = new CountIntervals();
     * obj.add(left,right);
     * int param_2 = obj.count();
     */

    TreeSet<Interval> tree = new TreeSet<>();
    int count = 0;

    public S2276() {

    }

    public void add(int left, int right) {
        Interval l = new Interval(left, right);
        count=count+right-left+1;
        l = leftInterval(left, right, l);
        while(true) {
            Interval r = tree.ceiling(l);
            if(r==null||l.e<r.b) {
                tree.add(l);
                return;
            }

            tree.remove(r);
            if(l.e>=r.e) {
                count-=r.e - r.b +1;
                l = new Interval(l.b,l.e);
                continue;
            }

            count-=l.e- r.b+1;
            l = new Interval(l.b,r.e);
        }
    }

    private Interval leftInterval(int left, int right, Interval i) {
        Interval m = tree.floor(i);
        if(m==null) {
            return i;
        }
        if(m.e<i.b) {
            return i;
        }

        tree.remove(m);
        if(m.e>= i.e) {
            count-= right - left+1;
            return m;
        }

        count-=m.e- i.b+1;
        return new Interval(m.b, i.e);
    }

    public int count() {
        return count;
    }

    

    private static class Interval implements Comparable<Interval> {
        final int b;
        final int e;

        public Interval(int b, int e) {
            this.b = b;
            this.e = e;
        }


        @Override
        public int compareTo(Interval o) {
            return Integer.compare(b, o.b);
        }
    }
}
