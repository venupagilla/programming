import java.util.*;
public class repetitions {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        char[] letters=name.toCharArray();
        int length=0;
        int current=0;
        while(current<name.length()){
            if(name.length()==1){
                length=1;
                break;
            }
            int count=1;
            for(int c=current;c<name.length()-1;c++){
                if(letters[c]==letters[c+1]){
                    count++;
                    current++;
                }else{
                    break;
                }
            }
            current++;
            if(length<count)
            length=count;
        }
        sc.close();
        System.out.println(length);
    }
}
