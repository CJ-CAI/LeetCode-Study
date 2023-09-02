import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*String str="abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
        int number=str.charAt(i)%27;
        System.out.print(number+" ");
        }*/
public class groupAnagrams {
    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<List<String>> result = new ArrayList<>();
        /*HashMap<IntArrayWrapper, List<String>> map = new HashMap<>();
        for (String s : strs) {
            IntArrayWrapper intArrayWrapper = new IntArrayWrapper(new int[26]);
            for (int i = 0; i < s.length(); i++) {
                intArrayWrapper.array[s.charAt(i)-'a']++;
            }
            if(map.get(intArrayWrapper)==null){
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(intArrayWrapper,list);
            }
            else {
                map.get(intArrayWrapper).add(s);
            }*/

        HashMap<Integer, List<String>> map = new HashMap<>();
        int key=0;
        for (String s : strs) {//有漏洞比如 bc 和ad
            key=0;
            for (int i = 0; i < s.length(); i++) {
                key+=s.charAt(i);
            }
            if(map.get(key)==null){
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(key,list);
            }
            else {
                map.get(key).add(s);
            }
        }

        map.values().forEach(v -> result.add(v));
        map.values().forEach(v -> {
            v.forEach(s -> System.out.print(s + " "));
            System.out.println();
        });
    }
}
