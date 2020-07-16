package leetcode.dzq;

import leetcode.model.ListNode;

/**
 * @Description: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode19
 * @Author: dongzeqi
 * @Date: 2020/7/14 22:38
 * @Version: 1.0
 */
public class LeetCode19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        System.out.println(removeNthFromEnd(head,2));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode result1 = head;
        if(n == 0){
            return result;
        }
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null && head.next != null){
            head = head.next;
            result1 = result1.next;
        }
        if (head == null){
            return result.next;
        }
        result1.next = result1.next.next;
        return result;
    }
}
