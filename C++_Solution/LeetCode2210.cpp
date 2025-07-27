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

// Sample code

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int countHillValley(std::vector<int>& nums) {
        int result = 0;
        int n = nums.size();
        
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue; // Same region, skip
            
            int left = i - 1;
            int right = i + 1;

            // Skip duplicates on the left
            while (left >= 0 && nums[left] == nums[i]) left--;
            // Skip duplicates on the right
            while (right < n && nums[right] == nums[i]) right++;

            if (left >= 0 && right < n) {
                if (nums[i] < nums[left] && nums[i] < nums[right]) result++; // valley
                if (nums[i] > nums[left] && nums[i] > nums[right]) result++; // hill
            }
        }
        return result;
    }
};