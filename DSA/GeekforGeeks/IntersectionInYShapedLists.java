/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Set<Node> visited=new HashSet<>();
        Node temp1=head1;
        while(temp1!=null){
            visited.add(temp1);
            temp1=temp1.next;
        }
        Node temp2=head2;
        while(temp2!=null){
            if(visited.contains(temp2)){
                return temp2;
            }
            temp2=temp2.next;
        }
        return head1;
    }
}