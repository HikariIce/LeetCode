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
    class comp{
    public:
        bool operator() (const ListNode* l, const ListNode* r) const {  
            return (l->val > r->val);  
        }  
    };
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* head = NULL;
        ListNode* cur = NULL;
        vector<ListNode*>::iterator it = lists.begin();  
        while(it != lists.end()) {  
            if(*it == NULL) lists.erase(it);  
            else ++it;  
        }  
        if(lists.empty()) return head;
        make_heap(lists.begin(),lists.end(),comp());
        while(lists.size()>0){
            if(head==NULL) head = cur = lists[0];
            else{
                cur->next = lists[0];
                cur = cur->next;
            }
            pop_heap(lists.begin(),lists.end(),comp());
            int last = lists.size()-1;
            if(lists[last]->next != NULL){
                lists[last] = lists[last]->next;
                push_heap(lists.begin(),lists.end(),comp());
            }
            else lists.pop_back();
        }
        return head;
    }
    
};