package leetcode.dzq;

import java.util.*;

/**
 * @Description: 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode22
 * @Author: dongzeqi
 * @Date: 2020/7/16 20:32
 * @Version: 1.0
 */
public class LeetCode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n>0){
            int left = 1;
            int right =0;
            list = addStr(list,"(",n,left,right);
        }
        return list;
    }

    public static List<String> addStr(List<String> list,String str,int n,int left,int right) {
        if (left == right && left < n){
            addStr(list,str+"(", n, left+1,right );
        }else if (left > right && left < n){
            addStr(list,str+"(", n, left+1,right );
            addStr(list,str+")", n, left,right+1 );
        }else if (left == n && right < n){
            addStr(list,str+")", n, left,right+1 );
        }
        if (str.length() == 2*n-1){
            list.add(str+")");
        }
        return list;
    }
}
