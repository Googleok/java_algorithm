package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 */
public class binary_tree_inorder_traversal {

    List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        binary_tree_inorder_traversal sol = new binary_tree_inorder_traversal();
        System.out.println(sol.inorderTraversal(new TreeNode(1, new TreeNode(2), new TreeNode(3))).toString());
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        return inorderTraversal(root.right);
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
