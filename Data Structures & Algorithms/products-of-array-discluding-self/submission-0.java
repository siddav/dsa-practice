class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lmul = new int[nums.length];
        int[] rmul = new int[nums.length];
        
        lmul[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lmul[i] = lmul[i - 1] * nums[i - 1];
        }
        
        rmul[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rmul[i] = rmul[i + 1] * nums[i + 1];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = lmul[i] * rmul[i];
        }
        return result;
    }
}  
