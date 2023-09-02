import java.util.HashSet;


public class lengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        String s = "anviaj";
        int MaxCount = 0;
        char[] chars = s.toCharArray();
        int j=0;
        HashSet<Character> stringHashSet = new HashSet<>();
        for (int i = 0; MaxCount < chars.length-i ; i++) {
            if(i!=0)
                stringHashSet.remove(chars[i-1]);

            for (; j < chars.length; j++) {
                if (stringHashSet.contains(chars[j])&&i!=j)
                        break;
                 else
                    stringHashSet.add(chars[j]);

            }
            if (j-i> MaxCount)
                MaxCount = j-i;
        }

        System.out.println(MaxCount);
    }
}
