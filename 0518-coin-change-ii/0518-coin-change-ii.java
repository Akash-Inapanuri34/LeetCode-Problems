class Solution {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, amount, coins, dp);
    }

    private int solve(int index, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }

        if (index == coins.length || amount < 0) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int take = solve(index, amount - coins[index], coins, dp);
        int notTake = solve(index + 1, amount, coins, dp);

        return dp[index][amount] = take + notTake;
    }
}