import java.util.Scanner;
public class Binary2decimal {
    static int convertnum(String s){
        int num=0;
        int p=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                num+=p;
            }
            p*=2;
        }
        return num;
    }

    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
            System.out.println("Enter the binary number you want to convert to decimal");
            String s=sc.next();
            System.out.println(convertnum(s));
            sc.close();
        }
    }

}
