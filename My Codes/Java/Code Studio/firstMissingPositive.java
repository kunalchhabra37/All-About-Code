import java.util.Scanner;

public class firstMissingPositive {
	public static int firstMissing(int[] arr, int n) {
		boolean[] a=new boolean[n];
        int t=0;
        for(int i=0;i<n;++i){
            if(arr[i]<0 || arr[i]>n)
                continue;
            
            if(arr[i]==n){
                t=1;
                continue;
            }
            a[arr[i]]=true;    
        }

        for(int i=1;i<n;++i){
            
            if(!a[i])
                return i;
            
        }

        return n + t;
	}

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();

        while(t-->0){
            int n=s.nextInt();
            int[] arr=new int[n];

            for(int i=0;i<n;++i){
                arr[i]=s.nextInt();
            }

            System.out.println(firstMissing(arr, n));
        }

        s.close();
    }
}
