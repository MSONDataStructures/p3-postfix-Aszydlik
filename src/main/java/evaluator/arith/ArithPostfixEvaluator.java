package evaluator.arith;

import evaluator.Evaluator;
import evaluator.IllegalPostfixExpressionException;
import language.Operand;
import language.Operator;
import language.arith.UnaryOperator;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;

/**
 * An {@link ArithPostfixEvaluator} is a post fix evaluator
 * over simple arithmetic expressions.
 */
public class ArithPostfixEvaluator implements Evaluator<Integer> {

    private final StackInterface<Operand<Integer>> stack;

    /**
     * Constructs an {@link ArithPostfixEvaluator}.
     */
    public ArithPostfixEvaluator() {
        //TODO Initialize to your LinkedStack
        stack = new LinkedStack<>();
    }

    /**
     * Evaluates a postfix expression.
     * @return the result
     */
    @Override
    public Integer evaluate(String expr) {
        ArithPostfixParser parser = new ArithPostfixParser(expr);
        while (parser.hasNext()) {
            switch (parser.nextType()) {
                case OPERAND:
                    Operand<Integer> operand = parser.nextOperand();
                    stack.push(operand);
                    break;
                case OPERATOR:

                    Operator<Integer> operator = parser.nextOperator();

                    if (operator instanceof UnaryOperator) {

                        if (stack.isEmpty()) {
                            throw new IllegalPostfixExpressionException("Not enough operands for unary operator.");
                        }
                        Operand<Integer> operandToNegate = stack.pop();
                        operator.setOperand(0, operandToNegate);
                        Operand<Integer> result = operator.performOperation();
                        stack.push(result);
                    }
                    else {
                        if (stack.size() < 2) {
                            throw new IllegalPostfixExpressionException("Not enough operands for binary operator.");
                        }
                        Operand<Integer> operand2 = stack.pop();
                        Operand<Integer> operand1 = stack.pop();
                        operator.setOperand(0, operand1);
                        operator.setOperand(1, operand2);

                        Operand<Integer> result = operator.performOperation();
                        stack.push(result);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected token type");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid expression: too many operands");
        }
        if (stack.isEmpty()) {
            throw new IllegalPostfixExpressionException("Invalid expression: not enough operands");
        }
        //TODO What do we return?
        return stack.pop().getValue();
    }
}
