public class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];

    public TrieNode(char data){
        this.data=data;
        isTerminating=false;
        children = new TrieNode[26];
    }

}
