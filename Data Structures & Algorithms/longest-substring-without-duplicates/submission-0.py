class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        left = 0
        seen = set()

        for i in range(len(s)):
            while s[i] in seen:
                seen.remove(s[left])
                left += 1
            seen.add(s[i])
            result = max(result, i - left + 1)
        
        return result
            

