package leetcode.dzq;

/**
 * @Description: 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode29
 * @Author: dongzeqi
 * @Date: 2020/7/20 20:11
 * @Version: 1.0
 */
public class LeetCode29 {
    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = -1;
        System.out.println(divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) {
            divisor = -divisor;
        }
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1) && temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }

    public static int divide1(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        int flag = 1;
        if (dividend > 0){
            dividend = 0-dividend;
            flag = 0-flag;
        }
        if (divisor > 0){
            divisor = 0-divisor;
            flag = 0-flag;
        }
        int i = 1;
        while (dividend <= 0){
            dividend = dividend-divisor;
            i--;
        }
        if (i == Integer.MIN_VALUE && flag == 1){
            i = 0-Integer.MAX_VALUE;
        }
        return flag>0?(int)(0-i):(int)i;
    }
}
