package leetcode.wyj;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode6 {


    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= numRows; i++) {

            if (i == 1) {
                int index = i - 1;
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    index += (numRows - 1) * 2;
                }
            } else if (i == numRows) {
                int index = i - 1;
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    index += (numRows - 1) * 2;
                }
            } else {
                int index = i - 1;
                int num = i - 1;
                int n = 0;
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    if (n % 2 == 0) {
                        index += (numRows - num - 1) * 2;
                        n++;
                    } else {
                        index += ((numRows - 1) * 2 - (numRows - num - 1) * 2);
                        n++;
                    }

                }
            }
        }
        return sb.toString();
    }


    /**
     * 两年前的代码？？为什么这么简洁
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<numRows;i++){
            int flag = i;
            while (flag<s.length()){
                sb.append(s.charAt(flag));
                if(i!=0 && i!=numRows-1 && flag-2*i+2*numRows-2<s.length()){
                    sb.append(s.charAt(flag-2*i+2*numRows-2));
                }
                flag += 2*numRows-2;
            }
        }
        return sb.toString();
    }
}
