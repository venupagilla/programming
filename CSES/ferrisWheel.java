//non optimal code
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// public class ferrisWheel{
//     public static void main(String args[]) throws IOException{
//         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//         int gandoles=0;
//         String[] s1=br.readLine().split(" ");
//         int n=Integer.parseInt(s1[0]);
//         int x=Integer.parseInt(s1[1]);

//         int[] childWeights=new int[n];
//         String[] s=br.readLine().split(" ");
//         for(int i=0;i<n;i++){
//             childWeights[i]=Integer.parseInt(s[i]);
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i!=j){
//                     if(childWeights[i]==-1 || childWeights[j]==-1){
//                         continue;
//                     }
//                     if(childWeights[i]+childWeights[j]<=x){
//                         childWeights[i]=-1;
//                         childWeights[j]=-1;
//                         gandoles++;
//                     }
//                 }
//             }
//         }
//         for(int i=0;i<n;i++){
//             if(childWeights[i]<=x && childWeights[i]>0){
//                 gandoles++;
//             }
//         }
//         System.out.println(gandoles);
//     }
// }


//optimal code
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class ferrisWheel{
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int gandoles=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());

        int[] childWeights=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            childWeights[i]=Integer.parseInt(st.nextToken());
        }
        int i=0,j=childWeights.length-1;
        Arrays.sort(childWeights);
        while(i<=j){
            if(childWeights[i]+childWeights[j]<=x){
                i++;
                j--;
            }else{
                j--;
            }
            gandoles++;
        }
        System.out.println(gandoles);
    }
}