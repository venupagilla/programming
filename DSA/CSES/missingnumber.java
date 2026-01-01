import java.util.Scanner;

public class missingnumber {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        long res=0;
        for(long i=1;i<n;i++){
            res+=sc.nextInt();
        }
        long mis=((n*(n+1))/2)-res;
        sc.close();
        System.out.println(mis);
    }
}
