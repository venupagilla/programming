import java.util.Scanner;
class Checker{
	public boolean checknum(int n,int k){
		int val=(n&(1<<k));
		if(val!=0){
			System.out.println(val);
			return true;
		}
		System.out.println(val);
		return false;
	}
}
class Checkithbit{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number you want to check ");
	int n=sc.nextInt();
	System.out.println("Enter the bit position to check");
	int k=sc.nextInt();
	Checker a=new Checker();
	System.out.println(a.checknum(n,k));
	}
}