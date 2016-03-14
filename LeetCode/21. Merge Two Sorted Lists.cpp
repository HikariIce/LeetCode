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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* l;
        ListNode* head ;
        if(l1==NULL) return l2;
        if(l2==NULL) return l1;
        head = new ListNode(0);
        l = head;
        while(l1!=NULL && l2!=NULL){
            if(l1->val < l2->val){
                l->next = l1;
                l1 = l1->next;
                l = l->next;
            }else{
                l->next = l2;
                l2 = l2->next;
                l = l->next;
            }
        }
        if(l1==NULL) l->next = l2;
        else l->next = l1;
        return head->next;
    }
};