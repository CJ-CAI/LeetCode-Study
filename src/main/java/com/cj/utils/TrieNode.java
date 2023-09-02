package com.cj.utils;

/**
 * 单词查找树节点
 *
 * @author CJ_CA
 * @date 2023/08/29
 */
public class TrieNode {
    private TrieNode[] trieNodes;
    private boolean wordEnd;

    public TrieNode() {
        trieNodes = new TrieNode[26];
        wordEnd = false;
    }

    public void insert(String word) {
        TrieNode node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                node.trieNodes[index] = new TrieNode();
            }
            node = node.trieNodes[index];
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = match(word);
        return node != null && node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        return match(prefix) != null;
    }

    public TrieNode match(String word) {
        TrieNode node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.trieNodes[index] == null) {
                return null;
            }
            node = node.trieNodes[index];
        }
        return node;
    }
}
