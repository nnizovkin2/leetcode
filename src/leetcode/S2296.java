package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

class S2296 {
    LinkedList<Character> l;
    ListIterator<Character> it;

    public S2296() {
        this.l=new LinkedList<>();
        it=l.listIterator();
    }

    public void addText(String text) {
        char[] a=text.toCharArray();
        for (char c: a) {
            it.add(c);
        }
    }

    public int deleteText(int k) {
        int res=0;
        while(it.hasPrevious()&&--k>=0) {
            it.previous();
            it.remove();
            res++;
        }

        return res;
    }

    public String cursorLeft(int k) {
        while(it.hasPrevious()&&--k>=0) {
            it.previous();
        }

        return getPrev();
    }

    public String cursorRight(int k) {
        while(it.hasNext()&&--k>=0) {
            it.next();
        }

        return getPrev();

    }

    private String getPrev() {
        char[] a=new char[10];
        int i=10;
        while(it.hasPrevious()&&i-->0) {
            a[9-i]=it.previous();
        }

        if(i<0) {
            i++;
        }
        a= Arrays.copyOf(a, 10-i);
        for (int j=0; j<a.length/2; j++) {
            char t=a[j];
            a[j]=a[a.length-j-1];
            a[a.length-j-1]=t;
        }

        String res=new String(a);

        while(i++<10) {
            it.next();
        }

        return res;
    }

}
