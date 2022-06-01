import java.util.*;
public class MyExpressionTest {

    static String mathExpression;
    static boolean run = true;
    static boolean error = false;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (run) {

            mathExpression = "";

            System.out.printf("\nEnter a math expression: ");
            mathExpression = input.nextLine();

            if (mathExpression.equals("0")) {
                System.out.println("Bye!");
                run = false;
            } else {
                ExpressionEvaluation ee = new ExpressionEvaluation();
                error = ee.expressionEvaluation(mathExpression);
                if (!error) {
                    InfixToPostfix i2p = new InfixToPostfix();
                    String postfix = i2p.infix2postfix(mathExpression);

                    PostfixEvaluation pe = new PostfixEvaluation();
                    int result = pe.postfixEvaluation(postfix);
                    System.out.println("infix: " + mathExpression);
                    System.out.println("postfix: " + postfix);
                    System.out.println("result: " + result);
                }
            }
        }
    }
}
