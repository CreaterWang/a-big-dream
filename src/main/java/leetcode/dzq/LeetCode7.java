package leetcode.dzq;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode1
 * @Author: dongzeqi
 * @Date: 2020/7/5 20:00
 * @Version: 1.0
 */
public class LeetCode7 {

    public static void main(String[] args) {
        try {
            System.out.println(reverse(1463847412));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @Description 整型反转
     * @Author dongzeqi
     * @Date 2020/7/5 20:19
     */
    public static int reverse(int x) {
        int temp = 0;
        while (x != 0){
            int i = x % 10;
            if (temp > Integer.MAX_VALUE/10 || temp < Integer.MIN_VALUE/10){
                return 0;
            }
            if (temp == Integer.MAX_VALUE/10  && i>Integer.MAX_VALUE%10){
                return 0;
            }
            if (temp == Integer.MIN_VALUE/10  && i<Integer.MIN_VALUE%10){
                return 0;
            }
            temp = 10*temp + i;
            x=x/10;
        }
        return temp;
    }
}
