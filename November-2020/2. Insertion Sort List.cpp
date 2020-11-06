class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
         ListNode *dummy = new ListNode(0);
        ListNode *tail = dummy;
        ListNode *curr = head;
        
        while(curr) {
            ListNode *next = curr->next;
            
            // Either resultant list is empty or last element in resultant list
            // is smaller than curr element insert in last of resultant list
            if(tail == dummy || tail->val < curr->val) {
                tail->next = curr;
                tail = tail->next;
                tail->next = NULL;
            }
            else {
                ListNode *res_curr = dummy;
                while(res_curr != tail && res_curr->next->val < curr->val) {
                    res_curr = res_curr->next;
                }
                
                auto temp = res_curr->next;
                res_curr->next = curr;
                curr->next = temp;
            }
            
            curr = next;
        }
        
        tail = dummy->next;
        delete dummy;
        return tail;
    }
};
