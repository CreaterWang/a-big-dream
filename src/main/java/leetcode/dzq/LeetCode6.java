package leetcode.dzq;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode6
 * @Author: dongzeqi
 * @Date: 2020/7/7 22:33
 * @Version: 1.0
 */
public class LeetCode6 {

    public static void main(String[] args) {
        try {
            System.out.println(convert("PAYPALISHIRING",4));;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Description  转化字符串为Z型
     * @Author dongzeqi
     * @Date 2020/7/7 22:23
     */
    public static String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        List<StringBuffer> rowList = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            rowList.add(new StringBuffer());
        }
        int row = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            rowList.get(row).append(s.charAt(i));
            if (flag){
                row--;
            }else {
                row++;
            }
            if (row == 0 || row == numRows-1){
                flag = !flag;
            }
        }
        for (StringBuffer rowSb :rowList) {
            sb.append(rowSb);
        }
        return sb.toString();
    }

    public static String convert1(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                if (i != 0 && i != numRows-1 && (index+2*numRows-2*i-2 < s.length())) {
                    sb.append(s.charAt(index+2*numRows-2*i-2));
                }
                index += (numRows-1)*2;
            }
        }
        return sb.toString();
    }
}
