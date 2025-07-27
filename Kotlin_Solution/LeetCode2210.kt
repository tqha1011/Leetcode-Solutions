/*
    Problem -2210. Count Hills and Valleys in Array - Easy
    Given an a 0-indexed integer array (nums)

    An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]

    Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]

    Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

    Note : for an index to be part of a hill or valley, it must have a non-equal neighbor on BOTH the left and right of the index.

    Goals : Return the numbers of hills and valleys
 */

/*
    Technique : Two Pointers scanning with skip duplicates
    Time Complexity : O(n)
    Space Complexity : O(1)
    Main idea : At each index i :
                - We use two pointers : left = i - 1 , right = i + 1
                - We scan if nums[left] == nums[i] , left--
                - Similarly , if nums[right] == nums[i] , right ++
                - If nums[i] < nums[left] && nums[i] < nums[right] , we found valley
                - If nums[i] > nums[left] && nums[i] > nums[right] , we found hill
 */

class Solution {
    fun countHillValley(nums: IntArray): Int {
        var result = 0
        for(i in 1 .. nums.size-1){
            if(nums[i] == nums[i-1]) continue  // nums[i] and nums[i-1] are part of the same hill or valley
            var left = i-1
            var right = i+1
            while(left >= 0 && nums[i] == nums[left]) left--
            while(right < nums.size && nums[i] == nums[right]) right++
            if(left >= 0 && right < nums.size){
                if(nums[i] < nums[left] && nums[i] < nums[right]) result++ // valley
                if(nums[i] > nums[left] && nums[i] > nums[right]) result++  // hill
            }
        }
        return result
    }
}