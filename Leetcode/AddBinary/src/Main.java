class Solution {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        String res = "";
        int remain = 0;
        for(int i = b.length() - 1; i >= 0; i--) {
            int bVal = Integer.parseInt(b.charAt(i) + "");
            int aVal = i - b.length() + a.length() >= 0 ? Integer.parseInt(a.charAt(i - b.length() + a.length()) + "") : 0;

            res = (bVal + aVal + remain) % 2 + res;
            remain = (bVal + aVal + remain) / 2;
        }

        return remain > 0 ? remain + res : res;
    }
}