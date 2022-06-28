package leetcode;

import java.util.Arrays;
import java.util.Comparator;

//[-1,0,0,1,1,2]
//"abacbe"
public class S2246 {
    public static void main(String[] args) {
//        System.out.println(new S2246().longestPath(new int[]{-1,0,0,1,1,2}, "abacbe"));
//        System.out.println(new S2246().longestPath(new int[]{-1,0,0,0}, "aabc"));
        System.out.println(new S2246().longestPath(new int[]{-1,4,1,0,0}, "abcde"));
    }

    public int longestPath(int[] parent, String s) {
        int[] copy = Arrays.copyOf(parent,parent.length);
        boolean[] v = new boolean[parent.length];
        v[0]=true;
        Arrays.sort(copy);

        char[] a = new char[s.length()];
        char[] charStr = s.toCharArray();
        a[0]=s.charAt(0);

        for (int i = 1; i < parent.length; i++) {
            int p = parent[i];
            int pos = Arrays.binarySearch(copy, p);
            if(v[pos]) {
                while(v[++pos]);
            } else {
                while(pos>0&&copy[pos-1]==copy[pos]&&!v[pos-1]&&!v[--pos]);
            }
            v[pos]=true;
            a[i]=charStr[pos];
        }
        parent=copy;

        boolean[] visited = new boolean[parent.length];
        int res = 0;
        int[] fl = new int[parent.length];
        for (int i = parent.length-1; i>=0; i--) {
            if(visited[i]) {
                continue;
            }
            int rp = 1;
            char cur = a[i];
            int p = parent[i];
            visited[i]=true;
            int j = i;
            fl[j]=rp;
            while(p!=-1&&cur!=a[p]&&!visited[p]) {
                rp++;
                j=p;
                cur=a[j];
                fl[j]=rp;
                p=parent[j];
                visited[j]=true;
            }

            if(p!=-1&&visited[p]&&cur!=a[p]) {
                rp+=fl[p];
            }

            if(rp>res) {
                res=rp;
            }
        }

        return res;
    }
}
