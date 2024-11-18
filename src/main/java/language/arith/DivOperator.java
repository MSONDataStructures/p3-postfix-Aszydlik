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
        Operand<Integer> op0 = this.getOp0();
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
       if(operand == null) throw new NullPointerException("Operand cannot be null.");
       if(i != 0 && i !=1) throw new IllegalArgumentException("Operand must be 0 or 1.");
       if(i == 0 ){
           if(op1.getValue() != null ) throw new IllegalArgumentException("Operand cannot be null.");
           op1 = operand;
       }
       if(i == 1 ){
           if(operand.getValue() == 0) throw new IllegalArgumentException("Operand cannot be zero.");
           op1 = operand;
       }

        /**
         *Operand<Integer> second = this.getOp1();
        *if( second.getValue() == 0) throw new IllegalStateException("Could not perform operation prior to operands being set.");
        *second = operand;
         */
    }

}

