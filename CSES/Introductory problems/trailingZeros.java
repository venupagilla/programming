import java.util.Scanner;
public class trailingZeros {
    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
        int n=sc.nextInt();
        int zeros=0;
        for(int i=5;i<=n;i*=5){
            zeros+=n/i;
        }
        System.out.println(zeros);
    }
    }
}
