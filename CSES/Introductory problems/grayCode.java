import java.util.Scanner;
public class grayCode {
    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
        int n=sc.nextInt();
        sc.close();
        int total=1<<n;
        StringBuilder output1=new StringBuilder();
        for(int i=0;i<total;i++){
            int gray=i^(i>>1);
            output1.append(String.format("%"+n+"s",Integer.toBinaryString(gray)).replace(" ","0")).append("\n");
        }
        System.out.println(output1.toString());
    }
    }
}
