import java.util.ArrayList;
import java.util.List;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String res = "";
        List<Integer[]> l = new ArrayList<>();
        l.add(new Integer[]{(int) 'a', a});
        l.add(new Integer[]{(int) 'b', b});
        l.add(new Integer[]{(int) 'c', c});
        l.sort((l1, l2) -> l2[1] - l1[1]);
        while (true) {
            boolean haveValid = false;

            for (int i = 0; i < l.size(); i++) {
                Integer[] item = l.get(i);
                int limit = item[1];
                char character = (char)((int) item[0]);

                if (checkValid(res + character) && limit > 0) {
                    res += character;
                    l.remove(i);
                    l.add(new Integer[]{(int) character, limit - 1});
                    haveValid = true;
                    break;
                }
            }

            if (haveValid) {
                l.sort((l1, l2) -> l2[1] - l1[1]);
            } else break;
        }

        return res;
    }

    public boolean checkValid (String s) {
        return !s.contains("aaa") && !s.contains("bbb") && !s.contains("ccc");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(1, 1, 7));
    }
}