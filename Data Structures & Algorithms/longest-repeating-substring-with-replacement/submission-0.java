class Solution {
    public int characterReplacement(String s, int k) {
        int[] a = new int[26];
        int l = 0;
        int r = 0;
        int longest = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            a[c - 'A'] = a[c - 'A'] + 1;
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                max = Math.max(max, a[i]);
            }
            while ((r - l + 1) - max > k) {
                char c1 = s.charAt(l);
                a[c1 - 'A'] = a[c1 - 'A'] - 1;
                l++; //shrink window
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }
        return longest;
    }
}
