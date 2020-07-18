package leetcode.dzq;

import leetcode.model.ListNode;

/**
 * @Description: 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode24
 * @Author: dongzeqi
 * @Date: 2020/7/18 21:42
 * @Version: 1.0
 */
public class LeetCode24 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(swapPairs(listNode));

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode listNode1 = listNode;
        while (head != null && head.next != null){
            listNode.next = head.next;
            head.next = head.next.next;
            listNode.next.next = head;
            listNode = listNode.next.next;
            head = head.next;
        }
        return listNode1.next;
    }
}
