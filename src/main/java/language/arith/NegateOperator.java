package language.arith;

import language.Operand;

/**
 * The {@link NegateOperator} is an operator that performs negation
 * on a single integer.
 * @author jcollard, jddevaug
 */
public class NegateOperator extends UnaryOperator<Integer> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Operand<Integer> performOperation() {
        Operand<Integer> op0 = this.getOp0();

        Integer result = op0.getValue() ;

        result = -result;

        return new Operand<>(result);
        // TODO: Follow the example from PlusOperator to override
        //   this method (from the version in UnaryOperator)
        //   for negation.

    }
}

