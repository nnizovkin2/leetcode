package leetcode;

public class S2264 {
    public String largestGoodInteger(String num) {
        char[] a = num.toCharArray();
        int prev = a[0];
        int i = -1;
        int c = 1;
        for(int j = 1; j < a.length; j++) {
            if(prev==a[j]) {
                c++;
                if(c>2&&i<a[j]) {
                    i=a[j];
                }
                continue;
            }
            c=1;
            prev=a[j];

        }

        if(i!=-1) {
            return new String(new char[]{(char)i,(char)i,(char)i});
        }
        return "";
    }

    char[] invRep(int i) {
        int t = i;
        int k = 0;
        while(t>0) {
            t/=10;
            k++;
        }
        char[] res = new char[k];
        k=0;
        while(i>0) {
            res[k++]=(char)(i%10);
            i/=10;
        }

        return res;
    }
}
