import java.util.ArrayList;
import java.util.Scanner;
public class twoSets {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        int totalSum=(n*(n+1))/2;
        if(totalSum%2!=0){
            System.out.println("NO");
        }else{
            ArrayList<Integer> set1=new ArrayList<>();
            ArrayList<Integer> set2=new ArrayList<>();
            int half=totalSum/2;
            int cur=0;
            for(int i=n;i>0;i--){
                if(cur+i<=half){
                    cur+=i;
                    set1.add(i);
                }else{
                    set2.add(i);
                }
            }
            if(cur==half){
                System.out.println("YES");
                System.out.println(set1.size());
                for(int i=0;i<set1.size();i++){
                    System.out.print(set1.get(i)+" ");
                }
                System.out.println();
                System.out.println(set2.size());
                for(int i=0;i<set2.size();i++){
                    System.out.print(set2.get(i)+" ");
                }
            }else{
                System.out.println("NO");
            }
        }
    }
}
