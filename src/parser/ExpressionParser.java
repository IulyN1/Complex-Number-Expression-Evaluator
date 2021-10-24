package parser;

import expression.ComplexExpression;
import expression.Operation;
import domain.ComplexNumber;
import factory.ExpressionFactory;
import validation.Validator;

public class ExpressionParser {
    private final String[] args;

    // Constructor for ExpressionParser class
    // args - array of String
    public ExpressionParser(String[] args){
        this.args = args;
    }

    // Method that parses the arguments into an expression if they are valid
    // throws Exception if the operators or operands are invalid
    public ComplexExpression parse() throws Exception {
        Validator valid = new Validator(args);
        if(valid.validate()){
            ComplexNumber[] numbers = new ComplexNumber[args.length/2 + 1];
            Operation operation = switch (args[1]) {
                case ("+") -> Operation.ADDITION;
                case ("-") -> Operation.SUBTRACTION;
                case ("*") -> Operation.MULTIPLICATION;
                case ("/") -> Operation.DIVISION;
                default -> throw new Exception("Unknown operation!");
            };
            int k=0;
            for(int i=0;i< args.length;i+=2){
                StringBuilder re = new StringBuilder();
                StringBuilder im = new StringBuilder();
                int aux = -1;
                for(int j=0;j<args[i].length();j++){
                    char c = args[i].charAt(j);
                    if(args[i].equals("i")){
                        im.append("1");
                        break;
                    }
                    if(args[i].equals("-i")){
                        im.append("-1");
                        break;
                    }
                    if(args[i].charAt(args[i].length()-1)!='i') {
                        for(int l=0;l<args[i].length();l++){
                            char ch = args[i].charAt(l);
                            re.append(ch);
                        }
                        break;
                    }
                    if(!(c=='+' || (c=='-' && j>0)) && aux == -1){
                        if(c=='*') {
                            re.delete(0,j);
                            for(int l=0;l<j;l++) {
                                char ch = args[i].charAt(l);
                                im.append(ch);
                            }
                            break;
                        }
                        else{
                            re.append(c);
                        }
                    }
                    else{
                        aux = j;
                        if(!(c=='+' || c=='*' || c=='i')) {
                            im.append(c);
                        }
                    }
                }
                if(re.isEmpty()){
                    re.append("0");
                }
                if(im.isEmpty()){
                    im.append("1");
                }
                String reString = (String)re.toString();
                String imString = (String)im.toString();
                float reNr = Float.parseFloat(reString);
                float imNr = Float.parseFloat(imString);
                ComplexNumber number = new ComplexNumber(reNr,imNr);
                numbers[k] = number;
                k++;
            }
            ExpressionFactory factory = ExpressionFactory.getInstance();
            return factory.createExpression(operation,numbers);
        }
        throw new Exception("Impossible to compute result!");
    }
}
