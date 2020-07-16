package leetcode.wyj;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode22 {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        list.add("(");
        for (int i = 1; i < n * 2; i++) {
            list = getList(list, n);
        }
        return list;
    }

    public static List<String> getOne(String str, int n) {
        int leftNum = 0;
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftNum++;
                total++;
            } else {
                total--;
            }
        }
        List<String> list = new ArrayList<>();
        if (total > 0) {
            list.add(str + ')');
        }
        if (leftNum < n) {
            list.add(str + '(');
        }

        return list;
    }

    public static List<String> getList(List<String> list, int n) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.addAll(getOne(s, n));
        }
        return result;

    }
}
