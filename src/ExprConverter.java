/**
 * Created by jwang on 7/14/16.
 */
public class ExprConverter {

    public ExprConverter(){

    }

    public String postFix(String inFix){
        NodeStack stack = new NodeStack();
        String output = "";

        //create a switch case that traverses through every character in the given string

        for(int i = 0; i < inFix.length(); i++){
            char c = inFix.charAt(i);
            switch (c){
                case '(' :
                    stack.push(Character.toString(c));
                    break;
                case ')' :
                    while(!stack.top().equals("(")){
                        output += stack.pop();
                    }
                    stack.pop();
                    break;
                case '*' :
                case '/' :
                case '+' :
                case '-' :
                    while(!stack.isEmpty() && precedence(Character.toString(c)) <= precedence(stack.top())){
                        output += stack.pop();
                    }
                    stack.push(Character.toString(c));
                    break;
                default :
                    output += c;
            }
        }
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        return output;
    }

    public String preFix(String inFix){

        NodeStack operands = new NodeStack();
        NodeStack operators = new NodeStack();

        String op = "";
        String right = "";
        String left = "";
        String combine = "";

        for(int i = 0; i < inFix.length(); i++){

            char c = inFix.charAt(i);

            switch(c) {
                case '(' :
                    operators.push("(");
                    break;
                case ')' :
                    while(!operators.top().equals("(")) {
                        op = operators.pop();
                        right = operands.pop();
                        left = operands.pop();
                        combine = op + left + right;
                        operands.push(combine);
                    }
                    operators.pop();
                    break;
                case '*' :
                case '/' :
                case '+' :
                case '-' :
                    if(!operators.isEmpty() && precedence(operators.top()) >= precedence(Character.toString(c)) ){
                        op = operators.pop();
                        right = operands.pop();
                        left = operands.pop();
                        combine = op + left + right;
                        operands.push(combine);
                    }
                    operators.push(Character.toString(c));
                    break;
                default :
                    operands.push(Character.toString(c));
            }
        }
        while(!operators.isEmpty()){
            op = operators.pop();
            right = operands.pop();
            left = operands.pop();
            combine = op + left + right;
            operands.push(combine);
        }
        return operands.pop();
    }

    public int precedence(String s){

        switch(s) {
            case "*" :
            case "/" :
                return 3;
            case "+" :
            case "-" :
                return 2;
            case "(" :
                return 1;
            default :
                return 0;
        }

    }



}
