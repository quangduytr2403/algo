import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0, first, last;
        char c;
        Map<Character, List<Integer>> m = new HashMap<>();
        Set<Character> st = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!m.containsKey(s.charAt(i))) m.put(s.charAt(i), new ArrayList<>());
            m.get(s.charAt(i)).add(i);
        }

        for (int i = 0; i < 26; i++) {
            c = (char) ('a' + i);
            if (!m.containsKey(c) || m.get(c).size() < 2) continue;
            first = m.get(c).get(0);
            last = m.get(c).get(m.get(c).size() - 1);

            st.clear();
            for (int j = first + 1; j <= last - 1; j++) {
                st.add(s.charAt(j));
            }

            res += st.size();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPalindromicSubsequence("aabca"));
    }
}