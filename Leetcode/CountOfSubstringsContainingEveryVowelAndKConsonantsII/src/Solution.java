import java.util.Arrays;

class Solution {
    public long countOfSubstrings(String word, int k) {
        String vowels = "aeiou";
        int leftPointer = 0, midPointer = 0, distinctVowelCount = 0;
        int[] vowelCount = new int[6];
        int[] countedVowels = new int[6];
        long result = 0;

        for (int i = 0; i < word.length(); i++) {
            int vowelIndex = vowels.indexOf(word.charAt(i)) + 1;
            vowelCount[vowelIndex]++;
            distinctVowelCount += (vowelCount[vowelIndex] == 1 && vowelIndex > 0) ? 1 : 0;

            while (vowelCount[0] > k) {
                int leftVowelIndex = vowels.indexOf(word.charAt(leftPointer)) + 1;
                vowelCount[leftVowelIndex]--;
                distinctVowelCount -= (vowelCount[leftVowelIndex] == 0 && leftVowelIndex > 0) ? 1 : 0;
                leftPointer++;
            }

            if (distinctVowelCount == 5 && vowelCount[0] == k) {
                if (midPointer < leftPointer) {
                    midPointer = leftPointer;
                    Arrays.fill(countedVowels, 0);
                }
                while (true) {
                    int midVowelIndex = vowels.indexOf(word.charAt(midPointer)) + 1;
                    if (midVowelIndex == 0 || vowelCount[midVowelIndex] - countedVowels[midVowelIndex] == 1) break;
                    countedVowels[midVowelIndex]++;
                    midPointer++;
                }
                result += midPointer - leftPointer + 1;
            }
        }

        return result;
    }
}