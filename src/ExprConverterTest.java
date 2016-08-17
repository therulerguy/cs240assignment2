import java.util.Scanner;

public class ExprConverterTest {

    public static void main(String[] args){

        ExprConverter e = new ExprConverter();

        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Please enter an Infix");
            String intFix = s.nextLine();
            if(intFix.isEmpty()){
                System.out.println("Exiting program");
                break;
            }
            System.out.println("Intfix: " + intFix);
            System.out.println("Postfix: " + e.postFix(intFix));
            System.out.println("Prefix: " + e.preFix(intFix) + "\n");
        }
    }


}
