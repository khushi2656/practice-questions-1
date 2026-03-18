class Node {
    int data;
    Node next;
    Node back;

    Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(int data, Node next, Node back){
        this.data = data;
        this.next = next;
        this.back = back;
    }
}
public class Main {

    static Node convertArr2Dll(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    static Node reverseDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node current = head;
        while(current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        
        }
        return prev.back;
    }
}