class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Set<Integer>> tm = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer,Integer> hm = new HashMap<>();

        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
            int cnt = hm.get(num); // current count
            tm.computeIfAbsent(cnt, kk->new HashSet<>()).add(num);
            if (cnt > 1) {
                tm.get(cnt-1).remove(num); // remove from previous count set
            }
        }

        int[] ans = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : tm.entrySet()) {
            for(int n : entry.getValue()) {
                if (i >= k) break;
                ans[i++] = n;
            }
        }

        return ans;
    }
}
