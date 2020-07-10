package leetcode.dzq;

/**
 * @Description: 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode1
 * @Author: dongzeqi
 * @Date: 2020/7/9 22:32
 * @Version: 1.0
 */
public class LeetCode12 {

    public static void main(String[] args) {
        try {
            int num = 58;
            System.out.println(intToRoman(num));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Description 没什么意义 你要愿意可以把所有数字情况都列出来
     * @Author dongzeqi
     * @Date 2020/7/10 0:13
     */
    public static String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
    /**
     * @Description 数字转换罗马数字
     * @Author dongzeqi
     * @Date 2020/7/10 0:13
     */
    public static String intToRoman1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanChar = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                roman.append(romanChar[i]);
            }
        }
        return roman.toString();
    }
    /**
     * @Description 数字转换罗马数字
     * @Author dongzeqi
     * @Date 2020/7/9 23:44
     */
    public static String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        Character[] romanChar = new Character[]{'I','V','X','L','C','D','M'};
        if (num>0 && num<4000){
            int i = 0;
            int index = 0;
            while (num>0){
                i = num%10;
                if (i<4){
                    while (i>0){
                        roman.insert(0,romanChar[index]);
                        i--;
                    }
                }else if (i == 4){
                    roman.insert(0,romanChar[index]);
                    roman.insert(1,romanChar[index+1]);
                    i=0;
                }else if (i<9){
                    roman.insert(0,romanChar[index+1]);
                    i=i-5;
                    while (i>0){
                        roman.insert(1,romanChar[index]);
                        i--;
                    }
                }else {
                    roman.insert(0,romanChar[index]);
                    roman.insert(1,romanChar[index+2]);
                    i=0;
                }
                index=index+2;
                num = num/10;
            }
        }
        return roman.toString();
    }
}
