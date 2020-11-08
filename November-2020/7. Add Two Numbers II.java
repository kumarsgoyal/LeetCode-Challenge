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
    int len;
    
    public ListNode reverse(ListNode l) {
        ListNode prev = null;
        ListNode next = null;
        
        while(l != null) {
            len++; 
            next = l.next;
            l.next = prev;
            prev = l;
            l = next;
        }
        return prev;
    }
    
    public ListNode addTwoNumbersUtil(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode prev = null;
        ListNode head = l1;
        
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = 0;
            if(sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            
            l1.val = sum;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            sum = l1.val + carry;
            carry = 0;
            if(sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            l1.val = sum;
            prev = l1;
            l1 = l1.next;
        }
        
       if(carry != 0) {
           prev.next = new ListNode(carry);
       } 
       
       head = reverse(head);
        
       return head;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        len = 0;
        l1 = reverse(l1);
        int len1 = len;
        len = 0;
        l2 = reverse(l2);
        int len2 = len;
        
        return (len1 > len2) ? addTwoNumbersUtil(l1, l2) : addTwoNumbersUtil(l2, l1);
    }
}
