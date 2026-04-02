/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        Node left = head;
        Node right = findTail(head);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        
        while (left != null && right != null && left != right && right.next != left){
            if(left.data + right.data == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);
                right = right.prev;
                left = left.next;
            } else if(left.data + right.data < target){
                left = left.next;
        } else{
            right = right.prev;
        }
        }
         
        return ans;
        
    }
     static Node findTail(Node head){
            Node tail = head;
            while(tail.next != null){
                tail = tail.next;
               
            }
             return tail;
        }
}
