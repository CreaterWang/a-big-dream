package leetcode.dzq;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode1
 * @Author: dongzeqi
 * @Date: 2020/7/5 20:00
 * @Version: 1.0
 */
public class LeetCode3 {

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        lengthOfLongestSubstring(str1);
        String str2 = "bbbbb";
        lengthOfLongestSubstring(str2);
        String str3 = "pwwkew";
        lengthOfLongestSubstring(str3);
        String str4 = " ";
        lengthOfLongestSubstring(str4);
        String str5 = "aab";
        lengthOfLongestSubstring(str5);
        String str6 = "cdd";
        lengthOfLongestSubstring(str6);
        String str7 = "dvdf";
        lengthOfLongestSubstring(str7);
    }
    /**
     * @Description 最长字符串
     * @Author dongzeqi
     * @Date 2020/7/5 20:19
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int maxIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c) && charMap.get(c) > maxIndex){
                maxIndex = charMap.get(c);
            }
            if (max < i-maxIndex){
                max = i-maxIndex;
            }
            charMap.put(c,i);
        }
        System.out.println(max);
        return max;
    }
}
