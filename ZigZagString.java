/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int st, int en){
        List<TreeNode> ans = new ArrayList();
        if(st == en) {
            ans.add(new TreeNode(st, null, null));
            return ans;
        }
        else if(st > en){
            ans.add(null);
            return ans;
        }

        for(int i = st ; i <= en; i++){
            List<TreeNode> left = generateTree(st, i - 1);
            List<TreeNode> right = generateTree(i + 1, en);
            for(TreeNode leftNode: left){
                for(TreeNode rightNode: right){
                    TreeNode temp = new TreeNode(i, leftNode == null ? null : new TreeNode(leftNode.val, leftNode.left, leftNode.right),
                            rightNode == null ? null : new TreeNode(rightNode.val, rightNode.left, rightNode.right));
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}