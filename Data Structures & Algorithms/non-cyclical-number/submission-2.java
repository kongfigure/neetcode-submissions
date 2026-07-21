class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> visited = new HashSet<>();
        int sum = square(n);
        
        while(!visited.contains(sum)) {
            visited.add(sum);
            sum = square(sum);
            if(sum == 1) {
                return true;
            } 
        }
        return false;
    }

    private int square(int n) {
        int sumSquare = 0;
        while(n > 0) {
            int digit = n % 10;
            sumSquare += digit*digit;
            n /= 10;
        }
        return sumSquare;
    }
}
