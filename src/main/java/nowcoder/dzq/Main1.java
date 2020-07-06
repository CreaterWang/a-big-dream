package nowcoder.dzq;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 复制
 * 5 7
 * 输出
 * 复制
 * 35
 * @Date 2020/7/6 9:46
 * @Author 董泽琦
 **/
public class Main1 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int maxValue = getMaxValue3(a,b);
        System.out.println(a*b/maxValue);
    }
    /**
    * @method: getMaxValue
    * @description: 更相减损法
    * @date: 2020/7/6 9:52
    * @author: 董泽琦
    * @Param [a, b]
    * @return: int
    */
    public static int getMaxValue1 (int a,int b){
        if(a==b){
            return a;
        }
        return a>b?getMaxValue1(b,a-b):getMaxValue1(a,b-a);
    }
    /**
     * @method: getMaxValue2
     * @description: 辗转相除法
     * @date: 2020/7/6 9:52
     * @author: 董泽琦
     * @Param [a, b]
     * @return: int
     */
    public static int getMaxValue2 (int a,int b){
        int temp = 0;
        if (a<b){
            temp=b;
            b=a;
            a=temp;
        }
        while (b != 0){
            temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    /**
     * @method: getMaxValue3
     * @description: 辗转相除法
     * @date: 2020/7/6 9:52
     * @author: 董泽琦
     * @Param [a, b]
     * @return: int
     */
    public static int getMaxValue3 (int a,int b){
        if (b == 0){
            return a;
        }
        return a>b?getMaxValue3(b,a%b):getMaxValue3(a,b%a);
    }
}
