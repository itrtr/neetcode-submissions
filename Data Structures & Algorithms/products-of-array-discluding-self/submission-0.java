class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixMul = new int[nums.length];
        int[] suffixMul = new int[nums.length];

        prefixMul[0] = nums[0];
        suffixMul[nums.length-1] = nums[nums.length-1];
        for(int i=1; i<nums.length; ++i) {
            prefixMul[i] = prefixMul[i-1] * nums[i];
        }

        for(int i=nums.length-2; i>=0; --i) {
            suffixMul[i] = suffixMul[i+1] * nums[i];
        }

        int[] ans = new int[nums.length];
        ans[0] = suffixMul[1];
        ans[nums.length-1] = prefixMul[nums.length-2];
        for(int i=1; i<nums.length-1; ++i) {
            ans[i] = prefixMul[i-1] * suffixMul[i+1];
        }
        return ans;
    }
}  
