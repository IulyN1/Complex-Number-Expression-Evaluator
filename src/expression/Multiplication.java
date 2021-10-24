package expression;

import domain.ComplexNumber;

public class Multiplication extends ComplexExpression{
    // Constructor for Multiplication class that extends ComplexExpression
    // operation - Operation
    // args - array of ComplexNumber
    public Multiplication(Operation operation, ComplexNumber[] args) {
        super(operation, args);
    }

    // Overridden method that executes one operation of multiplication between 2 complex numbers
    // nr1 - ComplexNumber
    // nr2 - ComplexNumber
    @Override
    public void executeOneOperation(ComplexNumber nr1, ComplexNumber nr2) {
        nr1.multiply(nr2);
    }
}
