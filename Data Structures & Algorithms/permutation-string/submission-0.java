class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for(char c: s1.toCharArray()) {
            count[c - 'a']++;
        }
        int[] s2count = new int[26];
        for(int i = 0; i < s2.length(); i++) {
            s2count[s2.charAt(i) - 'a'] ++;

            if(i >= s1.length()) {
                s2count[s2.charAt(i - s1.length()) - 'a']--;
            }
            if(Arrays.equals(count, s2count)) {
                return true;
            }
        }
        return false;
    }
}
