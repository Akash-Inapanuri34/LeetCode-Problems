class Solution {
    static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String mid = "";
        int odd = -1;

        int[] half = new int[26];
        int total = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd = i;
            }
            half[i] = freq[i] / 2;
            total += half[i];
        }

        long totalWays = countWays(half, total);
        if (totalWays < k) return "";

        StringBuilder first = new StringBuilder();

        while (total > 0) {
            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half, total - 1);

                if (ways >= k) {
                    first.append((char) ('a' + c));
                    total--;
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        if (odd != -1) {
            mid = String.valueOf((char) ('a' + odd));
        }

        StringBuilder ans = new StringBuilder();
        ans.append(first);
        ans.append(mid);
        ans.append(new StringBuilder(first).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {
        long res = 1;

        int remaining = total;

        for (int i = 0; i < 26; i++) {
            int c = cnt[i];
            if (c == 0) continue;

            res = multiply(res, comb(remaining, c));
            if (res >= LIMIT) return LIMIT;

            remaining -= c;
        }

        return res;
    }

    private long comb(int n, int r) {
        if (r > n) return 0;
        if (r > n - r) r = n - r;

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= LIMIT) return LIMIT;
        }

        return ans;
    }

    private long multiply(long a, long b) {
        if (a >= LIMIT || b >= LIMIT) return LIMIT;
        if (a == 0 || b == 0) return 0;

        if (a > LIMIT / b) return LIMIT;

        long res = a * b;
        return Math.min(res, LIMIT);
    }
}