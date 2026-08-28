import java.util.Arrays;

public class Solution {
    private String result = null;
    private int n;
    private String targetStr;

    public String lexPalindromicPermutation(String s, String target) {
        this.n = s.length();
        this.targetStr = target;
        this.result = null;

        // 1. Calculate character frequencies
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // 2. Palindromic verification
        int oddCount = 0;
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }
        if (oddCount > 1) {
            return "";
        }

        // 3. Prepare structures for DFS
        int halfLen = n / 2;
        char[] half = new char[halfLen];
        int middleElement = (n % 2 != 0) ? oddChar : -1;

        // Decrement odd counts to treat characters as pairs for the outer shells
        if (middleElement != -1) {
            counts[middleElement]--;
        }
        for (int i = 0; i < 26; i++) {
            counts[i] /= 2;
        }

        // 4. Backtracking to find the optimal arrangement
        dfs(0, half, counts, middleElement, true);

        return result == null ? "" : result;
    }

    private boolean dfs(int idx, char[] half, int[] counts, int middleElement, boolean isPrefixSame) {
        // Base case: First half is successfully filled
        if (idx == half.length) {
            String candidate = constructFullPalindrome(half, middleElement);
            if (candidate.compareTo(targetStr) > 0) {
                result = candidate;
                return true; // Stop early because we search in ascending character order
            }
            return false;
        }

        int startChar = isPrefixSame ? (targetStr.charAt(idx) - 'a') : 0;

        for (int c = startChar; c < 26; c++) {
            if (counts[c] > 0) {
                counts[c]--;
                half[idx] = (char) (c + 'a');

                boolean nextSame = isPrefixSame && (c == startChar);

                // If we branched higher than target, we can fill the rest greedily
                if (!nextSame && isPrefixSame) {
                    if (fillGreedily(idx + 1, half, counts, middleElement)) {
                        return true;
                    }
                } else {
                    if (dfs(idx + 1, half, counts, middleElement, nextSame)) {
                        return true;
                    }
                }

                // Backtrack
                counts[c]++;
            }
        }
        return false;
    }

    // Helper to finish the string using the absolute smallest available letters
    private boolean fillGreedily(int idx, char[] half, int[] counts, int middleElement) {
        int[] tempCounts = counts.clone();
        int charPtr = 0;

        for (int i = idx; i < half.length; i++) {
            while (charPtr < 26 && tempCounts[charPtr] == 0) {
                charPtr++;
            }
            half[i] = (char) (charPtr + 'a');
            tempCounts[charPtr]--;
        }

        String candidate = constructFullPalindrome(half, middleElement);
        if (candidate.compareTo(targetStr) > 0) {
            result = candidate;
            return true;
        }
        return false;
    }

    // Helper to create the symmetrical full palindrome
    private String constructFullPalindrome(char[] half, int middleElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(half);
        if (middleElement != -1) {
            sb.append((char) (middleElement + 'a'));
        }
        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }
        return sb.toString();
    }
}