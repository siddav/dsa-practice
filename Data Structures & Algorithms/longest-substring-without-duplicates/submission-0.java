class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(r < n) {
          while(set.contains(s.charAt(r))) {
            set.remove(s.charAt(l));
            l++;
          }
          set.add(s.charAt(r));
          longest = Math.max(longest, r - l + 1);
          r = r + 1;
        }
        return longest;
    }
}
