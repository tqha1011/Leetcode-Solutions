/*
    Problem - 142. Linked List Cycle II (Medium)

    Goal:
    - Return the node where the cycle begins.
    - If there is no cycle, return nullptr.

    Example:
    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1 (node with value 2)

    Techniques:

    1. Floyd’s Cycle Detection (Two Pointers)
       - Time: O(n), Space: O(1)
       - Step 1: Use slow and fast pointers to detect cycle
       - Step 2: Reset one pointer to head, move both one step at a time until they meet → entry point of cycle

    2. HashSet
       - Time: O(n), Space: O(n)
       - Use a HashSet to store visited nodes
       - If a node is already in the set → start of cycle
*/

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

// ----------------------------
// Solution 1: Floyd’s Algorithm (Optimal)
// ----------------------------
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* slow = head;
        ListNode* fast = head;

        // Step 1: Detect if there is a cycle
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) break;
        }

        // No cycle
        if (fast == nullptr || fast->next == nullptr)
            return nullptr;

        // Step 2: Move slow back to head, advance both 1 step at a time
        slow = head;
        while (slow != fast) {
            slow = slow->next;
            fast = fast->next;
        }

        return slow;
    }
};

// ----------------------------
// Solution 2: HashSet (Unoptimized)
// ----------------------------
#include <unordered_set>

class SolutionHashSet {
public:
    ListNode *detectCycle(ListNode *head) {
        std::unordered_set<ListNode*> seen;
        ListNode* current = head;
        while (current != nullptr) {
            if (seen.find(current) != seen.end()) {
                return current; // Cycle detected
            }
            seen.insert(current);
            current = current->next;
        }
        return nullptr;
    }
};
