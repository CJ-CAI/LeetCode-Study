public class rotate {
    static final int WIDTH=5;
    static int[][] matrix = new int[WIDTH][WIDTH];
    static int count=1;

    static {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                matrix[i][j]=count++;
//                System.out.print(i+""+j+" ");
            }
//            System.out.println();
        }
        printArray("start...");
    }
    public static void main(String[] args) {
        int temp;
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = i; j < matrix.length-i-1; j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-j-1][i];
                matrix[matrix.length-j-1][i]=matrix[matrix.length-i-1][matrix.length-j-1];
                matrix[matrix.length-i-1][matrix.length-j-1]=matrix[j][matrix.length-i-1];
                matrix[j][matrix.length-i-1]=temp;
            }
        }
        printArray("finish...");

    }

    public static void printArray(String tag){
        System.out.println(tag);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
