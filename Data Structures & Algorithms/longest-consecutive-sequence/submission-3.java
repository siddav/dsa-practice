class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 1 || nums.length == 0) {
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 0;
        int curr = nums[0];
        int streak = 1;
        int i = 1;
        while (i < nums.length) {
             while (i < nums.length && curr == nums[i]) {
                curr = nums[i];
                i++;
            }
            if (i == nums.length) {
                break;
            }
            if (nums[i] == curr + 1) {
                streak = streak + 1;
                curr = nums[i];
                i++;
            }
            else {
                res = Math.max(res, streak);
                curr = nums[i];
                streak = 1;
                i++;
            }
        }
        res = Math.max(res, streak);
        return res;
    }
}
