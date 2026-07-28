class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        // Build the left half and find the middle character
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) ('a' + i));
            }
        }

        // Right half is the reverse of the left half
        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}