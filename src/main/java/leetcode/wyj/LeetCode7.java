package leetcode.wyj;

public class LeetCode7 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            int pop = x % 10;

            x = x / 10;

            //检查溢出
            if (n > Integer.MAX_VALUE / 10 || (n == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (n < Integer.MIN_VALUE / 10 || (n == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            n = n * 10 + pop;
        }
        return n;

    }
}
