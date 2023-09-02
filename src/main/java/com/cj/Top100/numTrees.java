import java.util.LinkedList;

/**
 * num树
 *
 * @author CJ_CA
 * @date 2023/08/12
 */
public class numTrees {
    public static void main(String[] args) {
        int n = 3;
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i < cache.length; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] += cache[j - 1] * cache[i - j];
            }
        }
        System.out.println(cache[n]);
    }

}
