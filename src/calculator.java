import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class calculator {  //this is the testing the logic stage do NOT judge the messiness

    Map<String,String> singleTerm = new HashMap<String,String>(); //maps are more fun
    //ArrayList<String> singleTerm = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("enter simple expression");
        String hg = scn.next();
        calculator c = new calculator();
       // c.SingleTermDer(hg);
        parser pp = new parser();
        pp.parseExpression(hg);

    }

    public static boolean isItNumeric(String str) {  //works
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public int SingleTermDer(String help) {  //TODO int should be string, return deriv
        if(isItNumeric(help)) {
            System.out.println("0");
           return 0;
        }
        else {      //one hell of an else
            parser p = new parser();
            singleTerm = p.parseSingleTerm(help);
            //heehoo math time
            int exp = Integer.valueOf(singleTerm.get("exponent"));
            int co = Integer.valueOf(singleTerm.get("coeff"));
            if (exp > 2) {
                co = co * exp;
                exp--;
                System.out.println(co + "x^" + exp);
            }
            else if (exp == 2) {
                co = co * exp;
                exp--;
                System.out.println(co + "x");   //prints are j for testing atp
            }
            else {
                System.out.println(co);
            }

        }

        return 1;
    }
}
