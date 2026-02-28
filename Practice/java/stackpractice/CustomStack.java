public class CustomStack{
    int[] data;
    public static final int DEFAULT=10;
    public CustomStack(){
        this(DEFAULT);
    }
    public CustomStack(int size){
        data=new int[size];
    }

    int ptr=-1;
    public boolean push(int num) throws CustomException{
        if(ptr==data.length-1){
            throw new CustomException("The stack is full cannot insert");
        }
        data[++ptr]=num;
        return true;
    }
    public int pop() throws CustomException{
        if(ptr==-1) throw new CustomException("The stack is empty cannot pop");
        int cur=data[ptr--];
        return cur;
    }
    public int peek(){
        return data[ptr];
    }
    
}
