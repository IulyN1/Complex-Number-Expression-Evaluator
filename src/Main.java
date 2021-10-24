import expression.ComplexExpression;
import parser.ExpressionParser;
import validation.Validator;

public class Main {
    // Main function for running the program
    public static void main(String[] args) {
        Validator valid = new Validator(args);
        boolean ok = valid.validate();
        if(ok){
            System.out.println("The command line arguments are valid!\n");
            ExpressionParser parser = new ExpressionParser(args);
            try {
                ComplexExpression expression = parser.parse();
                System.out.println(expression.execute().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
