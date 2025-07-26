/*
    Problem -94. Binary Tree Inorder Traversal - Easy
    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Example
    Input: root = [1,null,2,3]
    Output: [1,3,2]
 */

/*
    Techique : recursion
    Main idea : Inorder traversal ( left - root - right )
    Time Complexity : O(n) - since visiting all nodes
    Space Complaxity : O(h) - due to recursion stack ( h = height of tree )
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
    fun inorder(root : TreeNode? , result : MutableList<Int>){
        if(root!= null){
            inorder(root.left,result)
            result.add(root.`val`)
            inorder(root.right,result)
        }
    }
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inorder(root,result)
        return result
    }
}
