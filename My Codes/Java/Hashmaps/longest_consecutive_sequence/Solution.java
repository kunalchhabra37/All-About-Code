package longest_consecutive_sequence;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        if(arr.length==0)
            return null;

        HashMap<Integer,Boolean> num=new HashMap<>();
        HashMap<Integer,Integer> index=new HashMap<>();
        
        for(int i=0;i<arr.length;++i){
            num.put(arr[i],false);
            index.put(arr[i],i);
        }

        int maxl=1,start=arr[0],end=arr[0];
        
        for(int i=0;i<arr.length;++i){
            if(num.get(arr[i]))
               continue;

            int l=1,s=arr[i],e=arr[i];
            
            for(int j=arr[i]+1;;++j){
                if(num.containsKey(j)){
                    l++;
                    e=j;    
                    num.put(j, true);
                }
                else 
                    break;               
               
            }

            for(int j=arr[i]-1;;--j){
                if(num.containsKey(j)){
                    l++;
                    s=j;    
                    num.put(j, true);
                }
                else 
                    break;               
               
            }

            if(l>maxl || (l==maxl && index.get(s)<index.get(start))){
                maxl=l;
                start=s;
                end=e;
            }
            
            
            num.put(arr[i],true);
        }

        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(start);
        ans.add(end);

        return ans;
    }
}