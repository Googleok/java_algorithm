package leetcode.easy;

public class symmetric_tree {
    public static void main(String[] args) {
        symmetric_tree sol = new symmetric_tree();
    }

    public static class TreeNode {
        int val;
        same_tree.TreeNode left;
        same_tree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, same_tree.TreeNode left, same_tree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
