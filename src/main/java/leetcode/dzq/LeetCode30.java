package leetcode.dzq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode30
 * @Author: dongzeqi
 * @Date: 2020/7/20 21:43
 * @Version: 1.0
 */
public class LeetCode30 {
    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo","bar"};
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        System.out.println(findSubstring(s,words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0){
            return result;
        }
        Map<String,Integer> map = new HashMap<>();
        int len = 0;
        int allLen = 0;
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.containsKey(words[i])?map.get(words[i])+1:1);
            len = words[i].length();
        }
        allLen = len*words.length;
        for (int i = 0; i <= s.length()-allLen; i++) {
            Map<String,Integer> map1 = new HashMap<>();
            int j = 0;
            while (len*(j+1) <= allLen){
                String str = s.substring(i + len * j, i + len * (j + 1));
                if (map.containsKey(str)){
                    map1.put(str,map1.containsKey(str)?map1.get(str)+1:1);
                    if (map1.containsKey(str) && map.get(str) < map1.get(str)){
                        break;
                    }
                    j++;
                }else{
                    break;
                }
            }
            if (len*j==allLen){
                result.add(i);
            }
        }
        return result;
    }
}
