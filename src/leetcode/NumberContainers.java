package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {
    private HashMap<Integer, Integer> m=new HashMap<>();
    private Map<Integer, TreeSet<Integer>> nInd=new HashMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {
        Integer num=m.remove(index);
        if(num!=null) {
            TreeSet<Integer> s=nInd.get(num);
            s.remove(index);
            if(s.isEmpty()) {
                nInd.remove(num);
            }
        }

        m.put(index,number);
        TreeSet<Integer> s = nInd.computeIfAbsent(number, k->new TreeSet<>());

        s.add(index);
    }

    public int find(int number) {
        TreeSet<Integer> s=nInd.get(number);
        if(s==null) {
            return -1;
        } else return s.first();
    }
}
