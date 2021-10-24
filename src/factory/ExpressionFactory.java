package factory;

import expression.*;
import domain.ComplexNumber;

// ExpressionFactory class that follows the Factory Method and Singleton Design Patterns
public class ExpressionFactory {
    private static final ExpressionFactory instance = new ExpressionFactory();

    // Private constructor for ExpressionFactory (Singleton purposes)
    private ExpressionFactory(){}

    // Method that returns the only instance created of ExpressionFactory
    // returns - ExpressionFactory
    public static ExpressionFactory getInstance() {
        return instance;
    }

    // Method that creates an expression regarding type of operator
    // operation - Operation
    // args - array of ComplexNumber
    // throws Exception if the operation is not known
    public ComplexExpression createExpression(Operation operation, ComplexNumber[] args) throws Exception {
        if(operation == Operation.ADDITION){
            return new Addition(operation,args);
        }
        if(operation == Operation.SUBTRACTION){
            return new Subtraction(operation,args);
        }
        if(operation == Operation.MULTIPLICATION){
            return new Multiplication(operation,args);
        }
        if(operation == Operation.DIVISION){
            return new Division(operation,args);
        }
        throw new Exception("Unknown operation!");
    }
}
