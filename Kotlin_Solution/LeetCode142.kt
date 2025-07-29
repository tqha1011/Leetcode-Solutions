/*
    Problem - 142. Linked List Cycle II (Medium)

    Goal:
    - Return the node where the cycle begins.
    - If there is no cycle, return null.

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


// Solution 1 : Two Pointers + Floyd's Algorithm -- Space Complexity : O(1)
class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast) break
        }

        if (fast == null || fast.next == null) return null
        slow = head
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        return slow
    }
}

// Solution 2 : HashSet -- Space Complexity : O(n)
class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow : ListNode? = head
        var seen = HashSet<ListNode?>()
        while(slow != null){
            if(!seen.contains(slow)){
                seen.add(slow)
                slow = slow.next
            }
            else return slow
        }
        return null
    }
}
