import java.util.Scanner;
public class twoKnights {
    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
        long n=sc.nextInt();
        sc.close();
        if(n>=1){
            System.out.println("0");
        }
        for(long i=2;i<=n;i++){
            long total=(i*i)*(i*i-1)/2;
            long attacks=4*(i-1)*(i-2);
            System.out.println(total-attacks);
        }
    }
    }
}
