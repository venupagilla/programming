import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class palindromeReorder {
    public static void main(String args[]){
    try(Scanner sc=new Scanner(System.in)){
        String ord=sc.nextLine();
        StringBuilder org=new StringBuilder();
        HashMap<Character,Integer> check=new HashMap<>();
        for(char c:ord.toCharArray()){
            check.put(c,check.getOrDefault(c,0)+1);
        }
        int oddcount=0;
        for(int i:check.values()){
            if(i%2!=0){
                oddcount++;
            }
        }
        char mid='a';
        if(oddcount>1){
            System.err.println("NO SOLUTION");
        }else{
            for(Map.Entry<Character,Integer> entry:check.entrySet()){
                if(entry.getValue()%2==0){
                    for(int k=0;k<entry.getValue()/2;k++){
                        org.append(entry.getKey());
                    }
                }else{
                    mid=entry.getKey();
                }
            }
            System.out.println(org.toString()+mid+org.reverse().toString());
        }
    }catch(Exception e){
        System.out.println(e);
    }
}
}
