class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> s1 = new HashMap<>();
        Map<Character, Integer> s2 = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            s1.put(c, s1.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            s2.put(c, s2.getOrDefault(c, 0) + 1);
        }
        return s1.equals(s2);
    }
}
