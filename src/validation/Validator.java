package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Validator class responsible for validating the command line arguments
public class Validator {
    private final String[] args;
    private final Pattern pattern = Pattern.compile("((-?[1-9][0-9]*(\\.[0-9]+)?[+-])|(-?0(\\.[0-9]+)?[+-])|([+-]?))" +
            "(([1-9][0-9]*(\\.[0-9]+)?\\*i)|(0(\\.[0-9]+)?\\*i)|i)");

    // Constructor for the Validator class
    // args - array of String objects
    public Validator(String[] args){
        this.args = args;
    }

    // Function that validates the correctness of the operators and operands from the command line arguments
    // returns true if the command line arguments are correct
    //         false, otherwise
    public boolean validate(){
        if(args.length>2 && args.length % 2 == 1) {
            if (args.length > 4) {
                for (int i = 1; i < args.length - 2; i += 2) {
                    if (!(args[i].equals("+") || args[i].equals("-") || args[i].equals("*") || args[i].equals("/")) ||
                            !args[i].equals(args[i + 2])) {
                        System.out.println("Invalid operator!");
                        return false;
                    }
                }
            }
            else{
                if (!(args[1].equals("+") || args[1].equals("-") || args[1].equals("*") || args[1].equals("/"))){
                    System.out.println("Invalid operator!");
                    return false;
                }
            }
            for (int i = 0; i < args.length; i += 2) {
                Matcher match = pattern.matcher(args[i]);
                boolean b = match.matches();
                if (!b) {
                    System.out.println("Invalid operand! " + args[i]);
                    return false;
                }
            }
        }
        else {
            System.out.println("Invalid number of arguments!");
            return false;
        }
        return true;
    }
}
