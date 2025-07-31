/*
    Problem - 203. Remove Linked List Elements - Easy
    Given the head of a linked list and an integer val

    Goal:
    - Remove all the nodes of the linked list that have Node.val == val
    - Return the new head of the list

    Example:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
*/

/*
    Techniques: Remove elements from a linked list
    Time Complexity: O(n)
    Space Complexity: O(1)
    Main idea:
        - Create a dummy node and link it to the head of the list
        - Use a pointer 'cur' to traverse the list starting from dummy
        - If cur->next->val == val, bypass that node by cur->next = cur->next->next
        - Else, move cur forward
*/


struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 

class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* dummy = new ListNode(0); // Create dummy node
        dummy->next = head;
        ListNode* cur = dummy;

        // Traverse the list and remove matching elements
        while (cur->next != nullptr) {
            if (cur->next->val == val) {
                cur->next = cur->next->next; // Skip the node with matching value
            } else {
                cur = cur->next; // Move to the next node
            }
        }

        ListNode* newHead = dummy->next; // New head after removals
        delete dummy; // Clean up the dummy node to avoid memory leak
        return newHead;
    }
};
