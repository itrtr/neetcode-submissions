class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length());
            sb.append('|');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int idx = 0;
        while(idx < str.length()) {
            // extract till first '|' sign
            int endIdx = idx+1;
            while(str.charAt(endIdx) != '|') endIdx++;
            int length = Integer.valueOf(str.substring(idx, endIdx));
            idx = endIdx+1;
            strs.add(str.substring(idx, idx+length));
            idx += length;
        }
        return strs;
    }
}
