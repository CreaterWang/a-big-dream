package leetcode.wyj;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class leetCode3 {

    /**
     * 两个指针 i和j  分别为最长不重复字符串的头和尾
     * 当j指的字符 与前面有重复 则 i 向后移动
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() - maxLength && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    /**
     * 两个指针 i和j  分别为最长不重复字符串的头和尾
     * 当j指的字符 与前面有重复 则 i 直接向后移动到重复字符的后一个字符的位置
     * LeetCode执行貌似没快多少
     */
    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() - maxLength && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                char c = s.charAt(j);

                while (true) {
                    if (c == s.charAt(i)) {
                        set.remove(s.charAt(i++));
                        break;
                    }
                    set.remove(s.charAt(i++));
                }

            }
        }
        return maxLength;
    }


    /**
     * 使用map优化第二个算法，没什么乱用，不快
     */
    public int lengthOfLongestSubstring3(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap();
        while (i < s.length() - maxLength && j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                int v = map.get(c) + 1;
                while (i < v) {
                    map.remove(s.charAt(i++));
                }

                map.put(c, j);
                j++;
            } else {
                map.put(s.charAt(j), j);
                j++;
                maxLength = Math.max(j - i, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring4("pwwkew");
    }
    /**
     * 用队列
     */
    public static int lengthOfLongestSubstring4(String s) {
        int maxLength = 0;
        Queue<Character> queue = new ArrayDeque();
        Set<Character> set = new HashSet<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                queue.add(c);
                while (true) {
                    set.remove(queue.peek());
                    if(c == queue.poll()){
                        break;
                    }
                }
                set.add(c);

            } else {
                queue.add(c);
                set.add(c);
                maxLength = Math.max(queue.size(), maxLength);
            }
            i++;
        }
        return maxLength;
    }
}
