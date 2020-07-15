package leetcode.wyj;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20 {


    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Set<Character> characters = map.keySet();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!characters.contains(c)) {//左括号
                stack.push(c);
            } else {//右括号
                if (stack.isEmpty()) {
                    return false;
                }
                char leftChar = map.get(c);
                if (leftChar != stack.pop()) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;

    }

    public boolean isValid(String s) {
        char leftBig = '{';
        char rightBig = '}';
        char leftMid = '[';
        char rightMid = ']';
        char leftMin = '(';
        char rightMin = ')';
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == leftBig || c == leftMid || c == leftMin) {
                stack.push(c);
            }
            if (c == rightBig || c == rightMid || c == rightMin) {
                if (stack.isEmpty()) {
                    return false;
                }
                char leftOne = stack.pop();
                if (Math.abs(c - leftOne) > 2) {
                    return false;
                }
            }

        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }
}
