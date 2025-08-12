import java.util.Scanner;
public class grayCode {
    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
        int n=sc.nextInt();
        sc.close();
        int total=1<<n;
        for(int i=0;i<total;i++){
            int gray=i^(i>>1);
            String binary=String.format("%"+n+"s",Integer.toBinaryString(gray)).replace(" ","0");
            System.out.println(binary);
        }
    }
    }
}
