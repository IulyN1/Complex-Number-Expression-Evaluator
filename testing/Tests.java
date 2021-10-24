import domain.ComplexNumber;
import expression.*;
import factory.ExpressionFactory;
import org.junit.Test;
import parser.ExpressionParser;
import validation.Validator;

// Tests class used for testing purposes
public class Tests {
    // Function that tests the Validator class
    @Test
    public void test_validation(){
        String[] args = {"2+3*i","+","-2-i"};
        Validator validator = new Validator(args);
        boolean ok = validator.validate();
        assert(ok);
        String[] args2 = {"2+3*i","+"};
        validator = new Validator(args2);
        boolean ok2 = validator.validate();
        assert(!ok2);
        String[] args3 = {"2+3.3*i","+","i"};
        validator = new Validator(args3);
        boolean ok3 = validator.validate();
        assert(ok3);
        String[] args4 = {"2+3*i","k","i"};
        validator = new Validator(args4);
        boolean ok4 = validator.validate();
        assert(!ok4);
        String[] args5 = {"2.5+3*i","-","0+i"};
        validator = new Validator(args5);
        boolean ok5 = validator.validate();
        assert(ok5);
        String[] args6 = {"2+3.5*i","-","02+i"};
        validator = new Validator(args6);
        boolean ok6 = validator.validate();
        assert(!ok6);
        String[] args7 = {"2+3.5*i","-","12+i","+","2+2*i"};
        validator = new Validator(args7);
        boolean ok7 = validator.validate();
        assert(!ok7);
    }

    // Function that tests the ComplexNumber class
    @Test
    public void test_complexNumber(){
        ComplexNumber nr1 = new ComplexNumber(2,3);
        ComplexNumber nr2 = new ComplexNumber(-1,1);
        assert(nr1.getRe()==2);
        assert(nr1.getIm()==3);
        ComplexNumber nr = new ComplexNumber(2,3);
        nr.add(nr2);
        assert(nr.getRe()==1);
        assert(nr.getIm()==4);
        nr = new ComplexNumber(2,3);
        nr.subtract(nr2);
        assert(nr.getRe()==3);
        assert(nr.getIm()==2);
        nr = new ComplexNumber(2,3);
        nr.multiply(nr2);
        assert(nr.getRe()==-5);
        assert(nr.getIm()==-1);
        nr = new ComplexNumber(2,3);
        nr.divide(nr2);
        assert(nr.getRe()==0.5);
        assert(nr.getIm()==-2.5);
        String r1 = nr2.toString();
        assert(r1.equals("-1.0+i"));
        String r2 = nr.toString();
        assert(r2.equals("0.5-2.5i"));
        String r3 = nr1.toString();
        assert(r3.equals("2.0+3.0i"));
    }

    // Function that tests the Addition class
    @Test
    public void test_addition(){
        ComplexNumber nr1 = new ComplexNumber(2,3);
        ComplexNumber nr2 = new ComplexNumber(-1,1);
        ComplexNumber[] numbers = {nr1,nr2};
        Addition addition = new Addition(Operation.ADDITION,numbers);
        addition.executeOneOperation(nr1,nr2);
        assert(nr1.getRe()==1);
        assert(nr1.getIm()==4);
    }

    // Function that tests the Subtraction class
    @Test
    public void test_subtraction(){
        ComplexNumber nr1 = new ComplexNumber(2,3);
        ComplexNumber nr2 = new ComplexNumber(-1,1);
        ComplexNumber[] numbers = {nr1,nr2};
        Subtraction subtraction = new Subtraction(Operation.SUBTRACTION,numbers);
        subtraction.executeOneOperation(nr1,nr2);
        assert(nr1.getRe()==3);
        assert(nr1.getIm()==2);
    }

    // Function that tests the Multiplication class
    @Test
    public void test_multiplication(){
        ComplexNumber nr1 = new ComplexNumber(2,3);
        ComplexNumber nr2 = new ComplexNumber(-1,1);
        ComplexNumber[] numbers = {nr1,nr2};
        Multiplication multiplication = new Multiplication(Operation.MULTIPLICATION,numbers);
        multiplication.executeOneOperation(nr1,nr2);
        assert(nr1.getRe()==-5);
        assert(nr1.getIm()==-1);
    }

    // Function that tests the Division class
    @Test
    public void test_division(){
        ComplexNumber nr1 = new ComplexNumber(2,3);
        ComplexNumber nr2 = new ComplexNumber(-1,1);
        ComplexNumber[] numbers = {nr1,nr2};
        Division division = new Division(Operation.DIVISION,numbers);
        division.executeOneOperation(nr1,nr2);
        assert(nr1.getRe()==0.5);
        assert(nr1.getIm()==-2.5);
    }

    // Function that tests the ExpressionFactory class
    @Test
    public void test_expressionFactory(){
        ExpressionFactory factory = ExpressionFactory.getInstance();
        ComplexNumber nr1 = new ComplexNumber(2,3);
        ComplexNumber nr2 = new ComplexNumber(-1,1);
        ComplexNumber[] numbers = {nr1,nr2};

        Operation addition = Operation.ADDITION;
        try {
            factory.createExpression(addition, numbers);
        }
        catch (Exception ignored){}

        Operation subtraction = Operation.SUBTRACTION;
        try {
            factory.createExpression(subtraction, numbers);
        }
        catch (Exception ignored){}

        Operation multiplication = Operation.MULTIPLICATION;
        try {
            factory.createExpression(multiplication, numbers);
        }
        catch (Exception ignored){}

        Operation division = Operation.DIVISION;
        try {
            factory.createExpression(division, numbers);
        }
        catch (Exception ignored){}
    }

    // Function that tests the ExpressionParser class
    @Test
    public void test_expressionParser(){
        String[] args = {"2+3*i","+","-1-2*i","+","i","+","-i","+","2*i","+","2+i"};
        ExpressionParser parser = new ExpressionParser(args);
        try {
            ComplexExpression expression = parser.parse();
            assert(expression.execute().toString().equals("3.0+4.0i"));
        }
        catch (Exception ignored){}

        String[] args1 = {"2+3*i","-","-1-i"};
        ExpressionParser parser1 = new ExpressionParser(args1);
        try {
            ComplexExpression expression1 = parser1.parse();
            assert(expression1.execute().toString().equals("3.0+4.0i"));
        }
        catch (Exception ignored){}

        String[] args2 = {"2+3*i","*","-1-i"};
        ExpressionParser parser2 = new ExpressionParser(args2);
        try {
            ComplexExpression expression2 = parser2.parse();
            assert(expression2.execute().toString().equals("-5.0-i"));
        }
        catch (Exception ignored){}

        String[] args3 = {"2+3*i","/","-1-i"};
        ExpressionParser parser3 = new ExpressionParser(args3);
        try {
            ComplexExpression expression3 = parser3.parse();
            assert(expression3.execute().toString().equals("0.5-2.5i"));
        }
        catch (Exception ignored){}
    }
}
