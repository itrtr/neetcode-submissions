class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') c = (char)(c-32);
            if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) sb.append(c);
        }

        String str = sb.toString();
        System.out.println(str);
        int i=0, j = str.length()-1;
        while(i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
