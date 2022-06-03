import java.util.Stack;

public class PostfixEvaluation {
    public int postfixEvaluation(String postfix) {

        Stack<Integer> stack = new Stack<Integer>();
        int value;
        int result = 0;
        int newValue = 0;

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (c >= '0' && c <= '9') {
                value = c - '0';
                stack.push(value);
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                int value1 = stack.pop(); 
                int value2 = stack.pop();

                if (c == '+') {
                    newValue = value2 + value1;
                } else if (c == '-') {
                    newValue = value2 - value1;
                } else if (c == '*') {
                    newValue = value2 * value1;
                } else if (c == '/') {
                    newValue = value2 / value1;
                }
                stack.push(newValue);
            }
        }
        result = stack.pop();
        return result;
    }
}
