public class lengthOfLongestSubstring_plus {
    public static void main(String[] args) {
        String s = "abbacde";
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]+1 );//上一次重复的位置
            res = Math.max(res, i - start +1);//减去上一次重复的位置
            last[index] = i;
        }

        System.out.println(res);
    }
}
