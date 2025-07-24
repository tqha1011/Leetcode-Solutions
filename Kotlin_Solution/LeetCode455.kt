/* Problem -455. Assign Cookies
     Given two arrays (greed factor : g) and size (s) .
     If(s[j] >= g[i]) , we can assign the cookie j to the children i
     The goai is to find the maximum number of your content children
 */

/*
    Techniques : Two Pointer in sorted Array
    Big O Nation : O(nlogn)
 */

class solution{
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        // we need to sort two arrays
        g.sort()
        s.sort()
        var i = 0
        var j = 0
        var result = 0
        while(i < g.size && j < s.size){
            if(s[j] >= g[i]){
                result++
                i++
                j++
            }
            else j++
        }
        return count
    }
}