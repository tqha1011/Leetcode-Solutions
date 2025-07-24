/*
    Problem -1695. Maximum Erasure Value - Medium
    Given an array of positive intergers , and want to erase a subarray containing unique elements
    Your goal is to find the maximum score you can get by erasing exactly one subarray

    Example
    Input: array = [4,2,4,5,6]
    Output: 17
    Explain : the subarray is [2,4,5,6] , sum = 17
 */

/*
    Technique : HashSet , Sliding Window , HashMap
 */

// Solution 1 ( Not optimal - Use HashMap)
// Big O Nation : Approximately O(n)

class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val mp = HashMap<Int,Int>()
        var left = 0
        var sum = nums[left]
        var maxsum = sum
        mp[nums[left]] = left
        for(i in 1 until nums.size){
            if(mp.contains(nums[i]) && mp[nums[i]]!! >= left){
                left = mp[nums[i]]!! + 1
                sum = 0
                for(j in left .. i){       // caculate sum again
                    sum+=nums[j]
                }
                mp[nums[i]] = i
            }
            else{
                sum+=nums[i]
                mp[nums[i]] = i
                maxsum = maxOf(maxsum,sum)
            }
        }
        maxsum = maxOf(maxsum,sum)
        return maxsum
    }
}

// Solution 2 (Optimal - Use HashSet)
// Big O : O(n)

class Solution{
    fun maximumUniqueSubarray(nums: IntArray): Int{
        val seen = HashSet<Int>()
        var left = 0
        var sum = 0
        var maxsum = 0
        for(i in nums.indices){
            while(seen.contains(nums[i])){
                sum-=nums[left]
                seen.remove(nums[left])
                left++
            }
            sum+=nums[i]
            seen.add(nums[i])
            maxsum = maxOf(maxsum,sum)
        }
        return maxsum
    }
}
