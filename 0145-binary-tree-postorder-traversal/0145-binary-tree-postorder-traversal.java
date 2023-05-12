/**
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
    public List<Integer> postorderTraversal(TreeNode root) {
        return postOrderIter(root, new ArrayList<>());
    }
    public List<Integer> postOrderIter(TreeNode root, List<Integer> l) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode temp;
        while(cur != null || !st.isEmpty()) {
            if(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            else {
                temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    l.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        l.add(temp.val);
                    }
                }
                else
                    cur = temp;
            }
        }
        return l;
    }
}