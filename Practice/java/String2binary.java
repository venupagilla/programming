public class String2binary {

    static String convert(int n){
        if (n==0) return "0";
        StringBuilder st=new StringBuilder();
        while(n>0){
            st.append(n%2);
            n/=2;
        }
        st.reverse();
        return st.toString();
    }
    public static void main(String args[]){
        int a=8;
        System.out.println((convert(a)));
    }
}
