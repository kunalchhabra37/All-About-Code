package min_bracket_reversal;
import java.util.Stack;

public class Solution {

	public static int countBracketReversals(String input) {		
        if(input.length()%2!=0)
            return -1;
        
        Stack<Character> s=new Stack<>();
        int count=0;
        
        for(int i=0;i<input.length();++i){
            char c=input.charAt(i);
            
            if(c=='{'){
                if(i==input.length()-1){
                    count++;
                    s.pop();
                }
                s.push(c);
            }
            if(c=='}'){
                if(s.isEmpty()){
                    count++;
                    s.push('{');
                }
                else
                    s.pop();
            }
        }
        
        int open=0,close=0;
        while(!s.isEmpty()){
            char c=s.pop();
            if(c=='{')
                open++;
            else if(c=='}')
                close++;
        }
        
        int diff;
        if(open>close)
            diff=open-close;
        else
            diff=close-open;
        
        count+=diff/2;
        
        return count;
    }

}