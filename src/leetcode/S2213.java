package leetcode;

public class S2213 {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree st = new SegmentTree(s);
        char[] queries = queryCharacters.toCharArray();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            st.update(queryIndices[i], queries[i]);
            res[i] = st.max();
        }
        return res;
    }

    private static class SegmentTree {
        Cell[] a;
        char[] s;

        public SegmentTree(String s) {
            a = new Cell[s.length() * 4];
            this.s = s.toCharArray();
            build(1, 0, s.length() - 1);
        }

        private void build(int i, int start, int end) {
            if(i==76) {
                System.out.println();
            }
            if (start == end) {
                a[i] = new Cell(start, start, start, start, s[start], s[start], 1);
                return;
            }

            int mid = (start + end) / 2;
            build(i * 2, start, mid);
            build(i * 2 + 1, mid + 1, end);
            merge(i, start, mid, end);
        }

        public void update(int pos, char ch) {
            update(1, pos, ch);
        }


        public int max() {
            return a[1].max;
        }

        private void update(int i, int pos, char ch) {
            if (a[i].start == a[i].end) {
                a[i].leftCh = ch;
                a[i].rightCh = ch;
                return;
            }
            int mid = (a[i].start + a[i].end) / 2;
            if (pos <= mid) {
                update(i * 2, pos, ch);
            } else {
                update(i * 2 + 1, pos, ch);
            }
            merge(i, a[i].start, mid, a[i].end);
        }

        private void merge(int i, int start, int mid, int end) {
            int max = Math.max(a[i * 2].max, a[i * 2 + 1].max);
            int mc = a[i * 2 + 1].left - a[i * 2].right + 1;
            int left = a[i * 2].left;
            int right = a[i * 2 + 1].right;
            if (a[i * 2].rightCh == a[i * 2 + 1].leftCh && max < mc) {
                max = mc;
                if (a[i * 2].max == a[i * 2].end - a[i * 2].start + 1) {
                    left = a[i * 2 + 1].left;
                }
                if (a[i * 2 + 1].max == a[i * 2 + 1].end - a[i * 2 + 1].start + 1) {
                    right = a[i * 2].right;
                }
            }
            a[i] = new Cell(start, end, left, right, a[i * 2].leftCh, a[i * 2 + 1].rightCh, max);
        }
    }

    private static class Cell {
        int start;
        int end;
        int left;
        int right;
        char leftCh;
        char rightCh;
        int max;

        public Cell(int start, int end, int left, int right, char leftCh, char rightCh, int max) {
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
            this.leftCh = leftCh;
            this.rightCh = rightCh;
            this.max = max;
        }
    }
}
