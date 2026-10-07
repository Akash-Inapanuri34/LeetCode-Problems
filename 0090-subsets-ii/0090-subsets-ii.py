class Solution(object):
    def subsetsWithDup(self, nums):
        res = []
        nums.sort()
        n = len(nums)
        def solve(temp, i):
            if i>=n:
                res.append(list(temp))
                return
            temp.append(nums[i])#select
            solve(temp, i + 1)#explore
            temp.pop()#backtrack
            while i+1<n and nums[i] == nums[i+1]: #handle duplicates
                i+=1
            solve(temp, i + 1)#explore
        solve([],0)
        return res
        