class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        boolean[] uses = new boolean[10];

        if (gen(res, pattern, uses, 0)) {
            return res.toString();
        }

        return "";
    }

    public boolean gen(StringBuilder res, String pattern, boolean[] uses, int index) {
        if (index == pattern.length() + 1) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (!uses[i]) {
                int choose = -1;
                if (index == 0) {
                    choose = i;
                } else {
                    if (pattern.charAt(index - 1) == 'I') {
                        if (i > Integer.parseInt("" + res.charAt(index - 1))) choose = i;
                    } else {
                        if (i < Integer.parseInt("" + res.charAt(index - 1))) choose = i;
                    }
                }
                if (choose != -1) {
                    uses[choose] = true;
                    res.append(choose);
                    if (gen(res, pattern, uses, index + 1)) return true;
                    uses[choose] = false;
                    res.setLength(res.length() - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber("ID"));
    }
}