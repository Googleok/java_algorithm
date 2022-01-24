package leetcode.easy;

/**
 * https://leetcode.com/problems/same-tree
 */
public class same_tree {

    public static void main(String[] args) {
        same_tree sol = new same_tree();
        System.out.println(
                sol.isSameTree(
                        new TreeNode(1, new TreeNode(4), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(2), new TreeNode(3))
                ));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
