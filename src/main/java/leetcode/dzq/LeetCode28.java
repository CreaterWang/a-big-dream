package leetcode.dzq;

/**
 * @ClassName LeetCode28
 * @Description 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/7/20 14:48
 * @Author 董泽琦
 **/
public class LeetCode28 {
    public static void main(String[] args) {
//        String haystack = "hello";
//        String needle = "ll";
//        String haystack = "aaaaa";
//        String needle = "bba";
//        String haystack = "";
//        String needle = "";
        String haystack = "mississippi";
        String needle = "pi";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        for (int i = 0; i <= hLen - nLen; i++){ // 等于，适用于两者长度相等的情况下（包含都为 ”“）
            int j = 0;
            while (j < nLen){
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == nLen){
                return i;
            }
        }
        return -1;
    }
    public static int strStr1(String haystack, String needle) {
        int index = -1;
        if (needle.length() ==0){
            return 0;
        }
        if (haystack.length() == 0 || haystack.length()<needle.length()){
            return index;
        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return index;
    }
    public static int strStr2(String haystack, String needle) {
        int index = -1,j = 0;
        if (needle.length() ==0){
            return 0;
        }
        if (haystack.length() == 0 || haystack.length()<needle.length()){
            return index;
        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)){
                while (j < needle.length()){
                    if (haystack.charAt(i+j) != needle.charAt(j)){
                        j=0;
                        break;
                    }else{
                        if (j == needle.length()-1){
                            return i;
                        }
                    }
                    j++;
                }
            }else{
                j = 0;
            }
        }
        return index;
    }
}
