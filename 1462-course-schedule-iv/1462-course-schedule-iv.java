class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] reach = new boolean[numCourses][numCourses];

        for (int[] p : prerequisites) {
            reach[p[0]][p[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            ans.add(reach[q[0]][q[1]]);
        }

        return ans;
    }
}