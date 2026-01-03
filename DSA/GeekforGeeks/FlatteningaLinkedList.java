/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class FlatteningaLinkedList {
    static Node merge(Node node1,Node node2){
        Node dummy=new Node(-1);
        Node res=dummy;
        while(node1!=null && node2!=null){
            if(node1.data<node2.data){
                res.bottom=node1;
                node1=node1.bottom;
                res=res.bottom;
            }else{
                res.bottom=node2;
                node2=node2.bottom;
                res=res.bottom;
            }
            res.next=null;
        }
        if(node1!=null){
            res.bottom=node1;
        }else{
            res.bottom=node2;
        }
        if(dummy.bottom!=null) dummy.bottom.next=null;
        return dummy.bottom;
    }
    
    public Node flatten(Node root) {
        // code here
        if(root==null || root.next==null){
            return root;
        }
        Node merged=flatten(root.next);
        root=merge(root,merged);
        return root;
    }
}