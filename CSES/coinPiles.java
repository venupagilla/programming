import java.util.Scanner;
public class coinPiles {
    public static void main(String args[]){
        StringBuilder output1=new StringBuilder();
        try(Scanner sc=new Scanner(System.in)){
            int t=sc.nextInt();
            for(int s=0;s<t;s++){
                long a=sc.nextLong();
                long b=sc.nextLong();
                long c=a+b;
                if((a<=2*b) && (b<=2*a)){
                if(c%3==0){
                    output1.append("YES").append("\n");
                }else{
                    output1.append("NO").append("\n");
                }
            }
            }
            System.out.println(output1);

        }
    }
}
