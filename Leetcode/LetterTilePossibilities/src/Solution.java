import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<String> r = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        for (int i = 1; i <= tiles.length(); i++) {
            gen(tiles, new char[i], 0, new boolean[tiles.length()]);
        }

        return r.size();
    }

    public void gen(String s, char[] a, int index, boolean[] use) {
        if (index == a.length) {
            r.add(new String(a));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!use[i]) {
                a[index] = s.charAt(i);
                use[i] = true;
                gen(s, a, index + 1, use);
                a[index] = '1';
                use[i] = false;
            }
        }
    }
}