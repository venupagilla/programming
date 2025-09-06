import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
public class distinctNumbers {
    public static void main(String args[]) throws IOException{
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> result=new HashSet<>();
        int n=Integer.parseInt(sc.readLine());
        String numbers[]=sc.readLine().split(" ");
        for(String s:numbers){
            int a=Integer.parseInt(s);
            result.add(a);
        }
        System.out.println(result.size());
    }
}
