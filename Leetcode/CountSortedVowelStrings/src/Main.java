class Solution {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}