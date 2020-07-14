package leetcode.wyj;

import java.util.HashSet;
import java.util.Set;

public class LeetCode14 {
    public static void main(String[] args) {
        String[] a = {"cc", "c"};
        System.out.println(longestCommonPrefix(a));

    }

    @Deprecated
    public static String longestCommonPrefix2(String[] strs) {
        //todo
        return "";
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int n = 0;
        StringBuffer sb = new StringBuffer("");
        while (true) {
            if (strs[0].length() == 0) {
                return "";
            }
            char init;
            if (strs[0].length() > n) {
                init = strs[0].charAt(n);
            } else {
                break;
            }

            boolean same = true;

            for (int i = 1; i < strs.length; i++) {

                String str = strs[i];
                if (str.length() <= n) {
                    same = false;
                    break;
                }
                if (str.charAt(n) != init) {
                    same = false;
                    break;
                }

            }
            if (same) {
                sb.append(init);
                n++;
            } else {
                break;
            }
        }
        return sb.toString();

    }
}
