package notations;

import stack_usingll.Stack;
import stack_usingll.StackEmptyException;


public class InfixToPostfix {

    public static String convert(String expression) throws StackEmptyException{
        if(expression.length() == 0){
            return "";
        }

        Stack<Character> operators = new Stack<>();
        operators.push('(');

        String postfix="";

        int i = 0;
        while(!operators.isEmpty() && i < expression.length()){
            char c = expression.charAt(i);
            i++;
            if(c == '('){
                operators.push(c);
                continue;
            }
            else if(c == ')'){
                while(operators.top() != '('){

                }
            }
        }


        return postfix;
    }
    
}
