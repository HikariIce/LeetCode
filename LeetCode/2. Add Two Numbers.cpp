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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1==NULL && l2==NULL)
            return NULL;
        if(l1==NULL && l2!=NULL)
            return l2;
        if(l1!=NULL && l2==NULL)
            return l1;
        
        int c=0;
        ListNode *head = NULL , *pre = NULL;
        
        while(l1!=NULL||l2!=NULL||c!=0){
            if(l1!=NULL){
                c+=l1->val;
                l1=l1->next;
            }
            if(l2!=NULL){
                c+=l2->val;
                l2=l2->next;
            }
            ListNode *p = new ListNode(c%10);
            if(head==NULL)
                head=p;
            else 
                pre->next=p;
            pre=p;
            c=c/10;
        }
        return head;
    }
};