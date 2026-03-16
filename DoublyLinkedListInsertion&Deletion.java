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
    static Node insertBeforeHead(Node head, int val){
        Node newNode = new Node(val, head, null);
        head.back = newNode; 
        return newNode;
    }
    static Node insertBeforeTail(Node head, int val){
        if(head.next == null){
            return insertBeforeHead(head, val);
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
            
        }
        Node prev = tail.back;
         Node newNode = new Node(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }
    static Node insertBeforeKthElement(Node head, int k , int val){
        if(k == 1){
            return insertBeforeHead(head, val);
        }
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    

    public static void main(String[] args){
        int[] arr = {12,3,4,5,6};

        Node head = convertArr2Dll(arr);
// head = insertBeforeHead(head, 10);
// 
// head = insertBeforeTail(head, 10);
head = insertBeforeKthElement(head, 3, 10);
        print(head);
    }
} 