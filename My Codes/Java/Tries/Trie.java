public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }

        add(child, word.substring(1));
    }

    public void add(String word) {
        add(this.root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminating)
                return true;
            else
                return false;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return false;
        else {
            return search(child, word.substring(1));
        }

    }

    public boolean search(String word) {
        return search(this.root, word);
    }
}
