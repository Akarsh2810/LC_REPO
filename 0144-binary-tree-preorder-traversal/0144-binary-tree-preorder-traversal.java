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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preOrder(root, new ArrayList<>());
    }
    public static List<Integer> preOrder(TreeNode root, List<Integer> l) {
        if(root == null)
            return l;
        l.add(root.val);
        preOrder(root.left, l);
        preOrder(root.right, l);
        return l;
    }
    public static void preOrderIter(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode d = st.pop();
            System.out.print(d.val + " ");
            if(d.right != null)
                st.push(d.right);
            if(d.left != null)
                st.push(d.left);
        }
    }
    public static void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void inOrderIter(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        while(true) {
            if(root != null) {
                st.push(root);
                root = root.left;
            }
            else {
                if(st.isEmpty())
                    break;
                root = st.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }
    public static void postOrder(TreeNode root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public static void postOrderIter(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if(root.left != null)
                st1.push(root.left);
            if(root.right != null)
                st1.push(root.right);
        }
        while(!st2.isEmpty())
            System.out.print(st2.pop().val + " ");
    }
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
    }
}