package leetcode.wyj;

import leetcode.model.Node;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode590 {
    public static void main(String[] args) {
        Long a = 128L;
        Long b = 128L;
        System.out.println(a == b);
//        List<Node> list1 = new ArrayList<>();
//        list1.add(new Node(5));
//        list1.add(new Node(6));
//
//        List<Node> list2 = new ArrayList<>();
//        list2.add(new Node(3, list1));
//        list2.add(new Node(2));
//        list2.add(new Node(4));
//
//        Node node = new Node(1, list2);
//        postorder2(node);
    }

    /*使用递归*/
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getValue(root, result);
        return result;
    }

    public static void getValue(Node root, List<Integer> result) {
        List<Node> children = root.getChildren();
        if (children == null) {
            return;
        }
        for (Node child : children) {
            getValue(child, result);
        }
        result.add(root.getVal());
    }


    /**
     * 不使用递归，使用栈模拟递归 超出时间限制了
     **/
    public static List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return null;
        }
        Node pre = null;
        stack.push(root);
        Set<Node> set = new HashSet<>();
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if ((cur.children == null) || (pre != null && set.contains(cur))) {
                Node pop = stack.pop();
                res.add(pop.getVal());
                //更新pre指针
                pre = cur;
            } else {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
            set.add(cur);
        }

        return res;
    }
}























