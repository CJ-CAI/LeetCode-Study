public class isMatchPlus {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aaa", ".*"));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] flag = new boolean[s.length() + 1][p.length() + 1];
        flag[0][0] = true;
        for (int i=0; i < s.length() + 1; i++) {
            for (int j=1; j < p.length() + 1; j++) {
                if (p.charAt(j-1) == '*') {
                    flag[i][j] = flag[i][j - 2];
                    if (matches(s, p, i, j-1))
                        flag[i][j] = flag[i][j] || flag[i - 1][j];
                } else {
                    if (matches(s, p, i, j))
                        flag[i][j] = flag[i - 1][j - 1];
                }
            }
        }
       /* for (int x = 0; x < s.length()+1; x++) {
            for (int y = 0; y < p.length()+1; y++) {
                System.out.print(flag[x][y]+" ");
            }
            System.out.println();
        }*/
        return flag[s.length()][p.length()];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j-1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
