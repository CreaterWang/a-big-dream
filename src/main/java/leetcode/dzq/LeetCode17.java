package leetcode.dzq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

/**
 * @Description: 电话数字转字符串
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode17
 * @Author: dongzeqi
 * @Date: 2020/7/13 21:46
 * @Version: 1.0
 */
public class LeetCode17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    /**
     * @Description 递归
     * @Author dongzeqi
     * @Date 2020/7/13 22:41
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0){
            return list;
        }
        Map<String,String> map = new HashMap<String,String>(){{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        addStrList("",digits,map,list);
        return list;
    }
    public static List<String> addStrList(String preStr,String digits,Map<String,String> map,List<String> list){
        if (digits.length() == 0){
            list.add(preStr);
        }else {
            String s = map.get(digits.substring(0, 1));
            for (int i = 0; i < s.length(); i++) {
                addStrList(preStr+s.charAt(i),digits.substring(1),map,list);
            }
        }
        return list;
    }

    /**
     * @Description 遍历实现
     * @Author dongzeqi
     * @Date 2020/7/13 22:42
     */
    public static List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        if (digits.length()>0){
            result.add("");
        }
        while (digits.length()>0){
            List<String> strList = new ArrayList<>();
            for (String preStr: result) {
                for (char charStr:map.get(digits.charAt(0))) {
                    strList.add(preStr+charStr);
                }
            }
            digits = digits.substring(1);
            result = strList;
        }
        return result;
    }
}
