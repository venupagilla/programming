import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class creatingStrings {
    static void generatePermetutation(char[] characters1,boolean[] used,StringBuilder cur){
        if(cur.length()==characters1.length){
            result.add(cur.toString());
            return;
        }
        for(int i=0;i<characters1.length;i++){
            if(used[i]) continue;
            if(i>0 && characters1[i]==characters1[i-1] && !used[i-1]) continue;
            used[i]=true;
            cur.append(characters1[i]);
            generatePermetutation(characters1, used, cur);
            cur.deleteCharAt(cur.length()-1);
            used[i]=false;
        }

    }
    static ArrayList<String> result=new ArrayList<>();
    public static void main(String args[]){
        try(Scanner sc=new Scanner(System.in)){
        String input1=sc.nextLine();
        char[] characters1=input1.toCharArray();
        boolean[] used=new boolean[characters1.length];
        StringBuilder cur=new StringBuilder();
        Arrays.sort(characters1);
        generatePermetutation(characters1,used,cur);
        System.out.println(result.size());
        for(String s:result){
            System.out.println(s);
        }
        sc.close();
    }
    }
}
