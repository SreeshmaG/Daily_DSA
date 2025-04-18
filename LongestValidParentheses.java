public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int left = 0, right = 0;

        // Left to Right pass
        for (char ch : s.toCharArray()) {
            if (ch == '(') left++;
            else right++;

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        // Right to Left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "((()";
        System.out.println("Longest valid parentheses length: " + longestValidParentheses(s));  // Output: 2
    }
}
