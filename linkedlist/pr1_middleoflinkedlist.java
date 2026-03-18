package linkedlist;

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
// https://leetcode.com/problems/middle-of-the-linked-list/description/
// method 1: count the number of nodes and then find the middle node
class Solution {
    public ListNode middleNode(ListNode head) {
       ListNode temp = head;
       int count = 0;
       while(temp != null){
        count++;
        temp = temp.next;
       } 
       int midNode = (count/2) + 1;
       temp = head;
       while(temp != null){
        midNode = midNode - 1;
        if(midNode == 0){
            break;
           
        }
         temp = temp.next;
       }
       return temp;
    }
}

// method 2: using two pointers tortise and hare algorithm
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
}