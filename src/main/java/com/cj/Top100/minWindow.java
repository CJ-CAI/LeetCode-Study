import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class minWindow {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        int[] need = new int[128];
        int[] have = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left=0,right=0,min=s.length()+1,count=0,start=0;

        for (int i = 0; i < s.length(); i++) {
            if(need[s.charAt(i)]==0){
                right++;
                continue;
            }
            right++;
            if(have[s.charAt(i)]<need[s.charAt(i)]){
                count++;
            }
            have[s.charAt(i)]++;
            while (count==t.length()){
                if (right-left<min){
                    min=right-left;
                    start=left;
                }
                if(have[s.charAt(left)]>need[s.charAt(left)]){
                    have[s.charAt(left)]--;
                }
                else if(need[s.charAt(left)]==have[s.charAt(left)]&&need[s.charAt(left)]>0){
                    have[s.charAt(left)]--;
                    count--;
                }
                left++;
            }
        }
        if(min==s.length()+1)
            System.out.println("");
        else
        System.out.println(s.substring(start,start+min));

    }
}
