package leetcode;

public class S2265 {
    public int averageOfSubtree(TreeNode root) {
        return av(root)[2];
    }

    private int[] av(TreeNode root) {
        if(root==null) {
            return new int[]{0,0,0};
        }
        int[] la=av(root.left);
        int[] ra=av(root.right);
        int s = la[0]+ra[0]+root.val;
        int n = la[1]+ra[1]+1;
        int i = s/n==root.val?1:0;
        return new int[]{s,n,i+la[2]+ra[2]};
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
