class ll{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int a){
            this.data=a;
            this.next=null;
        }
    }

    void addFirst(int a){
        Node current=new Node(a);
        if(head==null){
            head=current;
            return ;
        }
        current.next=head;
        head=current;
    }

    void addLast(int a){
        Node current=new Node(a);
        Node cur=head;
        if(head==null){
            head=current;
            return ;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=current;
    }

    void printLast(){
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        System.out.println(cur.data);
    }

    void printAll(){
        Node cur=head;
        while(cur.next!=null){
            System.out.print(cur.data + " -> ");
            cur=cur.next;
        }
        System.err.println(cur.data);
    }
}
class linkedlistprac1{
    public static void main(String[] args) {
        ll hello=new ll();
        hello.addFirst(10);
        hello.addFirst(30);
        hello.addFirst(50);
        hello.addFirst(100);
        hello.addLast(1000);
        System.out.print("The last element is : ");
        hello.printLast();

        hello.printAll();

    }
}