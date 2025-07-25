/* 
    Problem: 141. Linked List Cycle (Easy)
    Given the head of a linked list, determine whether it contains a cycle.

    A cycle exists if a node in the list can be reached again 
    by continuously following the next pointer.
*/

/*
    Technique: Two Pointers or Hash Set
    Time Complexity: O(n), where n is the number of nodes in the list
    Space Complexity: O(n) — for storing visited nodes

    Idea: 
    - Traverse the linked list while storing the address of each visited node in a set.
    - If we encounter a node whose address is already in the set, we return true (cycle detected).
*/

class Solution {
public:
    bool hasCycle(ListNode *head) {
        set<ListNode*> seen;    // store the address of each node
        ListNode* tmp = head;
        while(tmp != NULL){
            if(seen.find(tmp) != seen.end()) return true;  
            seen.insert(tmp);
            tmp = tmp->next;
        }
        return false;
    }
};
