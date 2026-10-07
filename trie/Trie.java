package trie;

public class Trie {

    Trie[] nodes;
    boolean isEnd;

    public Trie() {
        nodes = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie[] temp = this.nodes;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            int idx = ch - 'a';

            if (temp[idx] == null) {
                temp[idx] = new Trie();
            }

            if (i == word.length() - 1) {
                temp[idx].isEnd = true;
            }

            temp = temp[idx].nodes;
        }

    }

    public boolean search(String word) {
        Trie[] temp = nodes;
        boolean isEndTemp = isEnd;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (temp[idx] == null) {
                return false;
            }

            isEndTemp = temp[idx].isEnd;
            temp = temp[idx].nodes;
        }

        return isEndTemp;
    }

    public boolean startsWith(String prefix) {
        Trie[] temp = nodes;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            int idx = ch - 'a';

            if (temp[idx] == null) {
                return false;
            }

            temp = temp[idx].nodes;
        }

        return true;
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
