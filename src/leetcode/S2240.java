package leetcode;

import java.util.ArrayList;

public class S2240 {
    public static void main(String[] args) {
        S2240 s = new S2240();
        var nums = PrimeUtil.primesTill(10000);
        System.out.println(s.waysToBuyPensPencils(53, 5, 7));
        for (int i1 : nums) {
            for (int i2 : nums) {
                if(i1!=i2&&(i1+1)*(i2+1)/2+1!=s.waysToBuyPensPencils(i1*i2,i1,i2)) {
                    System.out.println(i1 + " " + i2);
                }
            }
        }
    }

    public long waysToBuyPensPencils(int t, int c1, int c2) {
        if(t<c1&&t<c2) {
            return 1;
        }

        if(c1>c2) {
            int temp = c1;
            c1=c2;
            c2=temp;
        }
        long res = 0;
        while(t>=0) {
            res+=t/c1+1;
            t-=c2;
        }
        return res;
    }

    public static class PrimeUtil {
        public static ArrayList<Integer> primesTill(int n) {
            ArrayList<Integer> res = new ArrayList<>();
            int i = 2;
            while (i <= n) {
                if(i % 10000000 == 0) {
                    System.out.println(System.currentTimeMillis());
                }
                boolean isPrime = true;
                int lim = (int)Math.sqrt(i) + 1;
                for (Integer p : res) {
                    if (i % p == 0) {
                        isPrime = false;
                        break;
                    }
                    if(p > lim) {
                        break;
                    }
                }
                if (isPrime) {
                    res.add(i);
                }
                i++;
            }

            return res;
        }

        public static boolean isPrime(long i) {
            long l = (long)Math.sqrt(i) + 1;
            for (long j = 2; j <= l; j++) {
                if(i % j == 0) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isPrime(long i, ArrayList<Integer> pn) {
            long l = (long)Math.sqrt(i) + 1;
            int size = pn.size();
            for (int d : pn) {
                if (d >= l) {
                    return true;
                }

                if (i % d == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
