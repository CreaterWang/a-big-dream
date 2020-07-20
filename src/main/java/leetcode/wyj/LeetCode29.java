package leetcode.wyj;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode29 {
    public static void main(String[] args) {
        System.out.println(divide(2147483647, 2));
    }

    public static int divide(int dividend, int divisor) {
        int divisorOri = divisor;
        int dividendOri = dividend;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int div = div(dividend, divisor);
        boolean isPositive = false;
        if ((dividendOri > 0 && divisorOri > 0) || (dividendOri < 0 && divisorOri < 0)) {
            isPositive = true;
        }
        if (isPositive && div == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (isPositive) {
            div = -div;
        }

        return div;
    }

    public static int div(int dividend, int divisor) {
        int divisorOri = divisor;

        if (divisor < dividend) {
            return 0;
        }
        int num = -1;
        while (dividend < divisor) {
            if (dividend >> 1 < divisor) {
                divisor = divisor << 1;
                num = num << 1;
            } else {
                return num + div(dividend - divisor, divisorOri);
            }
        }
        return num;
    }

}
