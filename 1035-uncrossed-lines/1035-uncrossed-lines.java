class Solution {
    int[][] memo;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // memo = new int[nums1.length + 1][nums2.length + 1];
        // return solve(nums1.length, nums2.length, nums1, nums2);
        int[] dp = new int[n2 + 1];
        int[] dpPrev = new int[n2 + 1];
        for(int i = 1;i <= n1;i++) {
            for(int j = 1;j <= n2;j++) {
                if(nums1[i - 1] == nums2[j - 1])
                    dp[j] = 1 + dpPrev[j - 1];
                else
                    dp[j] = Math.max(dp[j - 1], dpPrev[j]);
            }
            dpPrev = dp.clone();
        }
        return dp[n2];
    }
    int solve(int i, int j, int[] nums1, int[] nums2) {
        if(i <= 0 || j <= 0)
            return 0;
        if(memo[i][j] != 0)
            return memo[i][j];
        if(nums1[i - 1] == nums2[j - 1])
            return memo[i][j] = 1 + solve(i - 1, j - 1, nums1, nums2);
        return memo[i][j] = Math.max(solve(i, j - 1, nums1, nums2), solve(i - 1, j, nums1, nums2));
    }
}