class Solution {
    int mod = 1_000_000_007;
    int[] memo;
    public int countGoodStrings(int low, int high, int zero, int one) {
        // int[] dp = new int[high + 1];
        // dp[0] = 1;
        // for(int i = 1;i <= high;i++) {
        //     if(i >= zero)
        //         dp[i] += dp[i - zero];
        //     if(i >= one)
        //         dp[i] += dp[i - one];
        //     dp[i] %= mod;
        // }
        // int ans = 0;
        // for(int i = low;i <= high;i++)
        //     ans = (ans + dp[i]) % mod;
        // return ans;
        
        memo = new int[high + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        int ans = 0;
        for(int i = low;i <= high;i++)
            ans = (ans + solve(i, zero, one)) % mod;
        return ans;
    }
    public int solve(int i, int zero, int one) {
        if(memo[i] != -1)
            return memo[i];
        int cnt = 0;
        if(i >= zero)
            cnt += solve(i - zero, zero, one);
        if(i >= one)
            cnt += solve(i - one, zero, one);
        return memo[i] = cnt % mod;
    }
}