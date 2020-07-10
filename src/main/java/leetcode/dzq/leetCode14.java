package leetcode.dzq;

/**
 * @Description:编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: leetCode14
 * @Author: dongzeqi
 * @Date: 2020/7/10 21:44
 * @Version: 1.0
 */
public class leetCode14 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","f"};
        System.out.println(longestCommonPrefix(strs));
    }
    /**
     * @Description 最长公共前缀
     * @Author dongzeqi
     * @Date 2020/7/10 21:44
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int index = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int strIndex = 0;
            for (int j = 0; j < index && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)){
                    break;
                }
                strIndex++;
            }
            index = strIndex;
        }
        return strs[0].substring(0,index);
    }

    /**
     * @Description 最长公共前缀
     * @Author dongzeqi
     * @Date 2020/7/10 21:44
     */
    public static String longestCommonPrefix1(String[] strs) {
        StringBuffer result = new StringBuffer();
        if (strs.length>0){
            boolean flag = true;
            for (int i = 0; i < strs[0].length(); i++) {
                if (strs[0].length()>0){
                    char s = strs[0].charAt(i);
                    for (int j = 1; j < strs.length; j++) {
                        if (i == strs[j].length()){
                            return result.toString();
                        }
                        if (s != strs[j].charAt(i)) {
                            flag = false;
                        }
                    }
                    if (flag){
                        result.append(s);
                    }
                }
            }
        }
        return result.toString();
    }
}
