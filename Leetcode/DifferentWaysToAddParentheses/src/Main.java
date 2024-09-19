import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return calc(expression);
    }

    private List<Integer> calc(String expression) {
        if (expression.length() < 3) return List.of(Integer.parseInt(expression));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                List<Integer> left = calc(expression.substring(0, i));
                List<Integer> right = calc(expression.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '-':
                                res.add(l - r);
                                break;
                            case '+':
                                res.add(l + r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}