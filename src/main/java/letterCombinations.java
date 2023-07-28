import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class letterCombinations {

    static final Map<Character, String> phoneNumbers = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String digits = "23";
        if(digits.length()>0)
            Match(0,digits,new StringBuilder());
        result.forEach(s -> System.out.print(s+" "));
    }

    public static void Match(int index,String digits,StringBuilder prev){
        String s = phoneNumbers.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            StringBuilder strAfter = new StringBuilder();
            strAfter.append(prev);
            strAfter.append(s.charAt(i));
            if(index+1<digits.length())
                Match(index+1,digits,strAfter);
            else
                result.add(String.valueOf(strAfter));
        }
    }
}
