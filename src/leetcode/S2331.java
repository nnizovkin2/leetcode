package leetcode;

public class S2331 {
    public boolean evaluateTree(TreeNode node) {
        if (node.left == null) {
            return node.val == 1;
        }

        return node.val == 2 ? evaluateTree(node.left) || evaluateTree(node.right) :
                evaluateTree(node.left) && evaluateTree(node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}