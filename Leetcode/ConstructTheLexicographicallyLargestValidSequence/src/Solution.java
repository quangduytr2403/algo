import java.util.*;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int lenSeq = 2 * n - 1;
        int[] seq = new int[lenSeq]; // Initialize with empty values (0)
        Set<Integer> used = new HashSet<>(); // Tracks numbers used in sequence

        if (backtrack(seq, used, n, 0)) {
            return seq;
        }
        return new int[0]; // Should never reach here
    }

    private boolean backtrack(int[] seq, Set<Integer> used, int n, int i) {
        if (i == seq.length) {
            return true; // Filled all of the sequence
        }
        if (seq[i] != 0) {
            return backtrack(seq, used, n, i + 1); // Already filled index, check next
        }

        for (int num = n; num > 0; num--) { // Try using num at index, from n to 1
            if (used.contains(num)) {
                continue; // Already used num in sequence
            }

            int nxt = (num > 1) ? i + num : i; // Second occurrence of num

            if (nxt >= seq.length || seq[nxt] != 0) {
                continue; // Invalid second index
            }

            seq[i] = seq[nxt] = num; // Set two occurrences of num
            used.add(num);

            if (backtrack(seq, used, n, i + 1)) {
                return true;
            }

            seq[i] = seq[nxt] = 0; // Couldn't fill rest, reset sequence
            used.remove(num);
        }
        return false; // No num option led to a valid sequence
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructDistancedSequence(18)));
    }
}
