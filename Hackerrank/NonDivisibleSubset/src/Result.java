import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for(Integer i : s) m.put(i % k, m.getOrDefault(i % k, 0) + 1);
        for(Map.Entry<Integer,Integer> e : m.entrySet()) {
            if(e.getKey() == 0 || (k % 2 == 0 && e.getKey() == k / 2))  {
                res++;
                continue;
            }
            if(!m.containsKey(k - e.getKey())) {
                res += e.getValue();
                continue;
            }
            if (e.getKey() > k - e.getKey()) continue;
            res += Math.max(e.getValue(), m.get(k - e.getKey()));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Result.nonDivisibleSubset(7,
                List.of(278,576,496,727,410,124,338,149,209,702,282,718,771,575,436)));
    }
}