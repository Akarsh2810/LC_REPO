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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root == null)
            return new ArrayList<>();
        while(!st.isEmpty()) {
            Pair it = st.pop();
            if(it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.left != null)
                    st.push(new Pair(it.node.left, 1));
            }
            else if(it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.right != null)
                    st.push(new Pair(it.node.right, 1));
            }
            else
                post.add(it.node.val);
        }
        return in;
    }
}
class Pair {
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}