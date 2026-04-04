/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp; 
            temp = next;
        }
        return prev;
    }
    static ListNode findKthNode(ListNode temp , int k){
        k--;
        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode KthNode = findKthNode(temp , k);
            if(KthNode == null){
                if(prevNode != null)prevNode.next = temp;
                
                break;
            }
            ListNode nextNode = KthNode.next;
            KthNode.next = null;
            ListNode newHead = reverse(temp);
            if(temp == head){
                head = KthNode;
            } else {
                prevNode.next = KthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}