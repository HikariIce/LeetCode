/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;  
        int len = 1;  
        ListNode cursor = head;  
        while(cursor.next != null) {  
            len ++;  
            cursor = cursor.next;  
        }  
        cursor.next = head;  
        k = len - k % len;  
        for (int i = 0; i < k; i++) {  
            cursor = cursor.next;  
        }  
        head = cursor.next;  
        cursor.next = null;  
        return head;  
    }
}