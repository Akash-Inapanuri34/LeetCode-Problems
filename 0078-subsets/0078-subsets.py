class Solution(object):
    def subsets(self, nums):
        res = []
        n = len(nums)
        def solve(temp, i):
            if i>=n:
                res.append(list(temp))
                return
            temp.append(nums[i])#select
            solve(temp, i + 1)#explore
            temp.pop()#backtrack
            solve(temp, i + 1)#explore
        solve([],0)
        return res
        