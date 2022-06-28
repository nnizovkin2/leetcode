package leetcode;

import java.util.Arrays;

public class S2261 {
    public static void main(String[] args) {
        System.out.println(new S2261().countDistinct(new int[]{173, 21, 127, 154, 93, 44, 130, 102, 186, 200, 197, 29,
                85, 13, 16, 179, 34, 156, 128, 60, 2, 1, 11, 116, 174, 52, 185, 154, 127, 155, 24, 59, 103}, 15, 113));
    }
    public int countDistinct(int[] nums, int k, int p) {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append((char)num);
        }
        SuffixArray array = new SuffixArray(builder.toString(), 200);
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            int c = 0;
            for(int j=i;j<nums.length;j++) {
                c+=nums[j]%p==0?1:0;
                if(c>k) {
                    break;
                }
                res+=array.isThisFind(i, j+1)?1:0;
            }
        }

        return res;
    }

    private static class SuffixArray {
        int[] ind;
        char[] s;

        public SuffixArray(String str, int dlen) {
            s=str.toCharArray();
            ind = build(s, dlen);
        }

        public boolean contains(String p) {
            char[] a = p.toCharArray();
            int st=0,e=s.length-1,m;
            while(st<=e) {
                m=(st+e)>>>1;
                int c = compareTo(a,ind[m]);
                if(c==0) {
                    return true;
                }
                if(c<0) {
                    st=m+1;
                } else {
                    e=m-1;
                }
            }

            return false;
        }

        public boolean isThisFind(int sb, int se) {
            int st=0,e=s.length-1,m;
            while(st<=e) {
                m=(st+e)>>>1;
                int c = compareTo(sb,se,ind[m]);
                if(c==0) {
                    return ind[m]==sb;
                }
                if(c<0) {
                    st=m+1;
                } else {
                    e=m-1;
                }
            }

            return false;
        }

        int compareTo(int sst, int se, int st) {
            int l = Math.min(st-sst+se, s.length);
            for(int i=st; i<l; i++) {
                if(s[i]==s[i-st+sst]) continue;
                return s[i]<s[i-st+sst]?-1:1;
            }

            if(s.length<st+se-sst) {
                return -1;
            }

            return 0;
        }

        int compareTo(char[] p, int st) {
            int l = Math.min(st+p.length, s.length);
            for(int i=st; i<l; i++) {
                if(s[i]==p[i-st]) continue;
                return s[i]<p[i-st]?-1:1;
            }

            if(s.length<st+p.length) {
                return -1;
            }

            return 0;
        }

        //take from here https://e-maxx.ru/algo/suffix_array
        private int[] build(char[] str, int dlen) {
            char[] s = Arrays.copyOf(str, str.length+1);
            int n = s.length;

            int[] ind = new int[n];
            int[] cnt = new int[dlen+1];
            int[] c = new int[n];
            for (int i=0; i<n; ++i)
                ++cnt[s[i]];
            for (int i=1; i<dlen+1; ++i)
                cnt[i] += cnt[i-1];
            for (int i=0; i<n; ++i)
                ind[--cnt[s[i]]] = i;
            c[ind[0]] = 0;
            int classes = 1;
            for (int i=1; i<n; ++i) {
                if (s[ind[i]] != s[ind[i-1]])  ++classes;
                c[ind[i]] = classes-1;
            }

            int[] pn = new int[n];
            int[] cn = new int[n];
            for (int h=0; (1<<h)<n; ++h) {
                for (int i=0; i<n; ++i) {
                    pn[i] = ind[i] - (1<<h);
                    if (pn[i] < 0)  pn[i] += n;
                }
                Arrays.fill(cnt, 0);
                for (int i=0; i<n; ++i)
                    ++cnt[c[pn[i]]];
                for (int i=1; i<classes; ++i)
                    cnt[i] += cnt[i-1];
                for (int i=n-1; i>=0; --i)
                    ind[--cnt[c[pn[i]]]] = pn[i];
                cn[ind[0]] = 0;
                classes = 1;
                for (int i=1; i<n; ++i) {
                    int mid1 = (ind[i] + (1<<h)) % n,  mid2 = (ind[i-1] + (1<<h)) % n;
                    if (c[ind[i]] != c[ind[i-1]] || c[mid1] != c[mid2])
                        ++classes;
                    cn[ind[i]] = classes-1;
                }
                System.arraycopy(cn, 0, c, 0, n);
            }

            int[] res = new int[n-1];
            System.arraycopy(ind, 1, res, 0, n-1);
            return res;
        }
    }
}
