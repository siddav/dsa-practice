class Solution {
    public String encode(List<String> strs) {
        String res = "";
        for (String s : strs) {
            res = res + s.length() + "#" + s;
        }
        System.out.println("res " + res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        char[] ch = str.toCharArray();
        int i = 0;
        for (; i < ch.length;) {
            String l = "";
            while (ch[i] != '#') {
                l = l + "" + ch[i];
                i++;
            }
            int ll = Integer.parseInt(l);
            res.add(str.substring(i + 1, i+ 1 + ll));
            l = "";
            i = i + ll + 1;
        }
        return res;
    }
}
