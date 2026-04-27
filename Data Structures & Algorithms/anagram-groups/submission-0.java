class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(char c : str.toCharArray()) freq[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; ++i) {
                sb.append(freq[i]);
                sb.append('|');
            }
            map.computeIfAbsent(sb.toString(), k->new ArrayList<>()).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> ll : map.values()) ans.add(ll);
        return ans;
    }
}
