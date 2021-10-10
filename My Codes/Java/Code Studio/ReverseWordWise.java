import java.util.*;

public class ReverseWordWise {
 
    public static String reverse(String str){
        if(str.length()==0)
            return "";

        int i=0;
        for(i=0;i<str.length();++i){
            if(str.charAt(i)==' '){
                break;
            }
        }

        String first=str.substring(0, i);        
        String rest="";
        if(i<str.length())
            rest=reverse(str.substring(i + 1));

        if(rest.length()>0)
            rest+=' ';

        return rest + first;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        System.out.print(reverse(str));
        s.close();
    }
    
}
