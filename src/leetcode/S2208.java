package leetcode;

public class S2208 {
    int halveArray(int[] a) {
        long sum = 0;

        double[] q = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            q[i] = a[i];
            sum+=a[i];
        }
        for (int i = q.length/2; i>=0; i--) {
            heapify(q, i);

        }
        double halfSum = sum/2.0;
        int r = 0;
        while(halfSum>0) {
            r++;
            q[0]/=2;
            halfSum-=q[0];
            heapify(q, 0);
        }

        return r;
    }

    void heapify(double[] a, int i) {
        while(true) {
            if(2*i>=a.length) {
                return;
            }

            int pos = 2*i+1>=a.length||a[2*i]>a[2*i+1]?2*i:2*i+1;
            if(a[i]<a[pos]) {
                double temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
                i=pos;
            } else {
                return;
            }
        }
    }
}
