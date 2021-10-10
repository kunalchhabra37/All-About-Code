package construct_post_in;

public class Solution {
    
    public static BinaryTreeNode<Integer> buildTree(int[] post,int[] in ){
        if(post.length==0)
           return null;

        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(post[post.length-1]);
        
        int n=0;
        for(int i=0;i<in.length;++i){
            if(in[i]==root.data){
                n=i;
                continue;
            }
        }
        
        int[] leftin=new int[n];
        int[] rightin=new int[in.length-n-1];
        
        for(int i=0;i<in.length;++i){
            if(i==n)
               continue;

            if(i<n)
               leftin[i]=in[i];
            else
                rightin[i-n-1]=in[i];
            
        }

        int[] leftpost=new int[n]; 
        int[] rightpost=new int[post.length-1-n];

        for(int i=0;i<post.length-1;++i){
            if(i<n)
               leftpost[i]=post[i];
            else
               rightpost[i-n]=post[i];   
        }
        
        root.left=buildTree(leftpost,leftin);
        root.right=buildTree(rightpost, rightin);
        return root;
    }
}
