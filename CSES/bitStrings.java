import java.util.Scanner;

public class bitStrings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        final long MOD = 1000000007L; // 10^9 + 7
        
        long result = 1;
        for(int i = 0; i < n; i++){
            result = (result * 2) % MOD;
        }
        
        System.out.println(result);
    }
}
