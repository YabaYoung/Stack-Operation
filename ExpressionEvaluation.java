import java.util.HashMap;
import java.util.Stack;

public class ExpressionEvaluation {
    static HashMap<Integer, String> errorMessage = new HashMap<>();
    static HashMap<Character, Character> pair = new HashMap<>();


    public boolean expressionEvaluation(String mathExpression) {
        loadErrorMessage();
        loadPair();
        System.out.println(mathExpression);

        Stack <Character> stack = new Stack<>();
        boolean error = false;
        char c;
        String statement = "";

        for (int i = 0; i < mathExpression.length(); i++) {

            c = mathExpression.charAt(i);
            statement += c;

            if (c == '(') {
                stack.push(c);
            }
            if (c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    printError(i, 5);
                    error = true;
                    break;
                } else {
                    char poppedChar = stack.pop();
                    if (!(poppedChar == pair.get(c))) {
                        printError(i, 1);
                        error = true;
                        break;
                    }
                }
            }
            if (c == '}') {
                if (stack.isEmpty()) {
                    printError(i, 5);
                    error = true;
                    break;
                } else {
                    char poppedChar = stack.pop();
                    if (!(poppedChar == pair.get(c))) {
                        printError(i, 2);
                        error = true;
                        break;
                    }
                }
            }
            if (i == mathExpression.length() - 1 && Character.isDigit(c) && !stack.isEmpty()) {
                printError(i, 5);
                error = true;
                break;
            }
            else if (mathExpression.charAt(mathExpression.length() - 1 ) == '(' && i == mathExpression.length() - 1
                    && !stack.isEmpty()) {
                printError(i, 5);
                error = true;
                break;
            }
            else if (mathExpression.charAt(mathExpression.length() - 1 ) == '{' && i == mathExpression.length() - 1
                    && !stack.isEmpty()) {
                printError(i, 5);
                error = true;
            }
        }

        return error;
    }

    public static void loadPair() {
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put('{', '}');
        pair.put('(', ')');
    }
    public static void printError(int location, int errorNo) {

        for (int j = 0; j < location; j++) {
            System.out.print(" ");
        }
        System.out.print("^");
        System.out.println(errorMessage.get(errorNo));
    }
    public static void loadErrorMessage() {

        errorMessage.put(1, " } expected");
        errorMessage.put(2, " ) expected");
        errorMessage.put(3, " { expected");
        errorMessage.put(4, " ( expected");
        errorMessage.put(5, " Incomplete Expression");
    }
}
