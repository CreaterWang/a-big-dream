package leetcode.wyj;

import leetcode.model.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstPoint = new ListNode();
        firstPoint.next = head;

        ListNode point1 = firstPoint;
        ListNode point2 = firstPoint.next;
        ListNode point3 = firstPoint.next.next;

        while (point3 != null) {
            point1.next = point2.next;
            point2.next = point3.next;
            point3.next = point2;

            point1 = point1.next.next;

            point2 = point1.next;
            if (point2 == null) {
                break;
            }
            point3 = point2.next;
            if (point3 == null) {
                break;
            }
        }
        return firstPoint.next;

    }
}
