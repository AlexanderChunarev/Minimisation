package mdnf;

import java.util.ArrayList;
import java.util.Arrays;

public class Minimisation {
    private String[] forms = new String[]{
            "AND_and_OR_NOT",
            "AND_NO_and_AND",
            "OR_and_AND",
            "OR_NOT_and_OR_NOT"
    };
    private String function = "x3 x4 + !x1 x3 + !x1 !x2 x4 + x2 !x3 !x4";
    private ArrayList<ArrayList<String>> arrayList;
    private ArrayList<String> array = new ArrayList<>();

    Minimisation() {
        array.addAll(Arrays.asList(function.split(" \\+ ")));
    }

    private String getValue(String expr) {
        String value;
        value = "";
        for (String s : parseFunction(expr)) {
            if (s.contains("!")) {
                s = s.replace("!", "");
            } else {
                s = "!" + s;
            }
            value += s + " ";
        }
        return value;
    }

    private ArrayList<String> parseFunction(String expression) {
        return new ArrayList<>(Arrays.asList(expression.split(" ")));
    }

    public static void main(String[] args) {
        new Minimisation().minimise();
    }
}
