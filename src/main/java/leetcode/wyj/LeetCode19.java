package leetcode.wyj;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode19 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        removeNthFromEnd2(listNode, 2);
    }

    //一趟扫描实现
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode result = head;
        int i = 0;
        int length = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            map.put(i, head);
            head = head.next;
            length++;
            i++;
        }
        int target = length - n;
        if (target == 0) {
            return map.get(1);
        }
        map.get(target - 1).next = map.get(target + 1);
        return result;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode result = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        int target = length - n;
        if (target == 0) {
            return result.next;
        }

        head = result;
        for (int i = 0; i < target - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;

        return result;
    }

}
