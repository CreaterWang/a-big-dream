package leetcode.wyj;

import java.util.*;

public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, List<String>> map = new HashMap();
        map.put('2', Arrays.asList(new String[]{"a", "b", "c"}));
        map.put('3', Arrays.asList(new String[]{"d", "e", "f"}));
        map.put('4', Arrays.asList(new String[]{"g", "h", "i"}));
        map.put('5', Arrays.asList(new String[]{"j", "k", "l"}));
        map.put('6', Arrays.asList(new String[]{"m", "n", "o"}));
        map.put('7', Arrays.asList(new String[]{"p", "q", "r", "s"}));
        map.put('8', Arrays.asList(new String[]{"t", "u", "v"}));
        map.put('9', Arrays.asList(new String[]{"w", "x", "y", "z"}));

        if (digits.length() == 1) {
            return map.get(digits.charAt(0));
        }

        List<String> list = Arrays.asList(new String[]{""});
        for (int i = 0; i < digits.length(); i++) {
            List<String> list2 = map.get(digits.charAt(i));

            list = combine(list, list2);
        }
        return list;

    }
    private List<String> combine(List<String> str1, List<String> str2) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str1.size(); i++) {
            for (int j = 0; j < str2.size(); j++) {
                result.add(str1.get(i) + str2.get(j));
            }
        }
        return result;
    }
}
