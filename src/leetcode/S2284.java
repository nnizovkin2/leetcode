package leetcode;

import java.util.HashMap;
import java.util.Map;

public class S2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> m=new HashMap<>();
        for(int i=0;i<senders.length;i++) {
            int wn=1;
            char[] ma=messages[i].toCharArray();
            for(int j=0;j<ma.length;j++) {
                if(ma[j]==' ') wn++;
            }

            m.put(senders[i], m.getOrDefault(senders[i], 0)+wn);
        }

        String res="";
        int max=0;
        for(var e: m.entrySet()) {
            if(max<e.getValue()) {
                res=e.getKey();
                max=e.getValue();
            } else if(max==e.getValue()&&e.getKey().compareTo(res)>0){
                res=e.getKey();
            }
        }

        return res;
    }
}
