package leetcode.dzq;

import leetcode.model.ListNode;

/**
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode21
 * @Author: dongzeqi
 * @Date: 2020/7/16 20:05
 * @Version: 1.0
 */
public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = null;
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1,l2));

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode = listNode1;
        while (l1 != null || l2 != null ){
            if (l1 == null || (l1 != null && l2 != null && l1.val > l2.val)){
                listNode1.next = l2;
                l2 = l2.next;
            }else{
                listNode1.next = l1;
                l1 = l1.next;
            }
            listNode1 = listNode1.next;

        }
        return listNode.next;
    }
}
