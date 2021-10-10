package leaf_to_root_path;

import java.util.ArrayList;

public class Solution {

/*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/
	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		if(root==null){
            ArrayList<Integer> out=new ArrayList<>();
            return out;
        }
            
        if(root.left==null && root.right==null){
        	ArrayList<Integer> out=new ArrayList<>();
        	out.add(root.data);
        
            return out;            
        }
        
        ArrayList<Integer> left=longestRootToLeafPath(root.left);
        ArrayList<Integer> right=longestRootToLeafPath(root.right);
        
        if(left.size()>=right.size()){
            left.add(root.data);
            return left;
        }
        else{
            right.add(root.data);
            return right;
        }
        
		
	}

	
	
}