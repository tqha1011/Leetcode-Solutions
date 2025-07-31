/*
    Problem -203. Remove Linked List Elements - Easy
    Given the head of a linked list and an integer val

    Goal:
    - Remove all the nodes of the linked list that has Node.val == val
    - Return the newHead

    Example:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
 */

/*
    Techniques : Remove in linked list
    Time Complexity : O(n)
    Space Complexity : O(1)
    Main idea : Create dummy node - link to the head of list
                - Create node cur (link to dummy) to traverse the list
                - If cur.next.val = val , cur.next = cur.next.next
 */

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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(0)     // dummy node
        dummy.next = head
        var cur = dummy
        while (cur.next != null) {
            if (cur.next?.`val` == `val`) {
                cur.next = cur.next?.next
            } else {
                cur = cur.next!!
            }
        }
        val newHead = dummy.next
        return newHead
    }
}
