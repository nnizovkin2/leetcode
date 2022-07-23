package leetcode;

public class S2347 {
    public String bestHand(int[] ranks, char[] suits) {
        boolean isF=true;
        for(int i=1;i<5;i++) {
            if(suits[i-1]!=suits[i]) {
                isF=false;
                break;
            }
        }

        if(isF) {
            return "Flush";
        }

        int[] v=new int[15];
        for(int i=0;i<5;i++) {
            v[ranks[i]]++;
        }

        int r=0;
        for(int val: v) {
            if(val==2&&r==0) {
                r=1;
            } else if(val>2) {
                return "Three of a Kind";
            }
        }

        return r==1?"Pair":"High Card";
    }
}
