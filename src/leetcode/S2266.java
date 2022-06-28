package leetcode;

public class S2266 {
    public static void main(String[] args) {
        System.out.println(new S2266().countTexts("22233"));
    }

    public int countTexts(String pressedKeys) {
        int[] th = new int[pressedKeys.length()+1];
        int[] f = new int[pressedKeys.length()+1];
        int m = 1000000007;
        th[0]=1;
        f[0]=1;

        for (int i = 0; i < f.length-1; i++) {
            for (int j = 1; j < 5; j++) {
                if(i+j<f.length) {
                    f[i+j]=(f[i+j]+f[i])%m;
                    if(j<4) {
                        th[i + j]=(th[i + j]+th[i])%m;
                    }
                }
            }
        }

        char[] a = pressedKeys.toCharArray();

        char prev = 'q';
        long res = 1;
        int num = 1;
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if(c==prev) {
                num++;
                continue;
            }

            res=(res*(prev=='7'||prev=='9'?f[num]:th[num]))%m;
            prev=c;
            num=1;
        }

        res=(res*(prev=='7'||prev=='9'?f[num]:th[num]))%m;

        return (int)res;
    }
}
