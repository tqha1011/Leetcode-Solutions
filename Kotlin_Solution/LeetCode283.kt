/*
    Problem -283. Move Zeroes - Easy

    🎯 Goal:
    - Move all 0's to the end of it while maintaining the relative order of the non-zero elements

    Example:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
 */

/*
    Technique: Two-pass solution with a write pointer
    Time Complexity : O(n)
    Space Complexity : O(1)
    Main idea : Move all non-zero numbers to the front of the array. Then assign zero to the remaining elements
 */

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var notzero = 0  // Pointer to track the next position for a non-zero element

        for (i in nums) {
            if (i != 0) {
                nums[notzero] = i  // Move non-zero element to the front
                notzero++
            }
        }

        // Fill the rest with zeros
        while (notzero < nums.size) {
            nums[notzero] = 0
            notzero++
        }
    }
}
