class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] left = new int[N];
        int[] right = new int[N];
        
        left[0] = height[0];
        right[N-1] = height[N-1];

        for(int i=1; i<N; ++i) left[i] = Math.max(height[i], left[i-1]);
        for(int i=N-2; i>=0; --i) right[i] = Math.max(height[i], right[i+1]);

        int ans = 0;
        for(int i=1; i<N-1; ++i) {
            int minHeight = Math.min(left[i-1], right[i+1]);
            int diff = Math.max(0, minHeight-height[i]);
            ans += diff;
        }
        return ans;
    }
}
