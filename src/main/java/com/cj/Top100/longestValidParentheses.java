import java.util.HashMap;
import java.util.LinkedList;

public class longestValidParentheses {
    public static void main(String[] args) {
        String s=")()(((())))(";
        int max=0,temp=0;
        int left=0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
                left++;
            else if (s.charAt(i)==')'&& left>0) {
                left--;
                temp+=2;
                if(left==0)
                    max = Math.max(max, temp);
            }
            else{
                temp=0;
                left=0;
            }
        }
        left=temp=0;

        for (int i = s.length()-1 ;i >-1; i--) {
            if(s.charAt(i)==')')
                left++;
            else if (s.charAt(i)=='('&& left>0) {
                left--;
                temp+=2;
                if(left==0)
                    max = Math.max(max, temp);
            }
            else{
                temp=0;
                left=0;
            }
        }
        if(left==0)
            max = Math.max(max, temp);

        System.out.println(max);
    }
}
