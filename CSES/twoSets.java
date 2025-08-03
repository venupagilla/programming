import java.util.Scanner;

public class twoSets {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        long totalSum = (long)n * (n + 1) / 2;
        
        if(totalSum % 2 != 0){
            System.out.println("NO");
        } else {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            long half = totalSum / 2;
            long cur = 0;
            int count1 = 0, count2 = 0;
            
            for(int i = n; i > 0; i--){
                if(cur + i <= half){
                    cur += i;
                    sb1.append(i).append(" ");
                    count1++;
                } else {
                    sb2.append(i).append(" ");
                    count2++;
                }
            }
            
            System.out.println("YES");
            System.out.println(count1);
            System.out.print(sb1.toString());
            System.out.println();
            System.out.println(count2);
            System.out.print(sb2.toString());
        }
    }
}
