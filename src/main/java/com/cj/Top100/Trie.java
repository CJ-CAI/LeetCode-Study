import com.cj.utils.TrieNode;

/**
 * 单词查找树
 *
 * @author CJ_CA
 * @date 2023/08/29
 */
public class Trie {
    TrieNode trieNode;
    public Trie() {
        trieNode=new TrieNode();
    }

    public void insert(String word) {
        trieNode.insert(word);
    }

    public boolean search(String word) {
        return trieNode.search(word);
    }

    public boolean startsWith(String prefix) {
        return trieNode.startsWith(prefix);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
