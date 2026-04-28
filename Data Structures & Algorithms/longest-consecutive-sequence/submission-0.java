class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, 1);
        int ans = 0;
        for(int num : map.keySet()) {
            if (map.get(num) == -1) continue;
            int curr = num+1;
            int additionalCount = 1;
            while(map.containsKey(curr)) {
                additionalCount += map.get(curr);
                if (map.get(curr) > 1) break;
                map.put(curr, -1);
                curr++;
            }
            ans = Math.max(ans, additionalCount);
            map.put(num, additionalCount);
        }
        return ans;
    }
}
