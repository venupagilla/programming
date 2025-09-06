
import java.io.IOException;
import java.util.Scanner;

public class palindromeReorder {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        System.out.println(solve(input));
    }

    private static String solve(String str) {
        int[] freq = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch - 'A']++;
        }
        
        int oddCount = 0;
        char midChar = '\0';
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char)(i + 'A');
            }
        }
        
        if (oddCount > 1) {
            return "NO SOLUTION";
        }
        

        StringBuilder firstHalf = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                int count = freq[i] / 2;
                while (count-- > 0) {
                    firstHalf.append((char)(i + 'A'));
                }
            }
        }
        

        StringBuilder result = new StringBuilder(firstHalf);
        if (midChar != '\0') {
            result.append(midChar);
        }
        result.append(firstHalf.reverse());
        
        return result.toString();
    }
}