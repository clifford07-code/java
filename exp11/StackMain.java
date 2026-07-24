package exp11;

import java.util.Scanner;
import java.util.Stack;
class PostfixEvaluator {
    String expression;
    PostfixEvaluator() {
        expression = "";
    }
    PostfixEvaluator(String expression) {
        this.expression = expression;
    }
    double evaluate() {
        Stack<Double> stack = new Stack<>();
        String tokens[] = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public String toString() {
        return "Postfix Expression: " + expression;
    }
}
public class StackMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String exp = sc.nextLine();
        PostfixEvaluator obj = new PostfixEvaluator(exp);
        System.out.println(obj);
        double result = obj.evaluate();
        System.out.println("Result = " + result);
    }
}