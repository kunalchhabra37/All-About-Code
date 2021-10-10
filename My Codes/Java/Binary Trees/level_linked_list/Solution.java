package level_linked_list;

import java.util.ArrayList;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

public class Solution {

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        if(root==null)
           return null;
        
        ArrayList<LinkedListNode<Integer>> ans=new ArrayList<>();

        Queue<BinaryTreeNode<Integer>> pendingnodes=new Queue<>();
        pendingnodes.enqueue(root);

        int n;

        while(!pendingnodes.isEmpty()){
            try{
                n=pendingnodes.getSize();
                LinkedListNode<Integer> head=null,temp=null;
                for(int i=0;i<n;++i){
                    BinaryTreeNode<Integer> front=pendingnodes.dequeue();
                    LinkedListNode<Integer> newnode=new LinkedListNode<>(front.data);
                   
                    if(i==0){
                        head=newnode;
                        temp=head;
                    }
                    else{
                       temp.next=newnode;
                       temp=temp.next;
                    }
 

                    if(front.left!=null)
                       pendingnodes.enqueue(front.left);
                    if(front.right!=null)
                       pendingnodes.enqueue(front.right);   

                }
                ans.add(head);
            } catch(QueueEmptyException e){
                return null;
            }
        }

         return ans;
    }
    
}
