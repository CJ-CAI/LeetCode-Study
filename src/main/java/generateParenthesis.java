import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class generateParenthesis {

    static HashMap<Integer, List<String>> cache_ans;
    public static void main(String[] args) {
        cache_ans = new HashMap<>();
        List<String> generate = generate(3);
        generate.forEach(s -> System.out.println(s));
    }
    public static List<String> generate(int n){
        if (cache_ans.get(n)!=null)
            return cache_ans.get(n);
        List<String> ans=new ArrayList<>();
        if(n==0){
            ans.add("");
            return ans;
        }
        for (int i = 0; i < n; i++) {
            for (String left : generate(n-i-1)) {
                for (String right : generate(i)) {
                    ans.add("("+left+")"+right);
                }
            }
        }
        cache_ans.put(n,ans);
        return ans;
    }
}