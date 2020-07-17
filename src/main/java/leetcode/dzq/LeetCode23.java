package leetcode.dzq;

import leetcode.model.ListNode;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Description: 合并链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode23
 * @Author: dongzeqi
 * @Date: 2020/7/16 22:13
 * @Version: 1.0
 */
public class LeetCode23 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{listNode,listNode1,listNode2};
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        while (length>1){
            for (int i = 0; i < length / 2; i++) {
                lists[i] = LeetCode21.mergeTwoLists(lists[i],lists[length-1-i]);
            }
            length = (length+1)/2;
        }
        return lists[0];
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode listNode1 = new ListNode();
        ListNode listNode = listNode1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null){
                list.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            listNode1.next = new ListNode(list.get(i));
            listNode1 = listNode1.next;
        }
        return listNode.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode listNode1 = new ListNode();
        ListNode listNode = listNode1;
        boolean flag = true;
        int min;
        int index = -1;
        while (flag){
            flag = false;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null){
                    flag = true;
                    if (min >= lists[i].val){
                        min = lists[i].val;
                        index = i;
                    }
                }
            }
            if (flag){
                lists[index] = lists[index].next;
                listNode1.next = new ListNode(min);
                listNode1 = listNode1.next;
            }
        }
        return listNode.next;
    }
}
