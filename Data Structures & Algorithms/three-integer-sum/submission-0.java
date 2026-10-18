class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> l = new ArrayList<>();
        int ll = 0;
        int rr = a.length - 1;
        while (ll <= rr) {
            if (ll > 0 && a[ll] == a[ll - 1]) {
                ll++;
                continue;
            }
            int lt = ll + 1;
            int rt = rr;
            while (lt < rt) {
                int sum = a[lt] + a[rt] + a[ll];
                if (sum < 0) {
                    lt++;
                }
                else if (sum > 0) {
                    rt--;
                }
                else {
                    l.add(Arrays.asList(a[ll], a[lt], a[rt]));
                    lt++;
                    while (lt < rt && a[lt - 1] == a[lt]) {
                        lt++;
                    }
//                    rt--;
//                    while (lt < rt && a[rt] == a[rt + 1]) {
//                        rt--;
//                    }
                }
            }
            ll++;
        }
        return l;
    }
}
