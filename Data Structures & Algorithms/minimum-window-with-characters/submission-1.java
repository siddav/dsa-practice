class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        int need = tMap.size();
        int have = 0;
        int l = 0;
        int r = 0;
        int eL = 0;
        int eR = 0;
        int length = Integer.MAX_VALUE;
        while (r < s.length()) {
            char rChar = s.charAt(r);
            sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);
            if (tMap.containsKey(rChar) && sMap.get(rChar).intValue() == tMap.get(rChar).intValue()) {
                have++;
            }
            while (have == need) {
                if (r - l + 1 < length) {
                    eL = l;
                    eR = r;
                    length = r - l + 1;
                }
                char lChar = s.charAt(l);
                sMap.put(lChar, sMap.get(lChar) - 1);
                if (tMap.containsKey(lChar) && sMap.get(lChar) < tMap.get(lChar)) {
                    have--;
                }
                l++;
            }
            r++;
        }
        if (length == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(eL, eR + 1);
    }
}
