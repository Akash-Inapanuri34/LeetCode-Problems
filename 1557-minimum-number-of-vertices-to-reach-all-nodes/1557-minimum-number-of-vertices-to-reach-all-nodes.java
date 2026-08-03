class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (List<Integer> i : edges) {
            inDegree[i.get(1)]++;
        }

        for (int i = 0; i <= n-1; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
        
    }
}