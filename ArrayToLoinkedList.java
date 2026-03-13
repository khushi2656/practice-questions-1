class Main {
   static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node arrayToLl(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
        
    }
    static void printList(Node head){
        Node current = head;
     while(current != null){
         System.out.print(current.data + "-->");
         current = current.next;
         
     }
     System.out.println("null");
        
    }
    
    static int getLength(Node head){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    static boolean search(Node head , int target){
        Node current = head;
        while(current != null){
            if(current.data == target){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    static int searchPosition(Node head, int target){
        Node current = head;
        int pos = 0;
        while(current != null){
            if(current.data == target)
            return pos;
            current = current.next;
            pos++;
        }
        return -1;
    }

    static Node removesTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
          temp = temp.next;  
        }
        temp.next = null;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20 , 30 , 40 , 50};
        Node head = arrayToLl(arr);
        System.out.print("List: ");
        printList(head);
        System.out.println("length:  " + getLength(head));
        System.out.println("Search 30:" + search(head, 30));
        System.out.println("position of 30:" + searchPosition(head, 30));
        //System.out.println("Removing tail...");
        head = removesTail(head);
        System.out.print("List after removing tail: ");
        printList(head);
    }
}