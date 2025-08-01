import java.util.*;
class weirdalgorithm{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        sc.close();
        while(n>1){
            System.out.print(n+" ");
            if(n%2==0){
                n=n/2;
            }else if(n%2==1){
                n=(n*3)+1;
            }
        }
        System.out.print(n);
    }
}