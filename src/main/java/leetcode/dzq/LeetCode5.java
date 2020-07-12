package leetcode.dzq;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode5
 * @Author: dongzeqi
 * @Date: 2020/7/7 20:00
 * @Version: 1.0
 */
public class LeetCode5 {

    public static void main(String[] args) {
        try {
            System.out.println(longestPalindrome("cbbd"));
            System.out.println(longestPalindrome("babad"));
            System.out.println(longestPalindrome("ac"));
            System.out.println(longestPalindrome("bb"));
            System.out.println(longestPalindrome("abcda"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @Description 求最长的回文子串
     * @Author dongzeqi
     * @Date 2020/7/5 20:19
     */
    public static String longestPalindrome(String s) {
        int max = 0;
        String maxStr = "";
        if (s.length()>1){
            maxStr = s.substring(0,1);
            max = 1;
            for (int i = 0; i < s.length()-1; i++) {
                int len1 = getIndex(s,i,i);
                int len2 = getIndex(s,i,i+1);
                int len = Math.max(len1,len2);
                if (max<len){
                    max = len;
                    maxStr = s.substring(i-(len-1)/2,i+(len/2+1));
                }
            }
        }else{
            maxStr = s;
            max = s.length();
        }
        System.out.println(max+","+maxStr);
        return maxStr;
    }
    private static int getIndex(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
