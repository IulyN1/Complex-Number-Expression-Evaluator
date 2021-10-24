package expression;

import domain.ComplexNumber;

public class Division extends ComplexExpression{
    // Constructor for Division class that extends ComplexExpression
    // operation - Operation
    // args - array of ComplexNumber
    public Division(Operation operation, ComplexNumber[] args) {
        super(operation, args);
    }

    // Overridden method that executes one operation of division between 2 complex numbers
    // nr1 - ComplexNumber
    // nr2 - ComplexNumber
    @Override
    public void executeOneOperation(ComplexNumber nr1, ComplexNumber nr2) {
        nr1.divide(nr2);
    }
}
