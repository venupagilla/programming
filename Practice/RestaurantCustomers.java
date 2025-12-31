import java.util.*;
import java.io.*;
class RestaurantCustomers{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arrive =new int[n];
		int[] leave=new int[n];
		for(int i=0;i<n;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			arrive[i]=Integer.parseInt(st.nextToken());
			leave[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrive);
		Arrays.sort(leave);
		int i=0,j=0;
		int maxcust=0,curcust=0;
		while(i<n && j<n){
			if(arrive[i]<leave[j]){
				curcust++;
				maxcust=Math.max(curcust,maxcust);
				i++;
			}else{
				curcust--;
				j++;
			}
		}
		System.out.println(maxcust);
	
	}
}
