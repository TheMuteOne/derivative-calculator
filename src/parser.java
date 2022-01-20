import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class parser {

    private ArrayList<String> terms = new ArrayList<String>();
    private ArrayList<String> single = new ArrayList<String>();
    private Map<String, String> singleParsed = new HashMap<String, String>();


    public ArrayList yeet(String input) {  //will take from reader.getInput
        //TODO: take input and convert it into single terms


        return terms;
    }

    public Map parseSingleTerm(String term) {

        String num = "";

        term = term.replaceAll("\\s", "");  //kill spaces

        if (term.equals ("x")){
//            single.add("1");
//            single.add("x");
            singleParsed.put("coeff","1");
            singleParsed.put("variable","x");
            singleParsed.put("exponent", "1");

        }
        else if (!calculator.isItNumeric(String.valueOf((term.toCharArray())[0]))) {
            //if we have smth like x^2
            for (int j = 2; j < term.toCharArray().length; j++) {
                num = num + String.valueOf(term.toCharArray()[j]);
            }
            singleParsed.put("exponent", num);
            singleParsed.put("coeff", "1");
            singleParsed.put("variable","x");



        }
        else {
            char[] tochars = term.toCharArray();
            for (char x : tochars) {
                single.add(String.valueOf(x));
            }


           // for (int i = 0; i < single.size(); i++) {     //must start with numeric at this point
            int iter =0;
            String e = single.get(iter);
            while(calculator.isItNumeric(e)) {
                num = num + e;
                iter++;
                e = single.get(iter);
            }
            //int d = Integer.parseInt(num);
            singleParsed.put("coeff", num);
            num = "";
            singleParsed.put("variable",single.get(iter));
            if (single.size()-1 > iter) {  //indicates there is an exp
                // +2 skips exp symbol so no confusion in system
                int iterAgain = iter + 2;
                String f = single.get(iterAgain);
                while(calculator.isItNumeric(f)) {
                    num = num + f;
                    iterAgain++;
                    if (iterAgain < single.size()) {
                        f = single.get(iterAgain);
                    } else {
                        f = "nonnumeric";
                    }
                }
                singleParsed.put("exponent", num);
            }
            else {
                //idk bro
                singleParsed.put("exponent", "1");
            }
        }
        return singleParsed;

    }





}
