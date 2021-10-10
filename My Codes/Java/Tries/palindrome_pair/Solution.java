package palindrome_pair;

import java.util.ArrayList;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

class Trie {

	private TrieNode root;
	public int count;

	public Trie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */

    
} 

public class Solution{

    private static boolean isPalindrome(String word){
        if(word.length()==0)
            return true;
        int len=word.length();
        if(len%2==0){
            String str1=word.substring(0,(len/2));
            String str2=word.substring(len/2,len);
            if(str1.equals(str2))
                return true;
            else
                return false;
        }
        else{
            String str1=word.substring(0,(len/2));
            String str2=word.substring((len/2)+1,len);
            if(str1.equals(str2))
                return true;
            else
                return false;           
        }
    }

    public static String reverse(String str){
        if(str==null)
            return null;
        
        String rev="";
        
        for(int i=str.length()-1;i>=0;--i){
            rev+=str.charAt(i);
        }
        
        return rev;
        
    }
	
    public static boolean isPalindromePair(Trie t,ArrayList<String> words) {
        for(int i=0;i<words.size();++i){
            t.add(words.get(i));
			if(isPalindrome(words.get(i))){
				return true;
			}

        }
        
        for(int i=0;i<words.size();++i){
            String str=words.get(i);
			String rev=reverse(str);
			if(t.search(rev))
				return true;
			if(t.search(rev.substring(1)))
				return true;

			for(char j='a';j<='z';++j){
				if(t.search(j + rev)){
					return true;
				}
			}
            
        }

		return false;
	}
	


}