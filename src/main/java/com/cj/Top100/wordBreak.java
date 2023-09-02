import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * 单词分割
 *
 * @author CJ_CA
 * @date 2023/08/18
 */
public class wordBreak {
    public static void main(String[] args) {
        String s="apsplepenapple";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("pen");
        wordDict.add("apple");

        HashSet<String> worDictSet = new HashSet<>();
        int Maxlength=0,start=0;
        for (String str : wordDict) {
            worDictSet.add(str);
            Maxlength=Math.max(str.length(),Maxlength);
        }
        Boolean[] flag = new Boolean[s.length()+1];
        flag[0]=true;

        for (int i = 1; i < s.length()+1; i++) {
            if(i-start>Maxlength){
                System.out.println("Maxlength exit "+false);
                break;
            }
            for (int j = 0; j <= i; j++) {
                if(flag[j]&&worDictSet.contains(s.substring(j,i))){
                    flag[i]=true;
                    start=i;
                    break;
                }
                flag[i]=false;
            }
        }
        System.out.println(flag[s.length()]);
    }
}
