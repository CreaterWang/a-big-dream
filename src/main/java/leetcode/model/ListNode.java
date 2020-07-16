package leetcode.model;

/**
 * @Description: 链表实体
 * @ProjectName: a-big-dream
 * @Package: leetcode
 * @ClassName: ListNode
 * @Author: dongzeqi
 * @Date: 2020/7/16 20:07
 * @Version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
