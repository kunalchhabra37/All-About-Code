package ins_dlt_node;

public class Solution {
    public static  BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root,int data){
        if(root==null){
          root=new BinaryTreeNode<Integer>(data);
          return root;
        }
  
        if(root.data < data){
           root.right=insert(root.right,data);
        }
        else{
           root.left=insert(root.left,data);
        }
  
        
        return root;
     }
      
     private static BinaryTreeNode<Integer> minNode(BinaryTreeNode<Integer> root){
        if(root==null || root.left==null)
           return root;
  
        return minNode(root.left);
     }
     public static BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root,int data){
        if(root==null)
           return null;
  
        if(root.data==data){
           if(root.left==null && root.right==null)
              return null;
           else if(root.left==null)
              return root.right;
           else if(root.right==null)
              return root.left;
           else{
              BinaryTreeNode<Integer> minNode=minNode(root.right);
  
              root.data=minNode.data;
              root.right=remove(root.right, minNode.data);
           
              return root;   
           }         
        }
        else if(root.data < data){
           root.right=remove(root.right,data);
           return root;
        }
        else{
           root.left=remove(root.left, data);
           return root;
        }
  
     }
      
     public static void printTree(BinaryTreeNode<Integer> root){
        if(root==null)
           return;
  
        String out=root.data + ":";
        if(root.left!=null)
           out+="L:" + root.left.data + ",";
           
        if(root.right!=null)
           out+="R:" + root.right.data;
           
        System.out.println(out);
          
        printTree(root.left);
        printTree(root.right);
  
     }
          
      
     
  
    
}
