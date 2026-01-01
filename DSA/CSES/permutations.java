import java.util.Scanner;
public class permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i += 2) {
                sb.append(i).append(" ");
            }
            for (int i = 1; i <= n; i += 2) {
                sb.append(i).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
