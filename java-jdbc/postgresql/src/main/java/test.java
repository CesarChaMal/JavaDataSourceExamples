import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
//        Order reference : site + PO type + PO number
        String codification1 = "12BDM0011173";
        String codification2 = "LY1510011173";

        Pattern pattern = Pattern.compile("^[0-9][0-9].*$");
        Matcher matcher = pattern.matcher(codification1);
        if (matcher.matches()){
            System.out.println("codification1");
        }

//        pattern = Pattern.compile("^[0-9][0-9][a-zA-Z][a-zA-Z][a-zA-Z].*$");
//        pattern = Pattern.compile("^[0-9][0-9][a-zA-Z][a-zA-Z][a-zA-Z][0-9].*$");
        pattern = Pattern.compile("^[0-9]{2}[A-Z]{3}[0-9]+$");
        matcher = pattern.matcher(codification1);
        if (matcher.matches()){
            System.out.println("codification1");
        }

        String str = "LY151";
        if (codification2.contains(str)){
            System.out.println("codification2");
        }

    }
}