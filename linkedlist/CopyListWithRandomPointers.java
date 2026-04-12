/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    static void copyInBtw(Node head){
        Node temp = head;
        while(temp != null){

            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;

        }
    }

    static void connectRandom(Node head){
        Node temp = head;
        while(temp != null){
           Node copyNode = temp.next;
           if(temp.random != null){
            copyNode.random = temp.random.next;
           }else {
            copyNode.random = null;
           }
           temp = temp.next.next;
        }
    }

    static Node connectNext(Node head){
        Node temp = head;
        Node dNode = new Node(-1);
        Node res = dNode;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dNode.next;

    }
    public Node copyRandomList(Node head) {
        copyInBtw(head);
        connectRandom(head);
        return connectNext(head);
    }
}