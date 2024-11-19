package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@link DivOperator} is an operator that performs integer division on two
 * integers.
 * @author jcollard, jddevaug
 */
public class DivOperator extends BinaryOperator<Integer> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Operand<Integer> performOperation() {
        Operand<Integer> op0 = this.getOp1();
        Operand<Integer> op1 = this.getOp1();
        if (op0 == null || op1 == null) {
            throw new IllegalStateException("Could not perform operation prior to operands being set.");
        }
        Integer result = op0.getValue() / op1.getValue();
        return new Operand<>(result);
    }
        // TODO: Follow the example from PlusOperator to override
        //   this method (from the version in BinaryOperator)
        //   for division.



    /**
     * {@inheritDoc}
     */
    @Override
    public void setOperand(int i, Operand<Integer> operand) {

        Operand<Integer> op1 = this.getOp1();

      if(i == 1 && op1.getValue() == 0) {
          throw new ArithmeticException("Division by zero");
      }
    }

}

