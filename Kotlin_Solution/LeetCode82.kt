/*
    Problem - 82. Remove Duplicates from Sorted List II (Medium)

    🎯 Goal:
        - Delete all nodes that have duplicate numbers
        - Leave only distinct numbers from the original list
        - Note: The input list is sorted in ascending order

        Example:
        Input:  head = [1,2,3,3,4,4,5]
        Output: [1,2,5]
        Explanation: Remove all occurrences of 3 and 4
*/

/*
    ✅ Solution 1: HashMap (Not optimal but easy to understand)
        - Step 1: Traverse the list and count the frequency of each value
        - Step 2: Build a new list containing only values with frequency = 1
        - Time Complexity: O(n)
        - Space Complexity: O(n) due to the HashMap

    ✅ Solution 2: Two Pointers (Optimal)
        - Step 1: Use two pointers (prev, cur) to traverse the list
        - Step 2: Skip nodes with duplicate values
        - Step 3: Link only nodes that have no duplicates
        - Time Complexity: O(n)
        - Space Complexity: O(1)
*/


// ✅ Solution 1: HashMap
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val frequency = HashMap<Int, Int>()
        var tmp = head
        var cur = head

        // Step 1: Count the frequency of each value
        while (tmp != null) {
            frequency[tmp.`val`] = frequency.getOrDefault(tmp.`val`, 0) + 1
            tmp = tmp.next
        }

        // Step 2: Find the first non-duplicate node
        while (cur != null && frequency[cur.`val`]!! > 1) {
            cur = cur.next
        }

        val newHead = cur
        var tail = newHead
        var current = cur?.next

        // Step 3: Connect nodes with frequency == 1
        while (current != null) {
            if (frequency[current.`val`] == 1) {
                tail?.next = current
                tail = tail?.next
            }
            current = current.next
        }

        tail?.next = null // Terminate the list
        return newHead
    }
}


// ✅ Solution 2
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var prev: ListNode? = head
        var cur: ListNode? = head
        var newHead: ListNode? = null
        var tail: ListNode? = null

        // Step 1: Find the first non-duplicate node
        while (prev != null) {
            var count = 0
            while (cur != null && cur.`val` == prev.`val`) {
                count++
                cur = cur.next
            }

            if (count == 1) {
                newHead = prev
                tail = newHead
                break
            } else {
                prev = cur
            }
        }

        // If no unique node found
        if (newHead == null) return null

        // Step 2: Continue scanning the list and connect unique nodes
        prev = cur
        cur = cur?.next

        while (prev != null) {
            var count = 1
            while (cur != null && cur.`val` == prev.`val`) {
                count++
                cur = cur.next
            }

            if (count == 1) {
                tail?.next = prev
                tail = tail?.next
            }

            prev = cur
            cur = cur?.next
        }

        tail?.next = null // Terminate the list
        return newHead
    }
}

