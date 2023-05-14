class Solution {
    public int maxScore(int[] nums) {
        // int memoSize = 1 << nums.length;
        // int[] memo = new int[memoSize];
        // Arrays.fill(memo, -1);
        // return solve(nums, 0, 0, memo);
        int maxStates = 1 << nums.length;
        int finalMask = maxStates - 1;
        int[] dp = new int[maxStates];
        for(int state = finalMask;state >= 0;state--) {
            if(state == finalMask) {
                dp[state] = 0;
                continue;
            }
            int numbersTaken = Integer.bitCount(state);
            int pairsFormed = numbersTaken / 2;
            if(numbersTaken % 2 != 0)
                continue;
            for(int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
                for(int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                    if(((state >> firstIndex) & 1) == 1 || ((state >> secondIndex) & 1) == 1)
                        continue;
                    int currentScore = (pairsFormed + 1) * gcd(nums[firstIndex], nums[secondIndex]);
                    int stateAfterPickingCurrPair = state | (1 << firstIndex) | (1 << secondIndex);
                    int remainingScore = dp[stateAfterPickingCurrPair];
                    dp[state] = Math.max(dp[state], currentScore + remainingScore);
                }
            }
        }
        return dp[0];
    }
    int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    // int solve(int[] nums, int mask, int pairsPicked, int[] memo) {
    //     if(2 * pairsPicked == nums.length)
    //         return 0;
    //     if(memo[mask] != -1)
    //         return memo[mask];
    //     int maxScore = 0;
    //     for(int firstIndex = 0;firstIndex < nums.length;firstIndex++) {
    //         for(int secondIndex = firstIndex + 1;secondIndex < nums.length;secondIndex++) {
    //             if(((mask >> firstIndex) & 1) == 1 || ((mask >> secondIndex) & 1) == 1)
    //                 continue;
    //             int newMask = mask | (1 << firstIndex) | (1 << secondIndex);
    //             int curScore = (pairsPicked + 1) * gcd(nums[firstIndex], nums[secondIndex]);
    //             int remainingScore = solve(nums, newMask, pairsPicked + 1, memo);
    //             maxScore = Math.max(maxScore, curScore + remainingScore);
    //         }
    //     }
    //     return memo[mask] = maxScore;
    // }
}