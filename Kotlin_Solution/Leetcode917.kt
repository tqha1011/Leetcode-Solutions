/*
    Problem -917.Reverse Only Letters - Easy
    Given a string , reverse the string with below conditions
        - All the characters that are not English letters remains in the same position
        - All the English letters (lowercase or uppercase) should be reversed.
    Return string after reversing

    Example:
    Input : ab-cd
    Output: dc-ba
    Explain: All the English letter were reversed without "-" because it is not the English Letter
 */

/*
    Technique : Two pointers
    Big O : O(n)
 */

class Solution {
    fun reverseOnlyLetters(s: String): String {
        val chars = s.toCharArray()
        var i = 0   // One pointer at head
        var j = chars.lastIndex // One pointer at the end

        while (i < j) {
            if (!chars[i].isLetter() && !chars[j].isLetter()) {  // check the valid characters
                i++
                j--
            } else if (!chars[i].isLetter()) {
                i++
            } else if (!chars[j].isLetter()) {
                j--
            } else {
                // swap the letter if both are valid characters
                val tmp = chars[i]
                chars[i] = chars[j]
                chars[j] = tmp
                i++
                j--
            }
        }

        return String(chars)
    }
}


