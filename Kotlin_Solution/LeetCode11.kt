/*
    Problem -11. Container With Most Water - Medium
    Given an integer array height of length n
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    🎯 Goal:
    - Return the maximum amount of water a container can store

    Example:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation : the max area and water is created by second index and eighth index
 */

/*
    Technique: Two Pointers
    Time Complexity: O(n)
    Space Complexity: O(1)

    ✅ Main Idea:
    - Initialize two pointers: left = 0, right = height.size - 1
    - While left < right:
        + Calculate area = min(height[left], height[right]) * (right - left)
        + Update the result if this area is greater than the current maximum
        + Move the pointer pointing to the shorter line:
            - If height[left] < height[right], increment left
            - Else, decrement right
 */


class Solution {
    fun maxArea(height: IntArray): Int {
        var n = height.size
        var left = 0
        var right = n - 1
        var result = 0
        while(left < right){
            if(height[left] < height[right]){
                var area = height[left] * (right - left)
                if(area > result) result = area
                left++
            }
            else{
                var area = height[right]*(right - left)
                if(area > result) result = area
                right--
            }
        }
        return result
    }
}