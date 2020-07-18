package leetcode.wyj;

import leetcode.model.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode firstPoint = new ListNode();
        firstPoint.next = head;

        ListNode tempPoint = new ListNode();
        tempPoint.next = firstPoint;

        ListNode[] arrays = new ListNode[k + 1];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = tempPoint.next;
            tempPoint = tempPoint.next;
        }
        while (true) {
            //1.数组第一个next指向最后一个
            arrays[0].next = arrays[arrays.length - 1];
            //2.数组第二个next指向数组最后一个的next
            arrays[1].next = arrays[arrays.length - 1].next;
            //3.数组逐个向前指
            for (int i = arrays.length - 1; i > 1; i--) {
                arrays[i].next = arrays[i - 1];
            }

            //重置arrays[0]
            for (int i = 0; i < k; i++) {
                arrays[0] = arrays[0].next;
            }

            //重置arrays指针都向后移动k个位置，直到链表为空
            for (int i = 1; i < arrays.length; i++) {
                if (arrays[i - 1].next == null) {
                    return firstPoint.next;
                }
                arrays[i] = arrays[i - 1].next;
            }
        }

    }
}
