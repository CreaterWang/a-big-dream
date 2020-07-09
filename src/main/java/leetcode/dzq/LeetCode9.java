package leetcode.dzq;

/**
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode1
 * @Author: dongzeqi
 * @Date: 2020/7/5 20:00
 * @Version: 1.0
 */
public class LeetCode9 {

    public static void main(String[] args) {
        try {
            System.out.println(isPalindrome(0));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @Description  判断一个整数是否是回文数
     * @Author dongzeqi
     * @Date 2020/7/8 22:43
     */
    public static boolean isPalindrome(int x) {
        boolean flag = false;
        int x1 = x;
        if (x >= 0){
            int i = 0;
            while (x>0){
                 i = 10*i+(x%10);
                 x = x/10;
            }
            flag = x1==i;
        }
        return flag;
    }
}
