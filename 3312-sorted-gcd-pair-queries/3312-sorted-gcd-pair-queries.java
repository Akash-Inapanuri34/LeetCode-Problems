class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Frequency of each number
        long[] freq = new long[max + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // cnt[g] = count of numbers divisible by g
        long[] cnt = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt[g] += freq[multiple];
            }
        }

        // exact[g] = number of pairs having gcd exactly g
        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long pairs = cnt[g] * (cnt[g] - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                pairs -= exact[multiple];
            }

            exact[g] = pairs;
        }

        // Prefix sum of pair counts
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int left = 1, right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}