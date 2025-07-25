/*
    Problem -167. Two sum II - Input Array Is Sorted - Medium
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order
    Your goal : find two indices of two numbers such that they add up to a specific TARGET number
    Note: You may not use the same element twice.

    Example:
    Input : [2,7,11,15] , TARGET : 9
    Output : [1,2]
    Explain : Two numbers are 2 and 7 and their index respectively is 0 , 1
 */

/*
    Technique : Two Pointers
    Time Complexity : O(n)
    Space Complexity : O(1)
    Main idea : We use the pointer i = 0 and the pointer j = array.size - 1.
                At each step , we call sum = array[i] + array[j]
                Because the array is sorted in non-decreasing order:
                    - If sum is > target , it means array[j] is too large , so we decrease j by 1
                    - If sum is < target , it means array[i] is too small , so we increase i by 1
 */

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1
        while(i < j){
            var sum = numbers[i] + numbers[j]
            if(sum > target) j--
            else if(sum < target) i++
            else break
        }
        val result = intArrayOf(i+1,j+1)
        return result
    }
}