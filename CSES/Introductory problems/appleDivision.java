import java.util.Scanner;
public class appleDivision {
    // public static void main(String args[]){
    //     try(Scanner sc=new Scanner(System.in)){
    //         int n=sc.nextInt();
    //         int[] arr=new int[n];
    //         for(int i=0;i<n;i++){
    //             arr[i]=sc.nextInt();
    //         }
    //         int aweight=0;
    //         int bweight=0;
    //         Arrays.sort(arr);
    //         for(int i=n-1;i>=0;i--){
    //             if(aweight<=bweight){
    //                 aweight+=arr[i];
    //             }else{
    //                 bweight+=arr[i];
    //             }
    //         }
    //         System.out.println(Math.abs(aweight-bweight));
    //     }
    // }
    static long best=Long.MAX_VALUE;
    static void trydivide(int loc,long sum1,long sum2,int[] arr){
        if(loc==arr.length){
            best=Math.min(best,(Math.abs(sum1-sum2)));
            return;
        }
        trydivide(loc+1,sum1+arr[loc],sum2,arr);
        trydivide(loc+1,sum1,sum2+arr[loc],arr);
    }
    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            trydivide(0,0,0,arr);
            System.out.println(best);
        }
    }
}
