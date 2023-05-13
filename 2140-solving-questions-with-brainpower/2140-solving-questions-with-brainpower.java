class Solution {
    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        return func(0, questions.length, questions, memo);
    }
    public long func(int i, int n, int[][] questions, long[] memo) {
        if(i >= n)
            return 0;
        if(memo[i] != 0)
            return memo[i];
        return memo[i] = Math.max(func(i + 1, n, questions, memo), questions[i][0] + (i + questions[i][1] + 1 >= n ? 0 : func(i + questions[i][1] + 1, n, questions, memo)));
    }
}