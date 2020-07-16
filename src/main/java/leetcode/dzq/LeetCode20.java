package leetcode.dzq;

import java.util.*;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode20
 * @Author: dongzeqi
 * @Date: 2020/7/15 22:30
 * @Version: 1.0
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
    public static boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<Character>(){{}};
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')');put('{', '}');put('[', ']');
        }};
        for (Character ch: s.toCharArray()) {
            if (map.containsKey(ch))
                list.addLast(map.get(ch));
            else if (list.isEmpty() || ch != list.removeLast())
                return false;
        }
        return list.isEmpty();
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i< s.length()){
            if (s.charAt(i) == '}'){
                if (stack.size()==0 || stack.pop() != '{'){
                    return false;
                }
            }else if (s.charAt(i) == ')'){
                if (stack.size()==0 || stack.pop() != '('){
                    return false;
                }
            }else if (s.charAt(i) == ']'){
                if (stack.size()==0 || stack.pop() != '['){
                    return false;
                }
            }else {
                stack.add(s.charAt(i));
            }
            i++;
        }
        return stack.size()==0?true:false;
    }

    public static boolean isValid2(String s) {
        int i = 0;
        while (i< s.length()){
            if (s.charAt(i) == '}'){
                if (i>0 && s.charAt(i-1) == '{'){
                    s = s.substring(0,i-1)+s.substring(i+1,s.length());
                    i=i-1;
                }else {
                    return false;
                }
            }else if (s.charAt(i) == ')'){
                if (i>0 && s.charAt(i-1) == '('){
                    s = s.substring(0,i-1)+s.substring(i+1,s.length());
                    i=i-1;
                }else {
                    return false;
                }
            }else if (s.charAt(i) == ']'){
                if (i>0 && s.charAt(i-1) == '['){
                    s = s.substring(0,i-1)+s.substring(i+1,s.length());
                    i=i-1;
                }else {
                    return false;
                }
            }else {
                i++;
            }
        }
        return s.length()==0?true:false;
    }
}
