package leetcode.wyj;


import leetcode.model.TreeNode;

public class LeetCode450 {
    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(2);
        TreeNode root4 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        root3.left = root2;
        root3.right = root4;

        TreeNode root7 = new TreeNode(7);
        TreeNode root6 = new TreeNode(6);
        root6.right = root7;

        TreeNode root = new TreeNode(5);
        root.left = root3;
        root.right = root6;

        deleteNode(root, 3);

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode rightMin = findRightMin(root.right);
            root.val = rightMin.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    /*查找右子数的最小值*/
    public static TreeNode findRightMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
