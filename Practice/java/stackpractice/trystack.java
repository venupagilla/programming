public class trystack {
    public static void main(String args[]) throws CustomException{
        CustomStack a1=new CustomStack(2);
        System.out.println(a1.push(1));
        System.out.println(a1.push(2));
        System.out.println(a1.push(3));
        System.out.println(a1.pop());
        System.out.println(a1.pop());
        System.out.println(a1.pop());
    }
}
