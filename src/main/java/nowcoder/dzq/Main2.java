package nowcoder.dzq;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description 题目描述
 * •计算一个数字的立方根，不使用库函数
 * 详细描述：
 *
 * •接口说明
 *
 * 原型：
 *
 * public static double getCubeRoot(double input)
 *
 * 输入:double 待求解参数
 *
 * 返回值:double  输入参数的立方根，保留一位小数
 *
 *
 * 输入描述:
 * 待求解参数 double类型
 *
 * 输出描述:
 * 输入参数的立方根 也是double类型
 *
 * 示例1
 * 输入
 * 复制
 * 216
 * 输出
 * 复制
 * 6.0
 * @Date 2020/7/6 9:46
 * @Author 董泽琦
 **/
public class Main2 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double result = getCubeRoot(a);
        System.out.println(result);
    }
    /**
    * @method: getCubeRoot
    * @description: 牛顿迭代法求立方根
    * @date: 2020/7/6 9:52
    * @author: 董泽琦
    * @Param [a, b]
    * @return: int
    */
    public static double getCubeRoot(double input){
        /*在这里实现功能*/
        if (input == 0) {
            return 0;
        }
        double x0 = input;
        double x1 = (2*x0 + input/x0/x0)/3;//利用迭代法求解
        while (Math.abs(x1 - x0) > 0.000001) {
            x0 = x1;
            x1 = (2*x0 + input/x0/x0)/3;
        }
        x1 = (double) Math.round(x1*10)/10;//保留以为小数
        return x1;
    }
    /*
    功能: 计算一个数字的四次方根
    输入:double input 待求解参数
    返回值:double	输入参数的四次方根
    */
    public static double getFour(double input) {
        /*在这里实现功能*/
        if (input == 0) {
            return 0;
        }
        double x0, x1;
        x0 = input;
        x1 = (3*x0 + input/x0/x0/x0) / 4;
        while (Math.abs(x1 - x0) > 0.000001) {
            x0 = x1;
            x1 = (3*x0 + input/x0/x0/x0) / 4;
        }
        x1 = (double) Math.round(x1*10)/10;
        return x1;
    }
}
