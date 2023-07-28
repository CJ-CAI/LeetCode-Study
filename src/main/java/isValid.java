import java.util.LinkedList;

public class isValid {
    public static void main(String[] args) {
        String s = new String("({[]}");

        if (s.length() % 2 != 0)
            System.out.println(false);

        LinkedList<Character> cache = new LinkedList<>();
        int i = 0;
        System.out.println(cache.size());
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                cache.add(s.charAt(i));
            else if (cache.size() > 0) {
                if (s.charAt(i) == ')') {
                    if (cache.getLast() == '(')
                        cache.removeLast();
                    else
                        break;
                } else if (s.charAt(i) == ']') {
                    if (cache.getLast() == '[')
                        cache.removeLast();
                    else
                        break;
                } else if (s.charAt(i) == '}') {
                    if (cache.getLast() == '{')
                        cache.removeLast();
                    else
                        break;
                }
            } else
                break;
        }
        System.out.println(cache.size());
        if (i == s.length()&&cache.size()==0)
            System.out.println(true + s + i);
        else
            System.out.println(false + s + i);
    }
}
