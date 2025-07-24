/*
    Problem -160 : Intersection of Two Linked Lists - Easy
    Given the heads of two linked lists
    Your goal is to find the node at which two linked list intersect
 */

/*
    Technique : HashSet , Two pointers
    Big O : O(n+m) which n = size of first list , m = size of second list
    Note : If node of headA has the same address as node of headB , that is the intersection
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
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val seen = HashSet<ListNode?>() // use set to store the address of each node
        var i = headA
        var j = headB
        while(i != null){
            seen.add(i)
            i = i.next
        }
        while(j != null){
            if(seen.contains(j)) return j
            j = j.next
        }
        return null
    }
}