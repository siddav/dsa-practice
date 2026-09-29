class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = s.length();
        int i = 0;
        while (i < length / 2) {
            char l = s.charAt(i);
            char r = s.charAt(length - i - 1);
            if (l != r) {
                return false;
            }
            i++;
        }
        return true;
    }
}
