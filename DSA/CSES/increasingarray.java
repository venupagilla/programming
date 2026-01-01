import java.util.Scanner;
public class increasingarray {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long numbers[]=new long[n];
        for(int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }
        long moves=0;
        for(int i=0;i<n-1;i++){
            if(numbers[i]>numbers[i+1]){
                moves+=numbers[i]-numbers[i+1];
                numbers[i+1]=numbers[i];            }
        }
        System.out.println(Math.abs(moves));
        sc.close();
    }
}
