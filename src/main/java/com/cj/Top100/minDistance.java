public class minDistance {
    public static void main(String[] args) {
        String word1="";
        String word2="";

        int[][] steps = new int[word1.length()+1][word2.length()+1];
        int method1,method2,method3;

        for (int i = 0; i <= word1.length(); i++) {
            steps[i][0]=i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            steps[0][j]=j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                method1=steps[i-1][j]+1;
                method2=steps[i][j-1]+1;
                method3=steps[i-1][j-1];
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    method3+=1;
                steps[i][j]=Math.min(method3,Math.min(method1,method2));
                System.out.print(steps[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(steps[word1.length()][word2.length()]);
    }
}
