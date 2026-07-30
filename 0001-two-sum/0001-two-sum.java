class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                int t=j-i;
                if(nums[t]+nums[j]==target){
                    return new int[]{t,j};
                }
            }
        }
          return new int[]{};
        }
    }