/*
    Problem -125. Valid Palindrome - Easy
    A palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
    Alphanumeric characters include letters and numbers.
    Goal : Return true if palindrome , or false otherwise

    Example:
    Input: s = "A man, a plan, a canal: Panama"
    Output : true
    Explanation: "amanaplanacanalpanama" is a palindrome.
 */

/*
    Technique : Two Pointers
    Time Complexity : O(n)
    Space Complexity : O(1)
    Main idea : Two Pointers : i = 0 , j = s.length - 1. At each step:
                - Check valid alphanumeric character
                - If s[i] != s[j] , return false
 */

// Solution 1
class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) return true

        val result = StringBuilder()

        for (i in s.indices) {
            if (s[i].isLetterOrDigit()) {
                result.append(s[i].lowercaseChar())
            }
        }

        var i = 0
        var j = result.length - 1
        while (i <= j) {
            if (result[i] != result[j]) return false
            i++
            j--
        }

        return true
    }
}

// Solution 2
class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while(i < j){
            while(i < j && !s[i].isLetterOrDigit()) i++
            while(i < j && !s[j].isLetterOrDigit()) j--

            if(s[i].lowercaseChar() != s[j].lowercaseChar()) return false
            i++
            j--
        }
        return true
    }
}
