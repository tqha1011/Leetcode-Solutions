/*
    Problem -21. Merge Two Sorted List - Easy
    Given the heads of two sorted linked list
    Your goal : Merge two sorted list into one sorted list
 */

/*
    Techique : Two pointers
    Main idea: Use two pointers to iterate through both sorted linked lists.
               At each step, compare the current nodes and attach the smaller one to the result list.
               Continue until one list is exhausted, then attach the remaining part of the other list.
    Time Complexity : O(n+m) which n = length of list1 , m = length of list2
    Space Complexity : O(1)
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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) return list2
        if(list2 == null) return list1
        var l1 = list1
        var l2 = list2
        var head :ListNode? = null
        var tail :ListNode? = null
        if(l1.`val` <= l2.`val`){
            head = l1
            tail = head
            l1 = l1.next
        }
        else{
            head = l2
            tail = head
            l2 = l2.next
        }
        while(l1 != null && l2 != null){
            if(l1.`val` <= l2.`val`){
                tail!!.next = l1
                l1 = l1.next
            }
            else{
                tail!!.next = l2
                l2 = l2.next
            }
            tail = tail!!.next
        }
        if(l1 != null) tail!!.next = l1
        if(l2 != null) tail!!.next = l2
        return head
    }
}