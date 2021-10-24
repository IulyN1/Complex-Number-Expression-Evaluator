package expression;

import domain.ComplexNumber;

// Abstract class ComplexExpression that follows Template Method Design Pattern
public abstract class ComplexExpression {
    private final Operation operation;
    private final ComplexNumber[] args;

    // Constructor for the ComplexExpression class
    // operation - Operation
    // args - array of ComplexNumber
    public ComplexExpression(Operation operation, ComplexNumber[] args){
        this.operation = operation;
        this.args = args;
    }

    // Abstract method that executes one operation between 2 complex numbers
    // nr1 - ComplexNumber
    // nr2 - ComplexNumber
    public abstract void executeOneOperation(ComplexNumber nr1, ComplexNumber nr2);

    // Final method that calls the executeOneOperation method for every pair of arguments to return the result
    // returns a ComplexNumber
    public final ComplexNumber execute(){
        for(int i=1; i< args.length; i++){
            executeOneOperation(args[0],args[i]);
        }
        return args[0];
    }
}
