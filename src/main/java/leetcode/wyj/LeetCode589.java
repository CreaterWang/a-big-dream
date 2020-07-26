package leetcode.wyj;

import leetcode.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode589 {
    public static void main(String[] args) {
        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(5));
        list1.add(new Node(6));

        List<Node> list2 = new ArrayList<>();
        list2.add(new Node(3, list1));
        list2.add(new Node(2));
        list2.add(new Node(4));

        Node node = new Node(1, list2);
        preorder2(node);
    }

    /*1.使用递归*/
    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        getValue(root, res);
        return res;
    }

    private static void getValue(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.getVal());

        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                getValue(child, res);
            }
        }
    }


    /**
     * 不使用递归，使用栈模拟递归
     **/
    public static List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return null;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.getVal());
            List<Node> children = node.getChildren();
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return res;
    }


}
