package expression;

import domain.ComplexNumber;

public class Subtraction extends ComplexExpression{
    // Constructor for Subtraction class that extends ComplexExpression
    // operation - Operation
    // args - array of ComplexNumber
    public Subtraction(Operation operation, ComplexNumber[] args) {
        super(operation, args);
    }

    // Overridden method that executes one operation of subtraction between 2 complex numbers
    // nr1 - ComplexNumber
    // nr2 - ComplexNumber
    @Override
    public void executeOneOperation(ComplexNumber nr1, ComplexNumber nr2) {
        nr1.subtract(nr2);
    }
}
