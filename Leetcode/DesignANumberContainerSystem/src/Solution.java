import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {

    Map<Integer, TreeSet<Integer>> pos;
    Map<Integer, Integer> m;

    public NumberContainers() {
        pos = new HashMap<>();
        m = new HashMap<>();
    }

    public void change(int index, int number) {
        if (m.containsKey(index)) {
            pos.get(m.get(index)).remove(index);
            if (pos.get(m.get(index)).isEmpty()) pos.remove(m.get(index));
        }
        m.put(index, number);

        if (!pos.containsKey(number)) {
            pos.put(number, new TreeSet<>());
        }
        pos.get(number).add(index);
    }

    public int find(int number) {
        return pos.containsKey(number) ? pos.get(number).first() : -1;
    }
}

public class Solution {
    public static void main(String[] args) {
        NumberContainers n = new NumberContainers();
        n.change(1, 10);
        System.out.println(n.find(10));
        n.change(1, 20);
        System.out.println(n.find(10));
        System.out.println(n.find(20));
        System.out.println(n.find(30));
    }
}