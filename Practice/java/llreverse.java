class Node{
    int val;
    Node next;
    Node(int n){
        val=n;
    }
}
class llreverse{
    public static void main(String args[]){
        Node dummy=new Node(1);
        Node head=dummy;
        for(int i=2;i<10;i++){
            head.next=new Node(i);
            head=head.next;
        }
        Node cur=dummy;
        System.out.println("Before reversing the linkedlist : ");
        while(cur.next!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
        System.out.println("\nAfter Reversing the linkedlist : ");
        Node prev=null;
        cur=dummy;
        while(cur!=null){
            Node temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        cur=prev;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }

    }

}