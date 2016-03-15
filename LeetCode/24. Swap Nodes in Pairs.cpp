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
    ListNode* swapPairs(ListNode* head) {
        if(head==NULL) return NULL;
        if(head->next == NULL) return head;
        ListNode* nextHead = head->next->next;
        ListNode* temp = head;
        head = head->next;
        head->next = temp;
        temp->next = swapPairs(nextHead);
        return head;
    }
};