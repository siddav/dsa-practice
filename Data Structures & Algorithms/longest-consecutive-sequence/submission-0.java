class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n: nums) {
            s.add(n);
        }
        int longest = 0;
        for(int n: nums) {
            if(!s.contains(n-1)) {
                int currentLength = 0;
                while(s.contains(n + currentLength)) {
                    currentLength = currentLength + 1;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }
}
