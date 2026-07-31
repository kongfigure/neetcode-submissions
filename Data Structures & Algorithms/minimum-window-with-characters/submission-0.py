class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""

        need = Counter(t)
        have = {}
        required = len(need)
        formed = 0

        left = 0
        result = ""
        resultLen = float('inf')

        for right in range(len(s)):
            c = s[right]
            have[c] = have.get(c, 0) + 1
            
            if c in need and have[c] == need[c]:
                formed += 1

            while formed == required:
                if right - left + 1 < resultLen:
                    resultLen = right - left + 1
                    result = s[left: right + 1]

                have[s[left]] -= 1
                if s[left] in need and have[s[left]] < need[s[left]]:
                    formed -= 1
                left += 1

        return result