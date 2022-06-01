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

        for (int i = 0; i < mathExpression.length(); i++) {

            char c = mathExpression.charAt(i);
            stack.push(c);
            if (stack.isEmpty()) {
                printError(i, 4);
            } else {
                
            }
        }
        return error;
    }

    public static void loadPair() {
        pair.put('}', '{');
        pair.put(')', '(');
    }

    public static void printError(int location, int errorNo) {

        for (int j = 0; j < location; j++) {
            System.out.print(" ");
        }
        System.out.print("^ ");
        System.out.println(errorMessage.get(errorNo));
    }
    public static void loadErrorMessage() {

        errorMessage.put(1, " } expected");
        errorMessage.put(2, " ) expected");
        errorMessage.put(3, " Incomplete Expression");
        errorMessage.put(4, " Expression is Empty");

    }
}
