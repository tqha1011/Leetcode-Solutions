/*
    Problem - 104. Maximum Depth of Binary Tree - Easy

    Given the root of binary tree

    🎯 Goal:
    - Return the maximum depth of the binary tree.
    - The depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
*/

/*
    Technique : Recursion
    Time Complexity : O(n)
    Space Complexity : O(h) - h = height of tree
    ✅ Main idea : Use recursion ( DFS )
                - Base case : if the root is null , return 0
                - Recursive cave : depth = max(depth of left subtree , depth of right subtree ) + 1
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        return maxOf(maxDepth(root.left) , maxDepth(root.right)) + 1
    }
}