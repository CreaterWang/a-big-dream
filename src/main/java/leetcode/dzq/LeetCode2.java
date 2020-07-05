package leetcode.dzq;

/**
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode2
 * @Author: dongzeqi
 * @Date: 2020/7/5 20:00
 * @Version: 1.0
 */
public class LeetCode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(2);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        addTwoNumbers(l1,l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode temp = new ListNode(0);
      ListNode result = temp;
      int num = 0;
      while (l1 != null || l2 != null){
          int i = l1==null?0:l1.val;
          int j = l2==null?0:l2.val;
          int sum = i+j+num;
          num = sum/10;
          temp.next = new ListNode(sum%10);
          temp = temp.next;
          l1 = l1==null?l1:l1.next;
          l2 = l2==null?l2:l2.next;
      }
      if (num>0){
          temp.next = new ListNode(num);
      }
      return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}