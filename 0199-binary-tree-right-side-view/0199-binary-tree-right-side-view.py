# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        if root == None:
            return []
        qu = [root]
        res = []
        while qu:
            n = len(qu)
            for i in range(n):
                curr = qu.pop(0)
                if i == n-1:
                    res.append(curr.val)
                if curr.left:
                    qu.append(curr.left)
                if curr.right:
                    qu.append(curr.right)
        return res      