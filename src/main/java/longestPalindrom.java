public class longestPalindrom {
    //    bd ede db
    public static void main(String[] args) {
        String s = "aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa";
        String result = "";
        result += s.charAt(0);
        StringBuilder temp = new StringBuilder("");
        int interval = 0;
        boolean simple = false;
        for (int i = 1; i < s.length(); i++) {
            if (interval == 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    temp.append(s.charAt(i - 1));
                    temp.append(s.charAt(i));
                    interval = 3;
                    simple = true;
                } else if (i > 1 && s.charAt(i) == s.charAt(i - 2)) {
                    temp.append(s.charAt(i - 2));
                    temp.append(s.charAt(i - 1));
                    temp.append(s.charAt(i));
                    interval = 4;
                    if (s.charAt(i - 1) == s.charAt(i))
                        simple = true;
                }
            } else {
                if (simple == true && s.charAt(i) == s.charAt(i - 1)) {
                    temp.append(s.charAt(i));
                    interval += 1;
                } else {
                    simple = false;
                    if (i - interval >= 0 && s.charAt(i) == s.charAt(i - interval)) {
                        temp.insert(0, s.charAt(i - interval));
                        temp.append(s.charAt(i));
                        interval += 2;
                    } else if (s.charAt(i) == s.charAt(i - 1) || s.charAt(i) == s.charAt(i - 2)) {
                        if (temp.length() > result.length())
                            result = new String(temp);
                        if ((interval-1) >=s.length() / 2 && i-(interval-2)/2-1<s.length()/2 ) {
                            i = (interval-2) / 2 +i+2-interval;                           //找回文字符串中点回退
                            interval = 0;
                            temp = new StringBuilder();
                            continue;
                        }
                        interval = 0;
                        temp = new StringBuilder();
                        i--;
                    } else {
                        interval = 0;
                        if (temp.length() > result.length())
                            result = new String(temp);
                        temp = new StringBuilder();
                    }
                }
            }
        }
        if (temp.length() > result.length())
            result = new String(temp);
        System.out.println(s.length());
        System.out.println(result);
        System.out.println(result.length());
    }
}
