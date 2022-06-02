import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

    public static String post = "";
    public static HashMap<Character, Integer> precedence = new HashMap<>();
    public String infix2postfix(String infix) {
        loadPrecedence();
        Stack<Character> stack = new Stack<Character>();

        post = "";

        for (int j = 0; j < infix.length(); j++) {

            char c = infix.charAt(j);
            if (c >= '0' && c <= '9') {
                post+= c;
            } else if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}') {
                char top = stack.peek();
                if (top != '('){
                    while (!stack.isEmpty()) {
                        char p = stack.pop();
                        post+= p;
                    }
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && (precedence.get(c) >= stack.peek())) {
                    char p = stack.pop();
                    post+= p;
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            char p = stack.pop();
            post += p;
        }
        return post;
    }

    public static void loadPrecedence() {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', 0);
        precedence.put('{', 0);
    }
}