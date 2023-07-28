public class isMatch {
    static int i = 0, j = 0;

    public static void main(String[] args) {
        String s = "b             ccbbabcaccacbcacaa";
        String p = ".* b.*c*.*.*   .c*a*. c";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        for (; i < s.length() && j < p.length(); ) {
            if (j + 1 < p.length() && p.charAt(j) == '.' && p.charAt(j + 1) == '*') {
                return compare2(s, p);
            } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (compare1(s, p) == true)
                    continue;
                else {
                    return false;
                }
            } else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                i++;
                j++;
                continue;
            } else
                break;
        }
        while (j < p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                j += 2;
            else
                break;
        }
        if (i >= s.length() && j >= p.length())
            return true;
        else
            return false;
    }

    public static boolean compare1(String s, String p) {
        int s_count = 0, p_count = 0;
        do {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                s_count++;
            } else {
                //i保持不变,下一次继续对比i位置
                j += 2;
                return true;
            }
            if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i))
                i++;
            else
                break;
        } while (i < s.length());

        while (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '*')) {
            if (j + 1 < p.length() && p.charAt(j) == s.charAt(i) && p.charAt(j + 1) != '*')
                p_count++;
            if (j + 1 == p.length() && p.charAt(j) == s.charAt(i))
                p_count++;
            j++;
        }
        while (j < p.length() && i + 1 >= s.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                j += 2;
            else if (p.charAt(j) == s.charAt(i)) {
                p_count++;
                j++;
            } else
                break;
        }

        i += 1;//下一此对比位置加1
        while (i >= s.length() && j < p.length()) {
            if (p.charAt(j) == '.')
            {j++;
            p_count++;}
        }
        System.out.println(s_count + " " + p_count);

        if (s_count >= p_count)
            return true;
        else
            return false;
    }

    public static boolean compare2(String s, String p) {

        j += 2;
        if (j >= p.length())
            return true;
        while (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            j += 2;
        }
        int i_start = i, j_start = j;
        if (j >= p.length())
            return true;

        for (; i < s.length() && j < p.length(); i++) {
            if (j + 1 < p.length() && p.charAt(j) == '.' && p.charAt(j + 1) == '*') {
                if (compare2(s, p) == true)
                    return true;
                else {
                    i = i_start++;
                    j = j_start;
                }
            } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (p.charAt(j) == s.charAt(i)) {
                    if (compare1(s, p) == true) {
                        if (j == p.length() && i < s.length())//对比到最后的i,i已经加了1
                            j = j_start;
                        i -= 1;//做自增了一次
                        continue;
                    } else {
                        j = j_start;//恢复到起始位
                        i = i_start++;
                    }
                } else {
                    j += 2;
                    i -= 1;
                    continue;
                }
            } else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                j++;
                if (j == p.length() && i < s.length() - 1) {//对比到最后的i
                    j = j_start;
                    i = i_start++;//因为i++所以用后自增
                }
                continue;
            } else {
                j = j_start;
                i = i_start++;
            }

        }

        while (j < p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                j += 2;
            else
                break;
        }
        if (j == p.length() && i == s.length())
            return true;
        return false;
    }
}
