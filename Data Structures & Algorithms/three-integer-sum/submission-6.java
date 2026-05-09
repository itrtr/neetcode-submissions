class Solution {
    private static final int TARGET = 0;
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int ts = nums[i] + nums[j] + nums[k];
                if (ts == TARGET) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    k--;
                    while(j < k && nums[k] == nums[k+1]) k--;
                } else if (ts < TARGET) {
                    j++;
                    while(j < k && nums[j] == nums[j-1]) j++;
                } else {
                    k--;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
