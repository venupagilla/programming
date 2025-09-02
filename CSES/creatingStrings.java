import java.util.Scanner;
import java.util.HashMap;
public class creatingStrings {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String hi=sc.next();
        char[] arr=hi.toCharArray();
        System.out.println(hi.length()*(hi.length()-1));
        for()
    }
}



public static int countUniquePermutations(String s) {
    // Step 1: Create HashMap and count frequencies
    HashMap<Character,Integer> actual=new HashMap<>();
    for(char c:s.toCharArray()){
        int count=actual.getOrDefault(c,0);
        actual.put(c,++count);
    }
    // Step 2: Calculate numerator (total length factorial)
    int numerator=1;
    for(int i=1;i<=s.length();i++){
        numerator*=i;
    }
    // Step 3: Calculate denominator (product of all frequency factorials)
    int denominator=1;
    for(int i:actual.values()){
        int cur=1;
        for(int j=1;j<=i;j++){
            cur*=j;
        }
        denominator*=cur;
    }
    // Step 4: Return numerator/denominator
    return numerator/denominator;
}