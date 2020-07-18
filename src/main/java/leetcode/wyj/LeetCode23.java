package leetcode.wyj;

import leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode23 {


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int length = lists.length;
        while (length > 1) {
            for (int i = 0; i < (length + 1) / 2; i++) {
                lists[i] = mergeTwoLists(lists[i * 2], i * 2 + 1 < length ? lists[i * 2 + 1] : null);
            }
            length = (length + 1) / 2;
        }
        return lists[0];

    }


    public static ListNode mergeKLists2(ListNode[] lists) {
        List<Integer> nums = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                nums.add(node.val);
                node = node.next;
            }
        }

        nums = nums.stream().sorted().collect(Collectors.toList());
        ListNode head = new ListNode();
        ListNode lastNode = head;
        for (Integer num : nums) {
            lastNode.next = new ListNode(num);
            lastNode = lastNode.next;
        }

        return head.next;

    }

    ///太慢了！！！！
    @Deprecated
    public static ListNode mergeKLists3(ListNode[] lists) {
        ListNode resultHead = new ListNode();
        ListNode lastNode = resultHead;

        //给每个都加一个头指针
        List<ListNode> headList = new ArrayList<>();
        for (ListNode node : lists) {
            ListNode listNode = new ListNode();
            listNode.next = node;
            headList.add(listNode);
        }

        ListNode point = null;

        while (true) {
            int min = Integer.MAX_VALUE;
            boolean allEmpty = true;
            //找到数组里最小的
            for (ListNode head : headList) {
                if (head.next != null) {
                    if (head.next.val < min) {
                        min = head.next.val;
                        point = head;
                    }
                    allEmpty = false;
                }
            }
            //如果全都空了，跳出循环
            if (allEmpty) {
                break;
            }
            //链接到resultHead上
            lastNode.next = point.next;
            lastNode = lastNode.next;
            point.next = point.next.next;

        }
        return resultHead.next;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
