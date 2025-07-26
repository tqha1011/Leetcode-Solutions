/*
    Problem -121. Best Time to Buy and Sell Stock - Easy
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    Goals: maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Example:
    Input: [7,1,5,3,6,4]
    Output: 5
    Explain: Buy on day 2 (price = 1) and sell on day 5 ( price = 6)
    Note : You cannot buy on day 2 and sell on day 1
*/


/*
    Technique : Two Pointers
    Time Complexity : O(n)
    Space Complexity : O(1)
    Main idea : Use two pointers (i = 0 && j = 1). At each step:
                - i locates the day we buy stock , j locate the day we will sell
                - Sum = prices[j] - prices[i]
                - If sum > profit : profit = sum
                - Note: If prices[j] < prices[i] , we move i to j to set new prices[i]
*/

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var i = 0
        var j = 1
        while(j < prices.size){
            if(prices[i] > prices[j]){
                i = j
                j++
            }
            else{
                var price = prices[j] - prices[i];
                if(price > profit) profit = price
                j++
            }
        }
        return profit
    }
}