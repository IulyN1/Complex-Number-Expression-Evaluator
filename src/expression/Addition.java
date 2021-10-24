package expression;

import domain.ComplexNumber;

public class Addition extends ComplexExpression{
    // Constructor for Addition class that extends ComplexExpression
    // operation - Operation
    // args - array of ComplexNumber
    public Addition(Operation operation, ComplexNumber[] args) {
        super(operation, args);
    }

    // Overridden method that executes one operation of addition between 2 complex numbers
    // nr1 - ComplexNumber
    // nr2 - ComplexNumber
    @Override
    public void executeOneOperation(ComplexNumber nr1, ComplexNumber nr2) {
        nr1.add(nr2);
    }
}
