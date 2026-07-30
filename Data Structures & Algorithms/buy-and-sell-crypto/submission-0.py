class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minPrice = prices[0]
        result = 0

        for price in prices:
            minPrice = min(minPrice, price)
            result = max(result, price - minPrice)

        return result
        