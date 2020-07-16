package leetcode.wyj;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultPoint = new ListNode();
        ListNode head = resultPoint;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                resultPoint.next = l2;
                break;
            }
            if (l2 == null) {
                resultPoint.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                resultPoint.next = l1;
                l1 = l1.next;
            } else {
                resultPoint.next = l2;
                l2 = l2.next;
            }
            resultPoint = resultPoint.next;

        }
        return head.next;

    }
}
