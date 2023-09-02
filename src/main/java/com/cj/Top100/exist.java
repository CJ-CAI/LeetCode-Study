/**
 * @author CJ_CA
 */
public class exist {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
        String word="abceseeefs";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    if (search(i, j, board, word, 1,new boolean[board.length][board[0].length])){
                        System.out.println(true);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 搜索
     *
     * @param i
     * @param j
     * @param board
     * @param word  目标字符串
     * @param index 目标字符串的下标
     * @param flag  标记已经匹配过的
     * @return boolean
     */
    public static boolean search(int i,int j,char[][] board,String word,int index,boolean[][] flag){
        if(index==word.length()) {
            return true;
        }
        flag[i][j]=true;
        if(i+1<board.length&&board[i+1][j]==word.charAt(index)&&flag[i+1][j]!=true){
            if(search(i+1,j,board,word,index+1,flag)){
                return true;
            }
        }
        if(i-1>=0&&board[i-1][j]==word.charAt(index)&&flag[i-1][j]!=true) {
            if(search(i-1,j,board,word,index+1,flag)){
                return true;
            }
        }
        if(j-1>=0&&board[i][j-1]==word.charAt(index)&&flag[i][j-1]!=true) {
            if(search(i,j-1,board,word,index+1,flag)){
                return true;
            }
        }
        if(j+1<board[0].length&&board[i][j+1]==word.charAt(index)&&flag[i][j+1]!=true) {
            if(search(i,j+1,board,word,index+1,flag)){
                return true;
            }
        }
        //当判断失败，返回时，需要重置false，否则影响下一次的判断
        flag[i][j]=false;
        return false;
    }
}
