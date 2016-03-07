class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        str = "^#" + "#".join(s) + "#$"
 
        i = 1
        mx = 0
        id = 0
        p = [0 ] * len(str)
        while i<len(str)-1:
            if mx >= i:
                p[i] = min(p[ 2*id-i],mx-i)
            else:
                p[i] = 0
 
            while i-p[i] >=0 and i+p[i] < len(str)-1 and str[i-p[i]-1]==str[i+p[i]+1]:
                p[i] += 1
 
            if mx < p[i]+i:
                mx = p[i] + i
                id = i
            i+=1

        ma = max(p)
        idx = p.index(ma)

        return s[(idx-ma-1)/2:(idx-ma-1)/2+ma]
        