package leetcode.dzq;

import leetcode.model.ListNode;

/**
 * @Description: K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode25
 * @Author: dongzeqi
 * @Date: 2020/7/18 22:15
 * @Version: 1.0
 */
public class LeetCode25 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(reverseKGroup(listNode,2));

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode listNode1 = listNode;
        boolean flag = true;
        while (flag){
            ListNode right = head;
            ListNode temp = new ListNode(0);
            ListNode left = temp;
            for (int i = 0; i < k; i++) {
                if (head == null){
                    flag = false;
                    break;
                }else {
                    temp.next = head;
                    temp = temp.next;
                    head = head.next;
                    right = right.next;
                }
            }
            if (flag){
                temp.next = null;
                listNode.next = reverseGroup(left.next);
                left.next.next = right;
                listNode = left.next;
            }else {
                listNode = left.next;
            }
        }
        return listNode1.next;
    }
    public static ListNode reverseGroup(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
