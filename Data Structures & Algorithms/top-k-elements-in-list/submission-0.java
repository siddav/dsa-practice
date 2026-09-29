class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> h = new HashMap<>();
        for(int n: nums) {
            h.put(n , h.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for(Map.Entry<Integer, Integer> e: h.entrySet()) {
            q.offer(new int[]{e.getValue(), e.getKey()});
            if(q.size() > k) {
                q.poll();
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = q.poll()[1];
        }
        return res;
    }
}
