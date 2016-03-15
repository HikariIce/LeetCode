/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* ret = NULL;

        if(head == NULL) return ret;
        
        ListNode *first,*last,*cur,*cur1,*cur2;
        
        last = cur = cur1 = head;
        cur2 = cur1->next;
        for(int i=0;i<k-1;++i){
            if(cur->next==NULL) return head;
            cur = cur->next;
        }
        for(int i=0;i<k-1;++i){
            ListNode* temp = cur2->next;
            cur2->next = cur1;
            cur1 = cur2;
            cur2 = temp;
        }
        first = cur1;
        last->next = reverseKGroup(cur2,k);
        return first;
    }
};