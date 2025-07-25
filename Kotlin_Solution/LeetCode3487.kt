/*
    Problem -3487. Maximum Unique Subarray Sum After Deletion - Easy
    Given an integer array
    Your goal : return the maximum sum of such a subarray
    A subarray such that:
        - All elements in the subarray is unique
        - The sum of the elements in the subarray is maximized
 */

/*
    Technique: HashSet
    Time Complexity : O(n)
    Main idea : Use HashSet to collect unique elements and find the maximum sum
    Special case:
        - All of elements are negative : we need to return the max negative element  (1)
        - Array's size = 1 : return the only element  (2)
 */

class Solution {
    fun maxSum(nums: IntArray): Int {
        val seen = HashSet<Int>()
        var max = Int.MIN_VALUE
        var sum = 0
        for (i in nums.indices) {
            if (nums[i] > max) max = nums[i]
        }
        if (max < 0) return max      // solve special case (1)
        for (i in nums.indices) {
            if (!seen.contains(nums[i]) && nums[i] >= 0) sum += nums[i]
            seen.add(nums[i])
        }
        return sum
    }
}